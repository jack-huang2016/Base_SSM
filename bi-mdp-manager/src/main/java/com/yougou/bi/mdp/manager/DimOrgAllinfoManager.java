package com.yougou.bi.mdp.manager;

import java.util.List;
import java.util.Map;
import com.yougou.bi.mdp.common.model.DimLargeCategory;
import com.yougou.bi.mdp.common.model.DimOrgAllinfo;
import com.yougou.bi.mdp.common.model.DimRdsite;
import com.yougou.bi.mdp.common.model.DimSaleGenre;
import com.yougou.bi.mdp.common.model.DimStyleSource;

import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.manager.BaseCrudManager;

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
public interface DimOrgAllinfoManager extends BaseCrudManager {

	public List<DimOrgAllinfo> getStoreCategoryNo1(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getQueryManageCity(Map<String, Object> params)throws ManagerException;;
	
	public List<DimOrgAllinfo> getBusinessCity(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getPartArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getBusinessCircle(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getMall(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getBusinessGroup(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getLocation(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getCounties(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimOrgAllinfo> getCategoryNo(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<Map<String, String>> queryProvinces() throws ManagerException;
	
	public List<Map<String, String>> queryCountys() throws ManagerException;
	
	public String selectMallNoByName(String nallName) throws ManagerException;
	
	public String selectRegionNameForLog(Map<String, Object> params)throws ManagerException;
	
	public String selectManagingCityNo(Map<String, Object> params)throws ManagerException;

	public List<Map<String,String>> getOrderUnits(Map<String, Object> params);

	public List<DimOrgAllinfo> getBusinessCityNew(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params);

	List<DimOrgAllinfo> getSubArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException;

	public List<DimOrgAllinfo> getMalls(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params)throws ManagerException;
	
	public List<DimSaleGenre> getSaleGeners(Map<String, Object> params)
	        throws ManagerException;
	public List<DimStyleSource> getStyleSource(Map<String, Object> params)
               throws ManagerException;
      
   public List<DimRdsite> getRdsite(Map<String, Object> params)
               throws ManagerException;
       
   public List<DimLargeCategory> getLargeCategory(Map<String, Object> params)
               throws ManagerException;
	          
}