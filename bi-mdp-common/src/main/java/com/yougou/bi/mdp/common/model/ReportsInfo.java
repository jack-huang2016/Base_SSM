package com.yougou.bi.mdp.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@SuppressWarnings("serial")
public class ReportsInfo implements Serializable {
    /**
     * 
     */
    private String reportsNo;
    
    private String reportsCode;
    
    /**
     * 
     */
    private String reportsName;

    /**
     * 
     */
    private String reportsReadme;

    /**
     * 
     */
    private BigDecimal flag;

    /**
     * 
     */
    private BigDecimal status;

    /**
     * 
     */
    private String editor;
    
    /**
     * 
     */
    private BigDecimal picFlag;
    
    /**
     * 
     */
    private String picUrl;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date edittm;

    /**
     * 
     * {@linkplain #reportsNo}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.REPORTS_NO
     */
    public String getReportsNo() {
        return reportsNo;
    }

    /**
     * 
     * {@linkplain #reportsNo}
     * @param reportsNo the value for U_MD_DM.REPORTS_INFO.REPORTS_NO
     */
    public void setReportsNo(String reportsNo) {
        this.reportsNo = reportsNo;
    }

    /**
     * 
     * {@linkplain #reportsName}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.REPORTS_NAME
     */
    public String getReportsName() {
        return reportsName;
    }

    /**
     * 
     * {@linkplain #reportsName}
     * @param reportsName the value for U_MD_DM.REPORTS_INFO.REPORTS_NAME
     */
    public void setReportsName(String reportsName) {
        this.reportsName = reportsName;
    }

    /**
     * 
     * {@linkplain #reportsReadme}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.REPORTS_README
     */
    public String getReportsReadme() {
        return reportsReadme;
    }

    /**
     * 
     * {@linkplain #reportsReadme}
     * @param reportsReadme the value for U_MD_DM.REPORTS_INFO.REPORTS_README
     */
    public void setReportsReadme(String reportsReadme) {
        this.reportsReadme = reportsReadme;
    }

    /**
     * 
     * {@linkplain #flag}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.FLAG
     */
    public BigDecimal getFlag() {
        return flag;
    }

    /**
     * 
     * {@linkplain #flag}
     * @param flag the value for U_MD_DM.REPORTS_INFO.FLAG
     */
    public void setFlag(BigDecimal flag) {
        this.flag = flag;
    }

    /**
     * 
     * {@linkplain #status}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.STATUS
     */
    public BigDecimal getStatus() {
        return status;
    }

    /**
     * 
     * {@linkplain #status}
     * @param status the value for U_MD_DM.REPORTS_INFO.STATUS
     */
    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    /**
     * 
     * {@linkplain #editor}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.EDITOR
     */
    public String getEditor() {
        return editor;
    }

    /**
     * 
     * {@linkplain #editor}
     * @param editor the value for U_MD_DM.REPORTS_INFO.EDITOR
     */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     * 
     * {@linkplain #edittm}
     *
     * @return the value of U_MD_DM.REPORTS_INFO.EDITTM
     */
    public Date getEdittm() {
        return edittm;
    }

    /**
     * 
     * {@linkplain #edittm}
     * @param edittm the value for U_MD_DM.REPORTS_INFO.EDITTM
     */
    public void setEdittm(Date edittm) {
        this.edittm = edittm;
    }

	public BigDecimal getPicFlag() {
		return picFlag;
	}

	public void setPicFlag(BigDecimal picFlag) {
		this.picFlag = picFlag;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getReportsCode() {
		return reportsCode;
	}

	public void setReportsCode(String reportsCode) {
		this.reportsCode = reportsCode;
	}
    
    
}