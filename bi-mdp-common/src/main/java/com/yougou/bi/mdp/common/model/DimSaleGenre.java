package com.yougou.bi.mdp.common.model;

import java.io.Serializable;


/**
 * 
* @ProjectName:bi-report-common
* @ClassName: DimSaleChannel 
* @Description: 销售渠道实体类---对于数据库 DIM_PRO_SAL_GENRE表
* @author qinnan
* @date 2018年8月8日 下午3:10:50
 */
public class DimSaleGenre implements Serializable{

    /** 
    * @Fields serialVersionUID : TODO
    */ 
    private static final long serialVersionUID = 1L;

    /**
     * 品牌编号
     */
    private String brandNoDetailNo;
    
    /**
     * 销售类型编号
     */
    private String salGenreNo;
    
    /**
     * 销售类型中文名
     */
    private String salGenreName;

    public DimSaleGenre() {
        super();
    }

    public DimSaleGenre(String brandNoDetailNo, String salGenreNo, String salGenreName) {
        super();
        this.brandNoDetailNo = brandNoDetailNo;
        this.salGenreNo = salGenreNo;
        this.salGenreName = salGenreName;
    }

    public String getBrandNoDetailNo() {
        return brandNoDetailNo;
    }

    public void setBrandNoDetailNo(String brandNoDetailNo) {
        this.brandNoDetailNo = brandNoDetailNo;
    }

    public String getSalGenreNo() {
        return salGenreNo;
    }

    public void setSalGenreNo(String salGenreNo) {
        this.salGenreNo = salGenreNo;
    }

    public String getSalGenreName() {
        return salGenreName;
    }

    public void setSalGenreName(String salGenreName) {
        this.salGenreName = salGenreName;
    }
}
