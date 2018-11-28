package com.yougou.bi.mdp.common.model;

import java.io.Serializable;

/**
 * 
* @ProjectName:bi-report-common
* @ClassName: DimLargeCategory 
* @Description: 大品类1 实体类
* @author qinnan
* @date 2018年8月16日 下午4:48:56
 */
public class DimLargeCategory implements Serializable{

    /** 
    * @Fields serialVersionUID : TODO
    */ 
    private static final long serialVersionUID = 1L;
    

    /**
     * 品牌编号
     */
    private String brandNoDetailNo;
    
    /**
     * 大品类编码
     */
    private String largeCategoryNo;
    
    /**
     * 大品类1名称
     */
    private String largeCategoryName;

    public DimLargeCategory() {
        super();
    }

    public DimLargeCategory(String brandNoDetailNo, String largeCategoryNo, String largeCategoryName) {
        super();
        this.brandNoDetailNo = brandNoDetailNo;
        this.largeCategoryNo = largeCategoryNo;
        this.largeCategoryName = largeCategoryName;
    }

    public String getBrandNoDetailNo() {
        return brandNoDetailNo;
    }

    public void setBrandNoDetailNo(String brandNoDetailNo) {
        this.brandNoDetailNo = brandNoDetailNo;
    }

    public String getLargeCategoryNo() {
        return largeCategoryNo;
    }

    public void setLargeCategoryNo(String largeCategoryNo) {
        this.largeCategoryNo = largeCategoryNo;
    }

    public String getLargeCategoryName() {
        return largeCategoryName;
    }

    public void setLargeCategoryName(String largeCategoryName) {
        this.largeCategoryName = largeCategoryName;
    }

}
