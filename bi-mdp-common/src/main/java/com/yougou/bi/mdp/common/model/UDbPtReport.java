package com.yougou.bi.mdp.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 请写出类的用途 
 * @author wangyq
 * @date  2014-10-30 20:08:55
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
public class UDbPtReport implements Serializable {

	/**
     * 模版Id
     */
    private Integer reportId;

    /**
     * 模版名称
     */
    private String reportName;

    /**
     * 模版编码
     */
    private String reportCode;

    /**
     * 对象
     */
    private String reportObject;

    /**
     * 钻取指标
     */
    private String reportIndex;

    /**
     * 非钻取指标
     */
    private String unIndex;

    /**
     * 维度
     */
    private String reportDimension;

    /**
     * 钻取方式
     */
    private BigDecimal drillType;

    /**
     * 是否显示行总计
     */
    private BigDecimal lineCount;

    /**
     * 是否显示列总计
     */
    private BigDecimal colsCount;

    /**
     * 是否行列转换
     */
    private Integer reportReverse;

    /**
     * 模版说明
     */
    private String reportDrsc;

    /**
     * 拼接的json数据字符
     */
    private String jsonStr;

    /**
     * 模版所属用户
     */
    private String ownerUser;

    /**
     * 最后编辑时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastTime;
    
    /**
     * 模版名称
     */
    private String subjectName;
   
    /**
     * 是否聚合
     */
    private BigDecimal isStack;

    /**
     * 模版创建时间
     */
    private Date createTime;

    /**
     * 用户排序序号
     */
    private BigDecimal orderUser;
    
    /**
     * 用户选择指标
     */
    private String indexSel;
    
    /**
     * 拼接JSON备份
     */
    private String jsonBack;
    
    /**
     * 修改前模板名
     */
    private String sourceReportName;
    
    /**
     * 用户中文名
     */
    private String userName;
    
    /**
     * 机构名
     */
    private String organName;
    
    /**
     * 报表难度系数
     */
    private String cost;
    
    /**
     * 用户所属地区
     */
    private String regionName;
    
    /**
     * 是否可编辑 
     */
    private String editFlag;
    
    /**
     * 是否是导入 
     */
    private String leadinFlag;
    
    /**
     * 列合计的对象
     */
    private String reportObjectCCount;
    
    /**
     * 行合计的维度
     */
    private String reportDimensionRCount;
    
    /**
     * [GP]查询数据源,0表示Oracle;1表示Greenplum
     */
    private Integer connectDB;
    
    /**
     * 预计查询时间(不存储到DB)
     */
    private Double expectQueryTime;
    
    /**
     * 
     * {@linkplain #reporeId}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_ID
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * 
     * {@linkplain #reportId}
     * @param reporeId the value for U_DB_PT.U_DB_PT_REPORT.REPORT_ID
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * 
     * {@linkplain #reportName}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_NAME
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * 
     * {@linkplain #reportName}
     * @param reportName the value for U_DB_PT.U_DB_PT_REPORT.REPORT_NAME
     */
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    /**
     * 
     * {@linkplain #reportCode}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_CODE
     */
    public String getReportCode() {
        return reportCode;
    }

    /**
     * 
     * {@linkplain #reportCode}
     * @param reportCode the value for U_DB_PT.U_DB_PT_REPORT.REPORT_CODE
     */
    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    /**
     * 
     * {@linkplain #reportObject}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_OBJECT
     */
    public String getReportObject() {
        return reportObject;
    }

    /**
     * 
     * {@linkplain #reportObject}
     * @param reportObject the value for U_DB_PT.U_DB_PT_REPORT.REPORT_OBJECT
     */
    public void setReportObject(String reportObject) {
        this.reportObject = reportObject;
    }

    /**
     * 
     * {@linkplain #reportIndex}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_INDEX
     */
    public String getReportIndex() {
        return reportIndex;
    }

    /**
     * 
     * {@linkplain #reportIndex}
     * @param reportIndex the value for U_DB_PT.U_DB_PT_REPORT.REPORT_INDEX
     */
    public void setReportIndex(String reportIndex) {
        this.reportIndex = reportIndex;
    }

    /**
     * 
     * {@linkplain #unIndex}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.UN_INDEX
     */
    public String getUnIndex() {
        return unIndex;
    }

    /**
     * 
     * {@linkplain #unIndex}
     * @param unIndex the value for U_DB_PT.U_DB_PT_REPORT.UN_INDEX
     */
    public void setUnIndex(String unIndex) {
        this.unIndex = unIndex;
    }

    /**
     * 
     * {@linkplain #reportDimension}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_DIMENSION
     */
    public String getReportDimension() {
        return reportDimension;
    }

    /**
     * 
     * {@linkplain #reportDimension}
     * @param reportDimension the value for U_DB_PT.U_DB_PT_REPORT.REPORT_DIMENSION
     */
    public void setReportDimension(String reportDimension) {
        this.reportDimension = reportDimension;
    }

    /**
     * 
     * {@linkplain #drillType}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.DRILL_TYPE
     */
    public BigDecimal getDrillType() {
        return drillType;
    }

    /**
     * 
     * {@linkplain #drillType}
     * @param drillType the value for U_DB_PT.U_DB_PT_REPORT.DRILL_TYPE
     */
    public void setDrillType(BigDecimal drillType) {
        this.drillType = drillType;
    }

    /**
     * 
     * {@linkplain #lineCount}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.LINE_COUNT
     */
    public BigDecimal getLineCount() {
        return lineCount;
    }

