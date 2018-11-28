package com.yougou.bi.mdp.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.wonhigh.retail.picture.api.service.PictureApi;
import cn.wonhigh.retail.uc.common.api.service.SSOApi;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.yougou.bi.mdp.common.constans.PublicConstans;
import com.yougou.bi.mdp.common.model.ReportsInfo;
import com.yougou.bi.mdp.common.result.Result;
import com.yougou.bi.mdp.common.result.ResultUtil;
import com.yougou.bi.mdp.manager.ReportsInfoManager;
import com.yougou.bi.mdp.redis.util.RedisUtil;
import com.yougou.bi.mdp.web.controller.freportBase.BaseFrportControllerUtil;
import com.yougou.bi.mdp.web.utils.MenuTreeCasheUtils;
import com.yougou.bi.mdp.web.utils.PropertyUtil;
import com.yougou.bi.mdp.web.vo.CurrentUser;

import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.web.controller.BaseCrudController;

/**
 * 请写出类的用途 
 * @author Administrator
 * @date  2014-10-28 14:21:27
 * @version 1.0.0
 * @copyright (C) 2013 YouGou Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the YouGou technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
@Controller
@RequestMapping("/reports_info")
public class ReportsInfoController extends BaseCrudController<ReportsInfo> {

	@Autowired(required = false)
	private SSOApi ssoApi;
	@Autowired(required = false)
	private PictureApi pictureApi;
	
	private static final XLogger logger = XLoggerFactory.getXLogger(ReportsInfoController.class);

	@Resource
	private ReportsInfoManager reportsInfoManager;

	private String pReportsNo;

	@Override
	public CrudInfo init() {
		return new CrudInfo("reports_info/",reportsInfoManager);
	}


	//查询
	@RequestMapping(value = "/listAll")
	@ResponseBody
	public  Map<String, Object> listAll(HttpServletRequest req, Model model) throws ManagerException {
		int pageNo = StringUtils.isEmpty(req.getParameter("page")) ? 1 : Integer.parseInt(req.getParameter("page"));
		int pageSize = StringUtils.isEmpty(req.getParameter("rows")) ? 10 : Integer.parseInt(req.getParameter("rows"));
		String sortColumn = StringUtils.isEmpty(req.getParameter("sort")) ? "" : String.valueOf(req.getParameter("sort"));
		String sortOrder = StringUtils.isEmpty(req.getParameter("order")) ? "" : String.valueOf(req.getParameter("order"));

		Map<String, Object> params = builderParams(req, model);

		int total = reportsInfoManager.selectCount();
		SimplePage page = new SimplePage(pageNo, pageSize*pageNo, (int) total);
		params.put("startRowNum", 0);
		if(pageNo > 1){
			params.put("startRowNum", pageSize*(pageNo-1));
		}
		params.put("pageSize", pageSize*pageNo);
		List<ReportsInfo> list = reportsInfoManager.selectByPage(page, sortColumn, sortOrder, params);
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("total", total);
		obj.put("rows", list);
		return obj;
	}


	//查询
	@SuppressWarnings("unused")
	@RequestMapping(value = "/searchReports")
	@ResponseBody
	public  Map<String, Object> searchReports(HttpServletRequest req, Model model) throws ManagerException {
		int pageNo = StringUtils.isEmpty(req.getParameter("page")) ? 1 : Integer.parseInt(req.getParameter("page"));
		int pageSize = StringUtils.isEmpty(req.getParameter("rows")) ? 10 : Integer.parseInt(req.getParameter("rows"));
		String sortColumn = StringUtils.isEmpty(req.getParameter("sort")) ? "" : String.valueOf(req.getParameter("sort"));
		String sortOrder = StringUtils.isEmpty(req.getParameter("order")) ? "" : String.valueOf(req.getParameter("order"));

		Map<String, Object> params = builderParams(req, model);
		String strStartTime = params.get("startTime").toString();
		String strEndTime = params.get("endTime").toString();

		if(strEndTime != null && !strEndTime.isEmpty()){
			strEndTime = getDate(strEndTime);
			params.put("endTime", strEndTime);
		}

		//strStartTime = "to_date('" + strStartTime + "','yyyy-mm-dd')";
		//strEndTime = "to_date('" + strEndTime + "','yyyy-mm-dd')"; 

		//params.put("startTime", strStartTime);
		//params.put("endTime", strEndTime);

		int total = reportsInfoManager.selectCount();
		SimplePage page = new SimplePage(pageNo, pageSize, (int) total);
		List<ReportsInfo> list = reportsInfoManager.searchReports(page, sortColumn, sortOrder, params);
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("total", total);
		obj.put("rows", list);
		return obj;


	}
	//新增获取下拉列表
	@RequestMapping({"/get_bizs"})
	@ResponseBody
	public List<ReportsInfo> getBiz(HttpServletRequest req, Model model) throws ManagerException {
		Map<String, Object> params = builderParams(req, model);
		return this.reportsInfoManager.findByBizs(params);
	}
	//当前日期加一天
	private String getDate(String date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			Date dat=format.parse(date);
			cal.setTime(dat);
			cal.add(Calendar.DAY_OF_MONTH, 1);
		} catch (ParseException e) {
			logger.error("日期格式错误",e);
		}
		return format.format(cal.getTime());
	}

	//新增跳转页面
	@RequestMapping(value = "/turnAddReports")
	public String addAddReports(HttpServletRequest req) {
		return "reports_info/addReports";
	}

	//新增跳转页面
	@RequestMapping(value = "/returnReports")
	public String returnReports(HttpServletRequest req) {
		return "reports_info/list";
	}

	//编辑跳转页面
	@RequestMapping(value = "/turnEditReports")
	public String editAnnouncement(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String reportsNo = req.getParameter("repNo");
		session.setAttribute("repNo", reportsNo);
		return "reports_info/editReports";
	}
	
	//上传图片
	@RequestMapping(value = "/importPic")
	public ResponseEntity<ReportsInfo>  importPic(HttpServletRequest req, 
			@RequestParam("Filedata") MultipartFile picFile,
			ReportsInfo modelType,
			String reportName, String repNo) {
		boolean flag = true;
		pReportsNo = null;
		ReportsInfo reportsInfo = new ReportsInfo();
		CurrentUser currentUser = new CurrentUser(req);
		//获取reportsNo
		getReportsNoByReportsName(req,reportName);
		if (null == pReportsNo) {
			return null;
		}
		reportsInfo.setReportsNo(pReportsNo);
		reportsInfo.setEditor(currentUser.getUsername());
		reportsInfo.setEdittm(new Date());
		
		//构造图片文件名路径
		String path = BaseFrportControllerUtil.getPicPath("preview_"+pReportsNo+picFile.getOriginalFilename().substring(picFile.getOriginalFilename().lastIndexOf(".")));
		//先清除，后上传
		cleanPic(pReportsNo);
		try {
			pictureApi.upload(picFile.getBytes(), path);
		} catch (Exception e1) {
			flag = false;
			logger.error("图片上传失败",e1);
		}
		if(flag){
			try {
				reportsInfo.setPicFlag(new BigDecimal("0"));
				reportsInfo.setReportsNo(repNo);
				reportsInfoManager.editReportsInfo(reportsInfo);
			} catch (ManagerException e) {
				flag = false;
				logger.error("图片上传失败",e);
			}
			reportsInfo.setPicFlag(new BigDecimal("0"));//上传成功
		}else{
			reportsInfo.setPicFlag(new BigDecimal("1"));
		}
		return new ResponseEntity<ReportsInfo>(reportsInfo, HttpStatus.OK);
	}

	/**
	 * 
	 * 查redis里面报表是否存在
	 * @param req
	 * @param reportsName
	 */
	private void getReportsNoByReportsName(HttpServletRequest req,String reportsName) {
		HttpSession session = req.getSession();
		String casheKey = PublicConstans.AREA_SYSTEM_ID + "_MENU_TREE_CASHE_" + session.getId();
		String menuTree= RedisUtil.get(casheKey);
		if(null==reportsName||null==menuTree){
			try {
				throw new Exception("菜单或者报表名称为空！");
			} catch (Exception e) {
				logger.error("菜单或者报表名称为空",e);
			}
		}
		JSONArray array = JSONArray.fromObject(menuTree);
		getReportsNoByReportsNa(array,reportsName);
	}

	/**
	 * 设置报表id
	 * @param array
	 * @param reportsName
	 */
	private void getReportsNoByReportsNa(JSONArray array,String reportsName) {
		for(int i = 0; i < array.size(); i++){
			JSONObject jsonObject = array.getJSONObject(i);
			if(jsonObject.get("text").toString().equals(reportsName)){
				pReportsNo = String.valueOf(jsonObject.get("id"));
			}
			if(null!=jsonObject.get("children")&&!"".equals(jsonObject.get("children").toString().trim())){
				JSONArray array1 = JSONArray.fromObject(jsonObject.get("children"));
				getReportsNoByReportsNa(array1,reportsName);
			}
		}
	}

	/**
	 * 删除图片
	 * @param reportsNo
	 */
	private void cleanPic(String reportsNo) {
		String picpath;
		try {
			picpath = PropertyUtil.getWebPropertyValue("BI_PICPATH", "dispatch.properties");
			if(pictureApi.exists(picpath+"preview_"+reportsNo+".jpg")){
				pictureApi.delete(picpath+"preview_"+reportsNo+".jpg");
			};
			if(pictureApi.exists(picpath+"preview_"+reportsNo+".gif")){
				pictureApi.delete(picpath+"preview_"+reportsNo+".gif");
			};
			if(pictureApi.exists(picpath+"preview_"+reportsNo+".png")){
				pictureApi.delete(picpath+"preview_"+reportsNo+".png");
			};
			if(pictureApi.exists(picpath+"preview_"+reportsNo+".jpeg")){
				pictureApi.delete(picpath+"preview_"+reportsNo+".jpeg");
			};
		} catch (Exception e) {
			logger.error("图片不存在",e);
		}
	}

	//删除预览图片
	@RequestMapping(value = "/deletePic")
	@ResponseBody
	public void deletePic(HttpServletRequest req,ReportsInfo reportsInfo){
		try {
			pReportsNo = null;
			reportsInfo.setPicFlag(new BigDecimal("1"));
			getReportsNoByReportsName(req,reportsInfo.getReportsName());
			if(null!=pReportsNo){
				reportsInfoManager.editReportsInfo(reportsInfo);
				cleanPic(pReportsNo);
			}
		} catch (ManagerException e) {
			logger.error("菜单或者报表名称为空",e);
		}
	}

	//展示预览图片
	@RequestMapping(value = "/previewPic")
	@ResponseBody
	public ResponseEntity<ReportsInfo> previewPic(HttpServletRequest request,HttpServletResponse response,ReportsInfo reportsInfo){
		//获取报表编码对应的no
		HttpSession session = request.getSession();
		String casheKey = PublicConstans.AREA_SYSTEM_ID + "_MENU_TREE_CASHE_" + session.getId();
		String reportsCode = reportsInfo.getReportsCode();
		pReportsNo = null;
		String menuTree= RedisUtil.get(casheKey);
		if(null==reportsCode||null==menuTree){
			return null;
		}
		JSONArray array = JSONArray.fromObject(menuTree);
		getReportsNoByReportsCode(array,reportsCode);
		if(null == pReportsNo){
			return null;
		}
		String fileName = findPicName(pReportsNo);
		reportsInfo.setPicUrl(BaseFrportControllerUtil.getPicPath(fileName));
		reportsInfo.setReportsNo(pReportsNo);
		return new ResponseEntity<ReportsInfo>(reportsInfo, HttpStatus.OK);
	}

	private void getReportsNoByReportsCode(JSONArray array, String reportsCode) {
		for(int i = 0; i < array.size(); i++){
			JSONObject jsonObject = array.getJSONObject(i);
			if(jsonObject.get("attributes").toString().equals("{\"url\":\"freport/"+reportsCode+"\"}")){
				pReportsNo = String.valueOf(jsonObject.get("id"));
			}
			if(null!=jsonObject.get("children")&&!"".equals(jsonObject.get("children").toString().trim())){
				JSONArray array1 = JSONArray.fromObject(jsonObject.get("children"));
				getReportsNoByReportsCode(array1,reportsCode);
			}
		}
	}

	private String findPicName(String reportsNo) {
		String fileName = null;
		String picpath;
		try {
			picpath = PropertyUtil.getWebPropertyValue("BI_PICPATH", "dispatch.properties");
			if(pictureApi.exists(picpath+"preview_"+reportsNo+".jpg")){
				fileName = "preview_"+reportsNo+".jpg";
			}else if(pictureApi.exists(picpath+"preview_"+reportsNo+".gif")){
				fileName = "preview_"+reportsNo+".gif";
			}else if(pictureApi.exists(picpath+"preview_"+reportsNo+".png")){
				fileName = "preview_"+reportsNo+".png";
			}else if(pictureApi.exists(picpath+"preview_"+reportsNo+".jpeg")){
				fileName = "preview_"+reportsNo+".jpeg";
			}else{
				fileName = "preview_default.jpg";
			}
		} catch (Exception e) {
			logger.error("菜单或者报表名称为空",e);
		}
		return fileName;
	}

	//新增保存
	@RequestMapping(value = "/addReports")
	public ResponseEntity<ReportsInfo> addReports(ReportsInfo reportsInfo,HttpServletRequest req,Model model) throws ManagerException {
		CurrentUser currentUser = new CurrentUser(req);
		reportsInfo.setEditor(currentUser.getUsername());
		reportsInfo.setEdittm(new Date());
		reportsInfo.setFlag(new BigDecimal(1));
		reportsInfo.setStatus(new BigDecimal(1));
		reportsInfoManager.addReports(reportsInfo);
		return new ResponseEntity<ReportsInfo>(reportsInfo, HttpStatus.OK);
	} 

	//根据reportsNo取数据库数据
	@RequestMapping(value = "/getReports")
	@ResponseBody
	public ReportsInfo getReports(HttpServletRequest req){
		ReportsInfo reportsInfo = new ReportsInfo();
		String str = req.getParameter("reportsNo");
		try {
			reportsInfo = reportsInfoManager.getReports(str);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			logger.error("数据获取异常",e);
		}
		return reportsInfo;
	}

	//(编辑)获取下拉列表
	@RequestMapping(value = "/getCombobox")
	@ResponseBody
	public List<ReportsInfo> getCombobox(ReportsInfo reportsInfo,HttpServletRequest req,Model model)throws ManagerException{
		Map<String,Object> params=builderParams(req, model);
		return reportsInfoManager.getCombobox(reportsInfo, params);
	}

	//    //(新增)获取下拉列表
	//    @RequestMapping(value = "/getComboboxForAdd")
	//    @ResponseBody
	//    public Map<String,ReportsInfo> getComboboxForAdd(ReportsInfo reportsInfo,HttpServletRequest req,Model model)throws ManagerException{
	//    	Map<String,ReportsInfo> reportsInfoMap = Maps.newHashMap();
	//    	JSONArray reportsInfoJsonList = null;
	//    	
	//    	//在session中获取用户树的信息
	//    	HttpSession session = req.getSession();
	//    	String userTree = "";
	//		if (session != null) {
	//			userTree = UcCenterUtil.getMenuTreeFromCashe(session.getId());
	//		}
	//		
	//		//因为第一层只有一个节点所以可以这样处理
	//		JSONArray ja = JSONArray.fromObject(userTree);
	//		if(ja == null || ja.isEmpty()){
	//			return reportsInfoMap;
	//		}
	//		JSONObject jo = (JSONObject) ja.get(0);
	//		
	//		//在第二层中找[text="固定报表"] 或者[id="20537"]
	//		JSONArray ja1 = jo.getJSONArray("children");
	//		if(ja1 == null || ja1.isEmpty()){
	//			return reportsInfoMap;
	//		}
	//		@SuppressWarnings("rawtypes")
	//		Iterator it = ja1.iterator();
	//		while (it.hasNext()) {
	//			JSONObject jo1 = (JSONObject) it.next();
	//			String text = jo1.getString("text");
	//			if(text.equals("固定报表")||text.equals("会员联盟报表")){
	//				reportsInfoJsonList = jo1.getJSONArray("children");
	//			}
	//		}
	//		
	//		//在第三层中循环获取列表
	//		@SuppressWarnings("rawtypes")
	//		Iterator reportsInfoJsonIt = reportsInfoJsonList.iterator();
	//		while (it.hasNext()) {
	//			JSONObject reportsInfoJsonObject = (JSONObject) reportsInfoJsonIt.next();
	//			String id = reportsInfoJsonObject.getString("id");
	//			String text = reportsInfoJsonObject.getString("text");
	//			ReportsInfo ri = new ReportsInfo();
	//			ri.setReportsNo(id);
	//			ri.setReportsName(text);
	//			reportsInfoMap.put(id, ri);
	//		}
	//		return reportsInfoMap;
	//    }

	//编辑保存
	@RequestMapping(value = "/editReports")
	public ResponseEntity<ReportsInfo> editReportsInfo(ReportsInfo reportsInfo,HttpServletRequest req,Model model) throws ManagerException {
		CurrentUser currentUser = new CurrentUser(req);
		reportsInfo.setEditor(currentUser.getUsername());
		reportsInfo.setEdittm(new Date());
		reportsInfoManager.editReportsInfo(reportsInfo);
		return new ResponseEntity<ReportsInfo>(reportsInfo, HttpStatus.OK);

	} 
	//设置作废状态
	@RequestMapping(value = "/setCancelStatus")
	@ResponseBody
	public void setCancelStatus(ReportsInfo reportsInfo){
		try {
			reportsInfoManager.setCancelStatus(reportsInfo);

		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			logger.error("修改状态错误",e);
		}
	}
	//设置恢复正常状态
	@RequestMapping(value = "/setRecoverStatus")
	@ResponseBody
	public void setRecoverStatus(ReportsInfo reportsInfo){
		try {
			reportsInfoManager.setRecoverStatus(reportsInfo);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			logger.error("修改状态错误",e);
		}
	}
	/**
	 * 获得当前用户信息与当前系统时间
	 */
	@RequestMapping(value = "/getCurrentUser")
	@ResponseBody
	public CurrentUser getCurrentUser(HttpServletRequest req) throws ManagerException {
		CurrentUser currentUser = new CurrentUser(req);
		return currentUser;
	}

	/**
	 * 同步数据
	 */
	@RequestMapping(value = "/synchronousMenu")
	@ResponseBody
	public Result synchronousMenu(HttpServletRequest req) throws ManagerException {
		List<JSONObject> menuTreeList = getUserMenuTree(req , ssoApi);
		List<Map<String,String>> kvList = Lists.newArrayList();
		for(JSONObject jo : menuTreeList){
			Map<String,String> map = Maps.newHashMap();
			map.put("id", jo.getString("id"));
			map.put("text", jo.getString("text"));
			kvList.add(map);
		}
		reportsInfoManager.synchronousMenu(kvList);
		return ResultUtil.success("菜单更新成功!");
	}

	/**
	 * @param ssoApi 
	 * 获取固定报表的name,id值对
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	public static List<JSONObject> getUserMenuTree(HttpServletRequest req, SSOApi ssoApi){
		HttpSession session=req.getSession();
		String userTree = MenuTreeCasheUtils.getCasheMenuTree(ssoApi, session);
		//因为第一层只有一个节点所以可以这样处理
		JSONArray ja = JSONArray.fromObject(userTree);
		if(ja == null || ja.isEmpty()){
			//return ResultUtil.fail();
		}
		JSONObject jo = (JSONObject) ja.get(0);

		//在第二层中找[text="固定报表"] 或者[id="20537"]
		JSONArray ja1 = jo.getJSONArray("children");
		if(ja1 == null || ja1.isEmpty()){
			//return ResultUtil.fail();
		}
		//在固定报表这一层,递归得到所有末端节点.
		List<JSONObject> kvList = Lists.newArrayList();
		@SuppressWarnings("rawtypes")
		Iterator it = ja1.iterator();
		while (it.hasNext()) {
			JSONObject temp = (JSONObject) it.next();
			String text = temp.getString("text");
			if(text.equals("固定报表")||text.equals("会员联盟报表")){
				addList(kvList,temp);
			}
		}
		return kvList;
	}

	/**
	 * 循环得到末端节点
	 * @throws
	 */
	private static void addList(List<JSONObject> kvList,JSONObject jo){
		//非空校验
		if(jo == null){
			return;
		}
		//取子节点
		JSONArray reportsJSONArray = null;
		try{
			reportsJSONArray = jo.getJSONArray("children");
		}catch(Exception e){
			reportsJSONArray = null;
		}
		//只有末端子节点添加到表中
		if(reportsJSONArray==null || reportsJSONArray.size()==0){
			kvList.add(jo);
		}else{
			@SuppressWarnings("rawtypes")
			Iterator lastIt = reportsJSONArray.iterator();
			while (lastIt.hasNext()) {
				JSONObject temp = (JSONObject) lastIt.next();
				addList(kvList,temp);
			}
		}
	}

	/**
	 * 文件通道方式复制
	 */
	public void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;

		FileOutputStream fo = null;

		FileChannel in = null;

		FileChannel out = null;

		try {

			fi = new FileInputStream(s);

			fo = new FileOutputStream(t);

			in = fi.getChannel();//得到对应的文件通道

			out = fo.getChannel();//得到对应的文件通道

			in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

		} catch (IOException e) {
			logger.error("文件读取写入错误",e);

		} finally {

			try {

				fi.close();

				in.close();

				fo.close();

				out.close();

			} catch (IOException e) {
				logger.error("文件读取写入错误",e);

			}

		}

	}

}