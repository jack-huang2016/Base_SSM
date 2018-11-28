package com.yougou.bi.mdp.service;

import java.util.List;
import java.util.Map;

import com.yougou.bi.mdp.common.model.DimLargeCategory;
import com.yougou.bi.mdp.common.model.DimOrgAllinfo;
import com.yougou.bi.mdp.common.model.DimRdsite;
import com.yougou.bi.mdp.common.model.DimSaleGenre;
import com.yougou.bi.mdp.common.model.DimStyleSource;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.service.BaseCrudService;

/**
 * 请写出类的用途
 * 
 * @author Administrator
 * @date 2014-12-17 12:10:32
 * @version 1.0.0
 * @copyright (C) 2013 YouGou Information Technology Co.,Ltd All Rights
 *            Reserved.
 * 
 *            The software for the YouGou technology development, without the
 *            company's written consent, and any other individuals and
 *            organizations shall not be used, Copying, Modify or distribute the
 *            software.
 * 
 */
public interface DimOrgAllinfoService extends BaseCrudService {

	public List<DimOrgAllinfo> getStoreCategoryNo1(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getQueryManageCity(Map<String, Object> params,
			String cacheKey) throws ServiceException;;

	public List<DimOrgAllinfo> getBusinessCity(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getPartArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getBusinessCircle(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getMall(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getBusinessGroup(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getLocation(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getCounties(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getCategoryNo(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<Map<String, String>> queryProvinces() throws ServiceException;

	public List<Map<String, String>> queryCountys() throws ServiceException;

	public String selectMallNoByName(String mallName) throws ServiceException;

	public String selectRegionNameForLog(Map<String, Object> params,
			String cacheKey) throws ServiceException;
	
	public String selectManagingCityNo(Map<String, Object> params,
			String cacheKey) throws ServiceException;

	public List<Map<String, String>> getOrderUnits(Map<String, Object> params,
			String cacheKey);

	public List<DimOrgAllinfo> getBusinessCityNew(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey);
	
	public List<DimOrgAllinfo> getSubArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimOrgAllinfo> getMalls(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException;

	public List<DimSaleGenre> getGeners(Map<String, Object> params,String cacheKey)
            throws ServiceException;
	
	public List<DimStyleSource> getStyleSource(Map<String, Object> params,String cacheKey)
	            throws ServiceException;
	   
	public List<DimRdsite> getRdsite(Map<String, Object> params,String cacheKey)
	            throws ServiceException;
	    
	public List<DimLargeCategory> getLargeCategory(Map<String, Object> params,String cacheKey)
	            throws ServiceException;

}