    /**
     * 
     * {@linkplain #lineCount}
     * @param lineCount the value for U_DB_PT.U_DB_PT_REPORT.LINE_COUNT
     */
    public void setLineCount(BigDecimal lineCount) {
        this.lineCount = lineCount;
    }

    /**
     * 
     * {@linkplain #colsCount}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.COLS_COUNT
     */
    public BigDecimal getColsCount() {
        return colsCount;
    }

    /**
     * 
     * {@linkplain #colsCount}
     * @param colsCount the value for U_DB_PT.U_DB_PT_REPORT.COLS_COUNT
     */
    public void setColsCount(BigDecimal colsCount) {
        this.colsCount = colsCount;
    }

    /**
     * 
     * {@linkplain #reportReverse}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_REVERSE
     */
    public Integer getReportReverse() {
        return reportReverse;
    }

    /**
     * 
     * {@linkplain #reportReverse}
     * @param reportReverse the value for U_DB_PT.U_DB_PT_REPORT.REPORT_REVERSE
     */
    public void setReportReverse(Integer reportReverse) {
        this.reportReverse = reportReverse;
    }

    /**
     * 
     * {@linkplain #reportDrsc}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.REPORT_DRSC
     */
    public String getReportDrsc() {
        return reportDrsc;
    }

    /**
     * 
     * {@linkplain #reportDrsc}
     * @param reportDrsc the value for U_DB_PT.U_DB_PT_REPORT.REPORT_DRSC
     */
    public void setReportDrsc(String reportDrsc) {
        this.reportDrsc = reportDrsc;
    }

    /**
     * 
     * {@linkplain #jsonStr}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.JSON_STR
     */
    public String getJsonStr() {
        return jsonStr;
    }

    /**
     * 
     * {@linkplain #jsonStr}
     * @param jsonStr the value for U_DB_PT.U_DB_PT_REPORT.JSON_STR
     */
    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    /**
     * 
     * {@linkplain #ownerUser}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.OWNER_USER
     */
    public String getOwnerUser() {
        return ownerUser;
    }

    /**
     * 
     * {@linkplain #ownerUser}
     * @param ownerUser the value for U_DB_PT.U_DB_PT_REPORT.OWNER_USER
     */
    public void setOwnerUser(String ownerUser) {
        this.ownerUser = ownerUser;
    }

    /**
     * 
     * {@linkplain #lastTime}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.LAST_TIME
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 
     * {@linkplain #lastTime}
     * @param lastTime the value for U_DB_PT.U_DB_PT_REPORT.LAST_TIME
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
    
    /**
     * 
     * {@linkplain #subjectName}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.SUBJECT_NAME
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 
     * {@linkplain #subjectName}
     * @param subjectName the value for U_DB_PT.U_DB_PT_REPORT.SUBJECT_NAME
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * 
     * {@linkplain #isStack}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.IS_STACK
     */
    public BigDecimal getIsStack() {
        return isStack;
    }

    /**
     * 
     * {@linkplain #isStack}
     * @param isStack the value for U_DB_PT.U_DB_PT_REPORT.IS_STACK
     */
    public void setIsStack(BigDecimal isStack) {
        this.isStack = isStack;
    }
    
    /**
     * 
     * {@linkplain #createTime}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.CREATE_TIME
     */
	public Date getCreateTime() {
		return createTime;
	}
	
	 /**
     * 
     * {@linkplain #createTime}
     * @param createTime the value for U_DB_PT.U_DB_PT_REPORT.CREATE_TIME
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	 /**
     * 
     * {@linkplain #orderUser}
     *
     * @return the value of U_DB_PT.U_DB_PT_REPORT.ORDER_USER
     */
	public BigDecimal getOrderUser() {
		return orderUser;
	}

	/**
     * 
     * {@linkplain #orderUser}
     * @param orderUser the value for U_DB_PT.U_DB_PT_REPORT.ORDER_USER
     */
	public void setOrderUser(BigDecimal orderUser) {
		this.orderUser = orderUser;
	}	

	public String getIndexSel() {
		return indexSel;
	}

	public void setIndexSel(String indexSel) {
		this.indexSel = indexSel;
	}

	public String getJsonBack() {
		return jsonBack;
	}

	public void setJsonBack(String jsonBack) {
		this.jsonBack = jsonBack;
	}

	/**
	 * @return the sourceReportName
	 */
	public String getSourceReportName() {
		return sourceReportName;
	}

	/**
	 * @param sourceReportName the sourceReportName to set
	 */
	public void setSourceReportName(String sourceReportName) {
		this.sourceReportName = sourceReportName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}

	public String getLeadinFlag() {
		return leadinFlag;
	}
	
	public void setLeadinFlag(String leadinFlag) {
		this.leadinFlag = leadinFlag;
	}

	public String getReportObjectCCount() {
		return reportObjectCCount;
	}

	public void setReportObjectCCount(String reportObjectCCount) {
		this.reportObjectCCount = reportObjectCCount;
	}

	public String getReportDimensionRCount() {
		return reportDimensionRCount;
	}

	public void setReportDimensionRCount(String reportDimensionRCount) {
		this.reportDimensionRCount = reportDimensionRCount;
	}

	public Integer getConnectDB() {
		return connectDB;
	}

	public void setConnectDB(Integer connectDB) {
		this.connectDB = connectDB;
	}

	public Double getExpectQueryTime() {
		return expectQueryTime;
	}

	public void setExpectQueryTime(Double expectQueryTime) {
		this.expectQueryTime = expectQueryTime;
	}
	
}