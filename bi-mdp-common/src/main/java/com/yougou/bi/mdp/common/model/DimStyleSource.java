package com.yougou.bi.mdp.common.model;

import java.io.Serializable;

/**
 * 
* @ProjectName:bi-report-common
* @ClassName: DimStyleSource 
* @Description: 款式风格实体类
* @author qinnan
* @date 2018年8月16日 下午4:53:42
 */
public class DimStyleSource implements Serializable{

    /** 
    * @Fields serialVersionUID : TODO
    */ 
    private static final long serialVersionUID = 1L;
    
    /**
     * 品牌编号
     */
    private String brandNoDetailNo;
    
    /**
     * 款式来源编码
     */
    private String styleSourceNo;
    
    /**
     * 款式来源名称
     */
    private String styleSourceName;

    public DimStyleSource() {
        super();
    }

    public DimStyleSource(String brandNoDetailNo, String styleSourceNo, String styleSourceName) {
        super();
        this.brandNoDetailNo = brandNoDetailNo;
        this.styleSourceNo = styleSourceNo;
        this.styleSourceName = styleSourceName;
    }

    public String getBrandNoDetailNo() {
        return brandNoDetailNo;
    }

    public void setBrandNoDetailNo(String brandNoDetailNo) {
        this.brandNoDetailNo = brandNoDetailNo;
    }

    public String getStyleSourceNo() {
        return styleSourceNo;
    }

    public void setStyleSourceNo(String styleSourceNo) {
        this.styleSourceNo = styleSourceNo;
    }

    public String getStyleSourceName() {
        return styleSourceName;
    }

    public void setStyleSourceName(String styleSourceName) {
        this.styleSourceName = styleSourceName;
    }
}
