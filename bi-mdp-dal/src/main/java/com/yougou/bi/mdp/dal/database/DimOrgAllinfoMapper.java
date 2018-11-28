package com.yougou.bi.mdp.dal.database;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yougou.bi.mdp.common.model.DimLargeCategory;
import com.yougou.bi.mdp.common.model.DimOrgAllinfo;
import com.yougou.bi.mdp.common.model.DimRdsite;
import com.yougou.bi.mdp.common.model.DimSaleGenre;
import com.yougou.bi.mdp.common.model.DimStyleSource;
import com.yougou.logistics.base.dal.database.BaseCrudMapper;

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
public interface DimOrgAllinfoMapper extends BaseCrudMapper {

	public List<DimOrgAllinfo> selectStoreCategoryNo1(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	public List<DimOrgAllinfo> getQueryManageCity(@Param("params")  Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectBusinessCity(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectPartArea(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectBusinessCircle(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectMall(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectBusinessGroup(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectLocation(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectCounties(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> selectCategoryNo(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
	
	public List<Map<String, String>> queryProvinces();
	
	public List<Map<String, String>> queryCountys();
	
	public String selectMallNoByName(String mallName);
	
	public String selectRegionNameForLog(@Param("params") Map<String, Object> params);
	
	public String selectManagingCityNo(@Param("params") Map<String, Object> params);
	
	public List<Map<String,String>> getOrderUnits(@Param("params") Map<String, Object> params);
	
	public List<DimSaleGenre> getGeners(@Param("params") Map<String, Object> params);
	
	public List<DimStyleSource> getStyleSource(@Param("params") Map<String, Object> params);
	
	public List<DimLargeCategory> getLargeCategory(@Param("params") Map<String, Object> params);
	
	public List<DimRdsite> getRdsite(@Param("params") Map<String, Object> params);
	
	public List<DimOrgAllinfo> getBusinessCityNew(@Param("params") Map<String, Object> params);
  
	public List<DimOrgAllinfo> getSubArea(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);

	public List<DimOrgAllinfo> selectMalls(@Param("model")DimOrgAllinfo dimOrgAllinfo,
			@Param("params") Map<String, Object> params);
}