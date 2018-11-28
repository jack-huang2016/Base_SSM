package com.yougou.bi.mdp.common.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 请写出类的用途 
 * @author Administrator
 * @date  2014-11-11 16:41:37
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
@SuppressWarnings("serial")
public class SysLog implements Serializable {
    /**
     * 
     */
    private String modelNo;

    /**
     * 模块名称
     */
    private String modelName;
    
    //调用的方法名
    private String methodsName;
    
    //调用的方法参数
    private String methodsParam;
    
    //使用该参数调用该方法消耗的时间[单位:毫秒]
    private String needTime;
    
    //错误信息
    private String errorMsg;
    
    //[GP]使用数据源
    private String dataSource;

    /**
     * 
     */
    private String ip;

    /**
     * 
     */
    private String operator;
    
    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operateTime;
    
    private String userLoginName;
    
    private String organName;
    
    private String regionName;
    
    /**
     * 报表难度级别
     */
    private String costDegree;
    
    /**
     * 日志类型
     */
    private String logType;
    
    /**
     * 备注
     */
    private String remarks;
    
    /**
     * [GP]模板主题
     */
    private String subjectName;
    
    /**
     * [GP]执行计划总成本
     */
    private Long explainCost;
    
    /**
     * [GP]执行计划IO成本
     */
    private Long explainIOCost;
    
    /**
     * [GP]SQL正真执行时间
     */
    private Long queryTime;
    
    /**
     * [GP]请求号
     */
    private String requestNo;
    
    /**
     * 预计查询时间
     */
    private Long expectQueryTime;
    
    
    /**
     * 
     * {@linkplain #modelNo}
     *
     * @return the value of U_MD_DM.SYS_LOG.MODEL_NO
     */
    public String getModelNo() {
        return modelNo;
    }

    /**
     * 
     * {@linkplain #modelNo}
     * @param modelNo the value for U_MD_DM.SYS_LOG.MODEL_NO
     */
    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    /**
     * 
     * {@linkplain #modelName}
     *
     * @return the value of U_MD_DM.SYS_LOG.MODEL_NAME
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 
     * {@linkplain #modelName}
     * @param modelName the value for U_MD_DM.SYS_LOG.MODEL_NAME
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 
     * {@linkplain #ip}
     *
     * @return the value of U_MD_DM.SYS_LOG.IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 
     * {@linkplain #ip}
     * @param ip the value for U_MD_DM.SYS_LOG.IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 
     * {@linkplain #operator}
     *
     * @return the value of U_MD_DM.SYS_LOG.OPERATOR
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 
     * {@linkplain #operator}
     * @param operator the value for U_MD_DM.SYS_LOG.OPERATOR
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 
     * {@linkplain #operateTime}
     *
     * @return the value of U_MD_DM.SYS_LOG.OPERATE_TIME
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 
     * {@linkplain #operateTime}
     * @param operateTime the value for U_MD_DM.SYS_LOG.OPERATE_TIME
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}
	
    
    public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
    public String toString() {
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String tempDate=format.format(operateTime);
    	return modelName+"##"+userLoginName+"##"+"##"+operator+"##"+organName+"##"+tempDate;
    }

	public String getMethodsName() {
		return methodsName;
	}

	public void setMethodsName(String methodsName) {
		this.methodsName = methodsName;
	}

	public String getMethodsParam() {
		return methodsParam;
	}

	public void setMethodsParam(String methodsParam) {
		this.methodsParam = methodsParam;
	}

	public String getNeedTime() {
		return needTime;
	}

	public void setNeedTime(String needTime) {
		this.needTime = needTime;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCostDegree() {
		return costDegree;
	}

	public void setCostDegree(String costDegree) {
		this.costDegree = costDegree;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getExplainCost() {
		return explainCost;
	}

	public void setExplainCost(Long explainCost) {
		this.explainCost = explainCost;
	}

	public Long getExplainIOCost() {
		return explainIOCost;
	}

	public void setExplainIOCost(Long explainIOCost) {
		this.explainIOCost = explainIOCost;
	}

	public Long getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(Long queryTime) {
		this.queryTime = queryTime;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public Long getExpectQueryTime() {
		return expectQueryTime;
	}

	public void setExpectQueryTime(Long expectQueryTime) {
		this.expectQueryTime = expectQueryTime;
	}
}