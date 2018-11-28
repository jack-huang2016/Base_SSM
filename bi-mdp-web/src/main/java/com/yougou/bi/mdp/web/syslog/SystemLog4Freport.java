package com.yougou.bi.mdp.web.syslog;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import cn.wonhigh.retail.backend.utils.JsonUtils;
import cn.wonhigh.retail.uc.common.api.service.SSOApi;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.yougou.logistics.base.common.model.SystemUser;
import com.yougou.bi.mdp.common.exception.BusinessException;
import com.yougou.bi.mdp.common.model.SysLog;
import com.yougou.bi.mdp.manager.SysLogManager;
import com.yougou.bi.mdp.web.controller.ReportsInfoController;
import com.yougou.bi.mdp.web.utils.DynamicTabTheadUtil;
import com.yougou.bi.mdp.web.utils.StringUtil;
import com.yougou.bi.mdp.web.vo.CurrentUser;


/** 
 * 基于配置文件的AOP日志示例 
 * @author huang.yj
 * @date  2018-09-26 15:33:47
 */  
public class SystemLog4Freport {  
	
	private static final XLogger logger = XLoggerFactory.getXLogger(SystemLog4Freport.class);
	
	private static final String LOG_TYPE = "固定报表";
	
	@Autowired(required = false)
	private SSOApi ssoApi;
	
	@Resource
	private SysLogManager sysLogManager;
    
    //环绕
    public Object runOnAround(ProceedingJoinPoint point) throws Throwable{
    	Object[] objects = point.getArgs();
        HttpServletRequest request = null;
        for(Object e : objects){
        	if(e instanceof HttpServletRequest){
        		request = (HttpServletRequest)e;
        		break;
        	}
        }
        Date start = new Date();
    	Object object = null;
    	Exception exception = null;
    	try{
    		object = point.proceed();
    		System.out.println(object.getClass().toString());
    	}catch (Exception e) {
    		exception = e;
		}
    	Date end = new Date();
    	String needTime = String.valueOf(end.getTime()-start.getTime());
    	//添加固定报表导出的日志
    	String methodName = point.getSignature().getName();
    	if(methodName.equals("search")){
    		saveLog(request,"search",needTime,exception);
    	}else if(methodName.equals("searchForDownload")){
    		saveLog(request,"searchForDownload",needTime,exception);
    	}
    	if(exception != null){
    		throw exception;
    	}
    	return object;
    }  
    
    //保存模块级别操作日志
    private void saveLog(HttpServletRequest request , String methodsName , String needTime , Exception exception){
    	//获取并校验用户相关信息
    	String organName = null;
    	String userLoginName = null;
    	String operator = null;
    	String ip = null;
    	String regionName = null;
    	String errorMsg = "success";
    	if(exception != null){
    		if (exception instanceof BusinessException) {
    			//如果是未查询到数据，则errorMsg = "success";
    			if(((BusinessException) exception).getCode().equals("20-9999")){
    				errorMsg = "success";
    			}else{
    				errorMsg = "error : " + ((BusinessException)exception).getMessage();
    			}
    		}else{
    			errorMsg = "error : 系统失败,错误未知.";
    		}
    	}
        try {
        	SystemUser user = CurrentUser.getCurrentUser(request);
        	organName = user.getOrganName();
        	userLoginName = user.getLoginName();
        	operator = user.getUsername();
        	ip = request.getRemoteAddr();
        	RegionParseForSystemLog parse=new RegionParseForSystemLog(user.getOrganNo(), user.getOrganName(), user.getOrganLevel());
        	regionName = parse.getRegionForSystemLog();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        if(StringUtils.isEmpty(organName) || StringUtils.isEmpty(userLoginName) || StringUtils.isEmpty(operator)){
        	return;
        }
        //获取并校验,固定报表相关信息
        List<JSONObject> menuTreeList = null;
        String modelNo = null;
        String modelName = null;
        try{
        	menuTreeList = ReportsInfoController.getUserMenuTree(request , ssoApi);
        	modelNo = getFreportID(request);
        	for(JSONObject jo : menuTreeList){
        		String uri = jo.getJSONObject("attributes").getString("url");
        		if(uri.indexOf(modelNo)!=-1){
        			modelName = jo.getString("text");
        		}
        	}
        }catch (Exception e) {
        	logger.error(e.getMessage(), e);
		}
        if(StringUtils.isEmpty(modelNo) || StringUtils.isEmpty(modelName) || menuTreeList==null){
        	return;
        }
        //添加固定报表的缓存命中
        String redishit = StringUtil.null2Blank(request.getAttribute("redishit"));
        modelName = "".equals(redishit)?modelName:(modelName+"||"+redishit);
        //获取并校验参数
       String methodsParam = null;
        try{
        	Map<String, Object> params = DynamicTabTheadUtil.builderParams(request);
            methodsParam = JsonUtils.toJson(params);
        }catch (Exception e) {
        	logger.error(e.getMessage(), e);
		}
        //构建保存数据的类
        SysLog log = new SysLog();
        log.setOrganName(organName);
        log.setUserLoginName(userLoginName);
        log.setOperator(operator);
        log.setIp(ip);
        log.setRegionName(regionName);
        log.setModelNo(modelNo+ " : " +String.valueOf(System.currentTimeMillis()));
        log.setModelName(modelName);
        log.setMethodsParam(methodsParam);
        log.setMethodsName(methodsName);
        log.setNeedTime(needTime);
        log.setErrorMsg(errorMsg);
        log.setOperateTime(new Date());
        log.setLogType(LOG_TYPE);
        //保存
        try {
			sysLogManager.add(log);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }
    
	//获取报表id
    private String getFreportID(HttpServletRequest request){
    	String freportID = null;
    	try{
    		String servletPath = request.getServletPath();
    		String servletPath_temp = servletPath.substring(0, servletPath.lastIndexOf("/"));
    		freportID = servletPath_temp.substring(servletPath_temp.lastIndexOf("/")+1,servletPath_temp.length());
    	}catch(Exception e){
    		return freportID;
    	}
    	return freportID;
    }
}  