package com.yougou.bi.mdp.common.model;

import java.io.Serializable;

/**
 * 
* @ProjectName:bi-report-common
* @ClassName: DimRdsite 
* @Description: 研发地实体类
* @author qinnan
* @date 2018年8月16日 下午4:49:06
 */
public class DimRdsite implements Serializable{

    /** 
    * @Fields serialVersionUID : TODO
    */ 
    private static final long serialVersionUID = 1L;

    /**
     * 品牌编号
     */
    private String brandNoDetailNo;
    
    /**
     * 研发地编码
     */
    private String rdsiteNo;
    
    /**
     * 研发地名称
     */
    private String rdsiteName;

    public DimRdsite() {
        super();
    }

    public DimRdsite(String brandNoDetailNo, String rdsiteNo, String rdsiteName) {
        super();
        this.brandNoDetailNo = brandNoDetailNo;
        this.rdsiteNo = rdsiteNo;
        this.rdsiteName = rdsiteName;
    }

    public String getBrandNoDetailNo() {
        return brandNoDetailNo;
    }

    public void setBrandNoDetailNo(String brandNoDetailNo) {
        this.brandNoDetailNo = brandNoDetailNo;
    }

    public String getRdsiteNo() {
        return rdsiteNo;
    }

    public void setRdsiteNo(String rdsiteNo) {
        this.rdsiteNo = rdsiteNo;
    }

    public String getRdsiteName() {
        return rdsiteName;
    }

    public void setRdsiteName(String rdsiteName) {
        this.rdsiteName = rdsiteName;
    }
}
