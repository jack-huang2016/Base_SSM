package com.yougou.bi.mdp.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 请写出类的用途 
 * @author Administrator
 * @date  2014-12-17 12:10:32
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

public class DimOrgAllinfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 品牌编码+店铺编码+机构标志/品牌编码+订货单位编码+机构标志
     */
    private String organNo;

    /**
     * 店铺编码/订货单位编码
     */
    private String organLno;

    /**
     * 店铺名称/订货单位名称
     */
    private String organName;

    /**
     * 机构标志：0 店铺；1 订货单位
     */
    private BigDecimal organFlag;

    /**
     * 品牌编码
     */
    private String brandDetailNo;

    /**
     * 品牌英文名
     */
    private String brandDetailEname;

    /**
     * 品牌中文名
     */
    private String brandDetailCname;

    /**
     * 地区编码
     */
    private String regionNo;

    /**
     * 地区名称
     */
    private String regionName;

    /**
     * 省区编码
     */
    private String managingProvinceNo;

    /**
     * 省区名称
     */
    private String managingProvinceName;

    /**
     * 管理区域编码
     */
    private String managingAreaNo;

    /**
     * 管理区域名称
     */
    private String managingAreaName;

    /**
     * 管理城市编码
     */
    private String managingCityNo;

    /**
     * 管理城市名称
     */
    private String managingCityName;

    /**
     * 经营城市编码
     */
    private String businessCityNo;

    /**
     * 经营城市名称
     */
    private String businessCityName;

    /**
     * 订货单位编码
     */
    private String orderUnitNo;

    /**
     * 订货单位名称
     */
    private String orderUnitName;

    /**
     * 行政省编码
     */
    private String provinceNo;

    /**
     * 行政省名称
     */
    private String provinceName;

    /**
     * 行政市编码
     */
    private String cityNo;

    /**
     * 行政市名称
     */
    private String cityName;

    /**
     * 行政县编码
     */
    private String countyNo;

    /**
     * 行政县名称
     */
    private String countyName;

    /**
     * 片区编码
     */
    private String partAreaNo;

    /**
     * 片区名称
     */
    private String partAreaName;

    /**
     * 商圈编码
     */
    private String businessCircleNo;

    /**
     * 商圈名称
     */
    private String businessCircleName;

    /**
     * 店铺级别
     */
    private String storeLevel;

    /**
     * 开店日
     */
    private String opendt;

    /**
     * 关店日
     */
    private String closedt;

    /**
     * 商场编码
     */
    private String mallNo;

    /**
     * 商场名称
     */
    private String mallName;

    /**
     * 商业集团编码
     */
    private String businessGroupNo;

    /**
     * 商业集团名称
     */
    private String businessGroupName;

    /**
     * 柜位形式编码
     */
    private String locationNo;

    /**
     * 柜位形式名称
     */
    private String locationName;

    /**
     * 店铺类别编码
     */
    private String storeCategoryNo1;

    /**
     * 店铺类别名称
     */
    private String storeCategoryName1;

    /**
     * 店铺大类编码
     */
    private String storeCategoryNo2;

    /**
     * 店铺大类名称
     */
    private String storeCategoryName2;

    /**
     * 店铺小类编码
     */
    private String storeCategoryNo3;

    /**
     * 店铺小类名称
     */
    private String storeCategoryName3;

    /**
     * 销售渠道编码
     */
    private String storeChannelNo;

    /**
     * 销售渠道名称
     */
    private String storeChannelName;

    /**
     * 销售渠道编码2
     */
    private String storeChannelNo2;

    /**
     * 销售渠道名称2
     */
    private String storeChannelName2;

    /**
     * 销售渠道编码3
     */
    private String storeChannelNo3;

    /**
     * 销售渠道名称3
     */
    private String storeChannelName3;

    /**
     * 经营品类编码
     */
    private String categoryNo;

    /**
     * 经营品类名称
     */
    private String categoryName;
    
    /**
     * 分区编号
     */
    private String subAreaNo;
    
    /**
     * 分区名称
     */
    private String subAreaName;

    /**
     * 
     * {@linkplain #organNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.ORGAN_NO
     */
    public String getOrganNo() {
        return organNo;
    }

    /**
     * 
     * {@linkplain #organNo}
     * @param organNo the value for U_MD_DM.DIM_ORG_ALLINFO.ORGAN_NO
     */
    public void setOrganNo(String organNo) {
        this.organNo = organNo;
    }

    /**
     * 
     * {@linkplain #organLno}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.ORGAN_LNO
     */
    public String getOrganLno() {
        return organLno;
    }

    /**
     * 
     * {@linkplain #organLno}
     * @param organLno the value for U_MD_DM.DIM_ORG_ALLINFO.ORGAN_LNO
     */
    public void setOrganLno(String organLno) {
        this.organLno = organLno;
    }

    /**
     * 
     * {@linkplain #organName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.ORGAN_NAME
     */
    public String getOrganName() {
        return organName;
    }

    /**
     * 
     * {@linkplain #organName}
     * @param organName the value for U_MD_DM.DIM_ORG_ALLINFO.ORGAN_NAME
     */
    public void setOrganName(String organName) {
        this.organName = organName;
    }

    /**
     * 
     * {@linkplain #organFlag}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.ORGAN_FLAG
     */
    public BigDecimal getOrganFlag() {
        return organFlag;
    }

    /**
     * 
     * {@linkplain #organFlag}
     * @param organFlag the value for U_MD_DM.DIM_ORG_ALLINFO.ORGAN_FLAG
     */
    public void setOrganFlag(BigDecimal organFlag) {
        this.organFlag = organFlag;
    }

    /**
     * 
     * {@linkplain #brandDetailNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BRAND_DETAIL_NO
     */
    public String getBrandDetailNo() {
        return brandDetailNo;
    }

    /**
     * 
     * {@linkplain #brandDetailNo}
     * @param brandDetailNo the value for U_MD_DM.DIM_ORG_ALLINFO.BRAND_DETAIL_NO
     */
    public void setBrandDetailNo(String brandDetailNo) {
        this.brandDetailNo = brandDetailNo;
    }

    /**
     * 
     * {@linkplain #brandDetailEname}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BRAND_DETAIL_ENAME
     */
    public String getBrandDetailEname() {
        return brandDetailEname;
    }

    /**
     * 
     * {@linkplain #brandDetailEname}
     * @param brandDetailEname the value for U_MD_DM.DIM_ORG_ALLINFO.BRAND_DETAIL_ENAME
     */
    public void setBrandDetailEname(String brandDetailEname) {
        this.brandDetailEname = brandDetailEname;
    }

    /**
     * 
     * {@linkplain #brandDetailCname}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BRAND_DETAIL_CNAME
     */
    public String getBrandDetailCname() {
        return brandDetailCname;
    }

    /**
     * 
     * {@linkplain #brandDetailCname}
     * @param brandDetailCname the value for U_MD_DM.DIM_ORG_ALLINFO.BRAND_DETAIL_CNAME
     */
    public void setBrandDetailCname(String brandDetailCname) {
        this.brandDetailCname = brandDetailCname;
    }

    /**
     * 
     * {@linkplain #regionNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.REGION_NO
     */
    public String getRegionNo() {
        return regionNo;
    }

    /**
     * 
     * {@linkplain #regionNo}
     * @param regionNo the value for U_MD_DM.DIM_ORG_ALLINFO.REGION_NO
     */
    public void setRegionNo(String regionNo) {
        this.regionNo = regionNo;
    }

    /**
     * 
     * {@linkplain #regionName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.REGION_NAME
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 
     * {@linkplain #regionName}
     * @param regionName the value for U_MD_DM.DIM_ORG_ALLINFO.REGION_NAME
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 
     * {@linkplain #managingProvinceNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MANAGING_PROVINCE_NO
     */
    public String getManagingProvinceNo() {
        return managingProvinceNo;
    }

    /**
     * 
     * {@linkplain #managingProvinceNo}
     * @param managingProvinceNo the value for U_MD_DM.DIM_ORG_ALLINFO.MANAGING_PROVINCE_NO
     */
    public void setManagingProvinceNo(String managingProvinceNo) {
        this.managingProvinceNo = managingProvinceNo;
    }

    /**
     * 
     * {@linkplain #managingProvinceName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MANAGING_PROVINCE_NAME
     */
    public String getManagingProvinceName() {
        return managingProvinceName;
    }

    /**
     * 
     * {@linkplain #managingProvinceName}
     * @param managingProvinceName the value for U_MD_DM.DIM_ORG_ALLINFO.MANAGING_PROVINCE_NAME
     */
    public void setManagingProvinceName(String managingProvinceName) {
        this.managingProvinceName = managingProvinceName;
    }

    /**
     * 
     * {@linkplain #managingAreaNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MANAGING_AREA_NO
     */
    public String getManagingAreaNo() {
        return managingAreaNo;
    }

    /**
     * 
     * {@linkplain #managingAreaNo}
     * @param managingAreaNo the value for U_MD_DM.DIM_ORG_ALLINFO.MANAGING_AREA_NO
     */
    public void setManagingAreaNo(String managingAreaNo) {
        this.managingAreaNo = managingAreaNo;
    }

    /**
     * 
     * {@linkplain #managingAreaName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MANAGING_AREA_NAME
     */
    public String getManagingAreaName() {
        return managingAreaName;
    }

    /**
     * 
     * {@linkplain #managingAreaName}
     * @param managingAreaName the value for U_MD_DM.DIM_ORG_ALLINFO.MANAGING_AREA_NAME
     */
    public void setManagingAreaName(String managingAreaName) {
        this.managingAreaName = managingAreaName;
    }

    /**
     * 
     * {@linkplain #managingCityNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MANAGING_CITY_NO
     */
    public String getManagingCityNo() {
        return managingCityNo;
    }

    /**
     * 
     * {@linkplain #managingCityNo}
     * @param managingCityNo the value for U_MD_DM.DIM_ORG_ALLINFO.MANAGING_CITY_NO
     */
    public void setManagingCityNo(String managingCityNo) {
        this.managingCityNo = managingCityNo;
    }

    /**
     * 
     * {@linkplain #managingCityName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MANAGING_CITY_NAME
     */
    public String getManagingCityName() {
        return managingCityName;
    }

    /**
     * 
     * {@linkplain #managingCityName}
     * @param managingCityName the value for U_MD_DM.DIM_ORG_ALLINFO.MANAGING_CITY_NAME
     */
    public void setManagingCityName(String managingCityName) {
        this.managingCityName = managingCityName;
    }

    /**
     * 
     * {@linkplain #businessCityNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CITY_NO
     */
    public String getBusinessCityNo() {
        return businessCityNo;
    }

    /**
     * 
     * {@linkplain #businessCityNo}
     * @param businessCityNo the value for U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CITY_NO
     */
    public void setBusinessCityNo(String businessCityNo) {
        this.businessCityNo = businessCityNo;
    }

    /**
     * 
     * {@linkplain #businessCityName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CITY_NAME
     */
    public String getBusinessCityName() {
        return businessCityName;
    }

    /**
     * 
     * {@linkplain #businessCityName}
     * @param businessCityName the value for U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CITY_NAME
     */
    public void setBusinessCityName(String businessCityName) {
        this.businessCityName = businessCityName;
    }

    /**
     * 
     * {@linkplain #orderUnitNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.ORDER_UNIT_NO
     */
    public String getOrderUnitNo() {
        return orderUnitNo;
    }

    /**
     * 
     * {@linkplain #orderUnitNo}
     * @param orderUnitNo the value for U_MD_DM.DIM_ORG_ALLINFO.ORDER_UNIT_NO
     */
    public void setOrderUnitNo(String orderUnitNo) {
        this.orderUnitNo = orderUnitNo;
    }

    /**
     * 
     * {@linkplain #orderUnitName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.ORDER_UNIT_NAME
     */
    public String getOrderUnitName() {
        return orderUnitName;
    }

    /**
     * 
     * {@linkplain #orderUnitName}
     * @param orderUnitName the value for U_MD_DM.DIM_ORG_ALLINFO.ORDER_UNIT_NAME
     */
    public void setOrderUnitName(String orderUnitName) {
        this.orderUnitName = orderUnitName;
    }

    /**
     * 
     * {@linkplain #provinceNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.PROVINCE_NO
     */
    public String getProvinceNo() {
        return provinceNo;
    }

    /**
     * 
     * {@linkplain #provinceNo}
     * @param provinceNo the value for U_MD_DM.DIM_ORG_ALLINFO.PROVINCE_NO
     */
    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    /**
     * 
     * {@linkplain #provinceName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.PROVINCE_NAME
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 
     * {@linkplain #provinceName}
     * @param provinceName the value for U_MD_DM.DIM_ORG_ALLINFO.PROVINCE_NAME
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 
     * {@linkplain #cityNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.CITY_NO
     */
    public String getCityNo() {
        return cityNo;
    }

    /**
     * 
     * {@linkplain #cityNo}
     * @param cityNo the value for U_MD_DM.DIM_ORG_ALLINFO.CITY_NO
     */
    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    /**
     * 
     * {@linkplain #cityName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.CITY_NAME
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 
     * {@linkplain #cityName}
     * @param cityName the value for U_MD_DM.DIM_ORG_ALLINFO.CITY_NAME
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 
     * {@linkplain #countyNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.COUNTY_NO
     */
    public String getCountyNo() {
        return countyNo;
    }

    /**
     * 
     * {@linkplain #countyNo}
     * @param countyNo the value for U_MD_DM.DIM_ORG_ALLINFO.COUNTY_NO
     */
    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }

    /**
     * 
     * {@linkplain #countyName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.COUNTY_NAME
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * 
     * {@linkplain #countyName}
     * @param countyName the value for U_MD_DM.DIM_ORG_ALLINFO.COUNTY_NAME
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /**
     * 
     * {@linkplain #partAreaNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.PART_AREA_NO
     */
    public String getPartAreaNo() {
        return partAreaNo;
    }

    /**
     * 
     * {@linkplain #partAreaNo}
     * @param partAreaNo the value for U_MD_DM.DIM_ORG_ALLINFO.PART_AREA_NO
     */
    public void setPartAreaNo(String partAreaNo) {
        this.partAreaNo = partAreaNo;
    }

    /**
     * 
     * {@linkplain #partAreaName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.PART_AREA_NAME
     */
    public String getPartAreaName() {
        return partAreaName;
    }

    /**
     * 
     * {@linkplain #partAreaName}
     * @param partAreaName the value for U_MD_DM.DIM_ORG_ALLINFO.PART_AREA_NAME
     */
    public void setPartAreaName(String partAreaName) {
        this.partAreaName = partAreaName;
    }

    /**
     * 
     * {@linkplain #businessCircleNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CIRCLE_NO
     */
    public String getBusinessCircleNo() {
        return businessCircleNo;
    }

    /**
     * 
     * {@linkplain #businessCircleNo}
     * @param businessCircleNo the value for U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CIRCLE_NO
     */
    public void setBusinessCircleNo(String businessCircleNo) {
        this.businessCircleNo = businessCircleNo;
    }

    /**
     * 
     * {@linkplain #businessCircleName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CIRCLE_NAME
     */
    public String getBusinessCircleName() {
        return businessCircleName;
    }

    /**
     * 
     * {@linkplain #businessCircleName}
     * @param businessCircleName the value for U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_CIRCLE_NAME
     */
    public void setBusinessCircleName(String businessCircleName) {
        this.businessCircleName = businessCircleName;
    }

    /**
     * 
     * {@linkplain #storeLevel}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_LEVEL
     */
    public String getStoreLevel() {
        return storeLevel;
    }

    /**
     * 
     * {@linkplain #storeLevel}
     * @param storeLevel the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_LEVEL
     */
    public void setStoreLevel(String storeLevel) {
        this.storeLevel = storeLevel;
    }

    /**
     * 
     * {@linkplain #opendt}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.OPENDT
     */
    public String getOpendt() {
        return opendt;
    }

    /**
     * 
     * {@linkplain #opendt}
     * @param opendt the value for U_MD_DM.DIM_ORG_ALLINFO.OPENDT
     */
    public void setOpendt(String opendt) {
        this.opendt = opendt;
    }

    /**
     * 
     * {@linkplain #closedt}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.CLOSEDT
     */
    public String getClosedt() {
        return closedt;
    }

    /**
     * 
     * {@linkplain #closedt}
     * @param closedt the value for U_MD_DM.DIM_ORG_ALLINFO.CLOSEDT
     */
    public void setClosedt(String closedt) {
        this.closedt = closedt;
    }

    /**
     * 
     * {@linkplain #mallNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MALL_NO
     */
    public String getMallNo() {
        return mallNo;
    }

    /**
     * 
     * {@linkplain #mallNo}
     * @param mallNo the value for U_MD_DM.DIM_ORG_ALLINFO.MALL_NO
     */
    public void setMallNo(String mallNo) {
        this.mallNo = mallNo;
    }

    /**
     * 
     * {@linkplain #mallName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.MALL_NAME
     */
    public String getMallName() {
        return mallName;
    }

    /**
     * 
     * {@linkplain #mallName}
     * @param mallName the value for U_MD_DM.DIM_ORG_ALLINFO.MALL_NAME
     */
    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    /**
     * 
     * {@linkplain #businessGroupNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_GROUP_NO
     */
    public String getBusinessGroupNo() {
        return businessGroupNo;
    }

    /**
     * 
     * {@linkplain #businessGroupNo}
     * @param businessGroupNo the value for U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_GROUP_NO
     */
    public void setBusinessGroupNo(String businessGroupNo) {
        this.businessGroupNo = businessGroupNo;
    }

    /**
     * 
     * {@linkplain #businessGroupName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_GROUP_NAME
     */
    public String getBusinessGroupName() {
        return businessGroupName;
    }

    /**
     * 
     * {@linkplain #businessGroupName}
     * @param businessGroupName the value for U_MD_DM.DIM_ORG_ALLINFO.BUSINESS_GROUP_NAME
     */
    public void setBusinessGroupName(String businessGroupName) {
        this.businessGroupName = businessGroupName;
    }

    /**
     * 
     * {@linkplain #locationNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.LOCATION_NO
     */
    public String getLocationNo() {
        return locationNo;
    }

    /**
     * 
     * {@linkplain #locationNo}
     * @param locationNo the value for U_MD_DM.DIM_ORG_ALLINFO.LOCATION_NO
     */
    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
    }

    /**
     * 
     * {@linkplain #locationName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.LOCATION_NAME
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 
     * {@linkplain #locationName}
     * @param locationName the value for U_MD_DM.DIM_ORG_ALLINFO.LOCATION_NAME
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 
     * {@linkplain #storeCategoryNo1}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NO1
     */
    public String getStoreCategoryNo1() {
        return storeCategoryNo1;
    }

    /**
     * 
     * {@linkplain #storeCategoryNo1}
     * @param storeCategoryNo1 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NO1
     */
    public void setStoreCategoryNo1(String storeCategoryNo1) {
        this.storeCategoryNo1 = storeCategoryNo1;
    }

    /**
     * 
     * {@linkplain #storeCategoryName1}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NAME1
     */
    public String getStoreCategoryName1() {
        return storeCategoryName1;
    }

    /**
     * 
     * {@linkplain #storeCategoryName1}
     * @param storeCategoryName1 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NAME1
     */
    public void setStoreCategoryName1(String storeCategoryName1) {
        this.storeCategoryName1 = storeCategoryName1;
    }

    /**
     * 
     * {@linkplain #storeCategoryNo2}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NO2
     */
    public String getStoreCategoryNo2() {
        return storeCategoryNo2;
    }

    /**
     * 
     * {@linkplain #storeCategoryNo2}
     * @param storeCategoryNo2 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NO2
     */
    public void setStoreCategoryNo2(String storeCategoryNo2) {
        this.storeCategoryNo2 = storeCategoryNo2;
    }

    /**
     * 
     * {@linkplain #storeCategoryName2}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NAME2
     */
    public String getStoreCategoryName2() {
        return storeCategoryName2;
    }

    /**
     * 
     * {@linkplain #storeCategoryName2}
     * @param storeCategoryName2 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NAME2
     */
    public void setStoreCategoryName2(String storeCategoryName2) {
        this.storeCategoryName2 = storeCategoryName2;
    }

    /**
     * 
     * {@linkplain #storeCategoryNo3}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NO3
     */
    public String getStoreCategoryNo3() {
        return storeCategoryNo3;
    }

    /**
     * 
     * {@linkplain #storeCategoryNo3}
     * @param storeCategoryNo3 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NO3
     */
    public void setStoreCategoryNo3(String storeCategoryNo3) {
        this.storeCategoryNo3 = storeCategoryNo3;
    }

    /**
     * 
     * {@linkplain #storeCategoryName3}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NAME3
     */
    public String getStoreCategoryName3() {
        return storeCategoryName3;
    }

    /**
     * 
     * {@linkplain #storeCategoryName3}
     * @param storeCategoryName3 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CATEGORY_NAME3
     */
    public void setStoreCategoryName3(String storeCategoryName3) {
        this.storeCategoryName3 = storeCategoryName3;
    }

    /**
     * 
     * {@linkplain #storeChannelNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NO
     */
    public String getStoreChannelNo() {
        return storeChannelNo;
    }

    /**
     * 
     * {@linkplain #storeChannelNo}
     * @param storeChannelNo the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NO
     */
    public void setStoreChannelNo(String storeChannelNo) {
        this.storeChannelNo = storeChannelNo;
    }

    /**
     * 
     * {@linkplain #storeChannelName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NAME
     */
    public String getStoreChannelName() {
        return storeChannelName;
    }

    /**
     * 
     * {@linkplain #storeChannelName}
     * @param storeChannelName the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NAME
     */
    public void setStoreChannelName(String storeChannelName) {
        this.storeChannelName = storeChannelName;
    }

    /**
     * 
     * {@linkplain #storeChannelNo2}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NO2
     */
    public String getStoreChannelNo2() {
        return storeChannelNo2;
    }

    /**
     * 
     * {@linkplain #storeChannelNo2}
     * @param storeChannelNo2 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NO2
     */
    public void setStoreChannelNo2(String storeChannelNo2) {
        this.storeChannelNo2 = storeChannelNo2;
    }

    /**
     * 
     * {@linkplain #storeChannelName2}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NAME2
     */
    public String getStoreChannelName2() {
        return storeChannelName2;
    }

    /**
     * 
     * {@linkplain #storeChannelName2}
     * @param storeChannelName2 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NAME2
     */
    public void setStoreChannelName2(String storeChannelName2) {
        this.storeChannelName2 = storeChannelName2;
    }

    /**
     * 
     * {@linkplain #storeChannelNo3}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NO3
     */
    public String getStoreChannelNo3() {
        return storeChannelNo3;
    }

    /**
     * 
     * {@linkplain #storeChannelNo3}
     * @param storeChannelNo3 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NO3
     */
    public void setStoreChannelNo3(String storeChannelNo3) {
        this.storeChannelNo3 = storeChannelNo3;
    }

    /**
     * 
     * {@linkplain #storeChannelName3}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NAME3
     */
    public String getStoreChannelName3() {
        return storeChannelName3;
    }

    /**
     * 
     * {@linkplain #storeChannelName3}
     * @param storeChannelName3 the value for U_MD_DM.DIM_ORG_ALLINFO.STORE_CHANNEL_NAME3
     */
    public void setStoreChannelName3(String storeChannelName3) {
        this.storeChannelName3 = storeChannelName3;
    }

    /**
     * 
     * {@linkplain #categoryNo}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.CATEGORY_NO
     */
    public String getCategoryNo() {
        return categoryNo;
    }

    /**
     * 
     * {@linkplain #categoryNo}
     * @param categoryNo the value for U_MD_DM.DIM_ORG_ALLINFO.CATEGORY_NO
     */
    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    /**
     * 
     * {@linkplain #categoryName}
     *
     * @return the value of U_MD_DM.DIM_ORG_ALLINFO.CATEGORY_NAME
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * {@linkplain #categoryName}
     * @param categoryName the value for U_MD_DM.DIM_ORG_ALLINFO.CATEGORY_NAME
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

	public String getSubAreaNo() {
		return subAreaNo;
	}

	public void setSubAreaNo(String subAreaNo) {
		this.subAreaNo = subAreaNo;
	}

	public String getSubAreaName() {
		return subAreaName;
	}

	public void setSubAreaName(String subAreaName) {
		this.subAreaName = subAreaName;
	}
}