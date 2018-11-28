package com.yougou.bi.mdp.manager;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.yougou.bi.mdp.common.model.DimLargeCategory;
import com.yougou.bi.mdp.common.model.DimOrgAllinfo;
import com.yougou.bi.mdp.common.model.DimRdsite;
import com.yougou.bi.mdp.common.model.DimSaleGenre;
import com.yougou.bi.mdp.common.model.DimStyleSource;
import com.yougou.bi.mdp.common.utils.CommonUtil;
import com.yougou.bi.mdp.service.DimOrgAllinfoService;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.manager.BaseCrudManagerImpl;
import com.yougou.logistics.base.service.BaseCrudService;

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
@Service("dimOrgAllinfoManager")
class DimOrgAllinfoManagerImpl extends BaseCrudManagerImpl implements DimOrgAllinfoManager {
    @Resource
    private DimOrgAllinfoService dimOrgAllinfoService;

    @Override
    public BaseCrudService init() {
        return dimOrgAllinfoService;
    }

	@Override
	public List<DimOrgAllinfo> getStoreCategoryNo1(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getStoreCategoryNo1(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<DimOrgAllinfo> getQueryManageCity(Map<String, Object> params)
			throws ManagerException {
		List<DimOrgAllinfo> list=null;
		try{
			list=dimOrgAllinfoService.getQueryManageCity(params,CommonUtil.transMapToString(params));
		}catch(ServiceException e){
			throw new ManagerException(e.getMessage(),e);
		}
		return list;
	}

	@Override
	public List<DimOrgAllinfo> getBusinessCity(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getBusinessCity(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<DimOrgAllinfo> getSubArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getSubArea(dimOrgAllinfo, params, CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<DimOrgAllinfo> getBusinessCityNew(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) {
		//拼接整理管理城市条件
		String managing_citiesStr = (String)params.get("managing_cities");
		String[] managing_citiesArray = null;
		if(StringUtils.isNotEmpty(managing_citiesStr)){
			managing_citiesArray = managing_citiesStr.replaceAll("'", "").split(",");
		}
		params.put("managing_cities", managing_citiesArray);
		//拼接整理品牌条件、
		String brand_detail_enamesStr = (String)params.get("brand_detail_enames");
		String[] brand_detail_enamesArray = null;
		if(StringUtils.isNotEmpty(brand_detail_enamesStr)){
			brand_detail_enamesArray = brand_detail_enamesStr.replaceAll("'", "").split(",");
		}
		params.put("brand_detail_enames", brand_detail_enamesArray);
		return dimOrgAllinfoService.getBusinessCityNew(dimOrgAllinfo,params,CommonUtil.transMapToString(params));
	}
	
	@Override
	public List<DimOrgAllinfo> getPartArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		//品牌单选无需处理
		//......
		
		//处理品牌部多选
		String brand_noesStr = (String)params.get("brand_noes");
		String[] brand_noesArray = null;
		if(StringUtils.isNotEmpty(brand_noesStr)){
			brand_noesArray = brand_noesStr.replaceAll("'", "").split(",");
		}
		params.put("brand_noes", brand_noesArray);
		
		//处理地区多选
		String managing_regionsStr = (String)params.get("managing_regions");
		String[] managing_regionsArray = null;
		if(StringUtils.isNotEmpty(managing_regionsStr)){
			managing_regionsArray = managing_regionsStr.replaceAll("'", "").split(",");
		}
		params.put("managing_regions", managing_regionsArray);
		
		try {
			return dimOrgAllinfoService.getPartArea(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<DimOrgAllinfo> getBusinessCircle(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		String managingCitiesStr = (String)params.get("managing_cities");
		String brandNoesStr = (String)params.get("brand_noes");
		String[] managingCitiesArray = null;
		String[] brandNoesArray = null;
		if(StringUtils.isNotEmpty(managingCitiesStr)){
			managingCitiesArray = managingCitiesStr.replaceAll("'", "").split(",");
		}
		if(StringUtils.isNotEmpty(brandNoesStr)){
		    brandNoesArray = brandNoesStr.replaceAll("'", "").split(",");
		}
		params.put("managing_cities", managingCitiesArray);
		params.put("brand_noes", brandNoesArray);
		try {
			return dimOrgAllinfoService.getBusinessCircle(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<DimOrgAllinfo> getMall(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getMall(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public String selectMallNoByName(String mallName) throws ManagerException {
		try {
			return dimOrgAllinfoService.selectMallNoByName(mallName);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<DimOrgAllinfo> getBusinessGroup(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getBusinessGroup(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<DimOrgAllinfo> getLocation(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getLocation(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}


	@Override
	public List<DimOrgAllinfo> getCounties(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		String managing_regionsStr = (String)params.get("managing_regions");
		String[] managing_regionsArray = null;
		if(StringUtils.isNotEmpty(managing_regionsStr)){
			managing_regionsArray = managing_regionsStr.replaceAll("'", "").split(",");
		}
		params.put("managing_regions", managing_regionsArray);
		try {
			return dimOrgAllinfoService.getCounties(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<DimOrgAllinfo> getCategoryNo(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return dimOrgAllinfoService.getCategoryNo(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<Map<String, String>> queryProvinces() throws ManagerException {
		try {
			return dimOrgAllinfoService.queryProvinces();
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<Map<String, String>> queryCountys() throws ManagerException {
		try {
			return dimOrgAllinfoService.queryCountys();
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public String selectRegionNameForLog(Map<String, Object> params)
			throws ManagerException {
		try {
			return dimOrgAllinfoService.selectRegionNameForLog(params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public String selectManagingCityNo(Map<String, Object> params)
			throws ManagerException {
		try {
			return dimOrgAllinfoService.selectManagingCityNo(params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<Map<String,String>> getOrderUnits(Map<String, Object> params) {
		//管理城市%多选
		String managing_citiesStr = (String)params.get("managing_cities");
		String[] managing_citiesArray = null;
		if(StringUtils.isNotEmpty(managing_citiesStr)){
			managing_citiesArray = managing_citiesStr.replaceAll("'", "").split(",");
		}
		params.put("managing_cities", managing_citiesArray);
		//品牌%多选
		String brand_detail_enamesStr = (String)params.get("brand_detail_enames");
		String[] brand_detail_enamesArray = null;
		if(StringUtils.isNotEmpty(brand_detail_enamesStr)){
			brand_detail_enamesArray = brand_detail_enamesStr.replaceAll("'", "").split(",");
		}
		params.put("brand_detail_enames", brand_detail_enamesArray);
		
		//货管单位类型编码%多选
		String order_unit_categoryStr = (String)params.get("order_unit_category");
		String[] order_unit_categoryArray = null;
		if(StringUtils.isNotEmpty(order_unit_categoryStr)){
			order_unit_categoryArray = order_unit_categoryStr.replaceAll("'", "").split(",");
		}
		params.put("order_unit_category", order_unit_categoryArray);
		
		//货管单位类型名称%多选
		String order_unit_category_nameStr = (String)params.get("order_unit_category_name");
		String[] order_unit_category_nameArray = null;
		if(StringUtils.isNotEmpty(order_unit_category_nameStr)){
			order_unit_category_nameArray = order_unit_category_nameStr.replaceAll("'", "").split(",");
		}
		params.put("order_unit_category_name", order_unit_category_nameArray);
		
		return dimOrgAllinfoService.getOrderUnits(params,CommonUtil.transMapToString(params));
	}
	
	@Override
	public List<DimOrgAllinfo> getMalls(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params) throws ManagerException {
		//品牌
		String brandNoes = (String)params.get("brand_noes");
		//商圈
		String businessCircles = (String)params.get("business_circles");
		String managingCities = (String)params.get("managing_cities");//管理城市
		
		String[] businessCirclesArray = null;
		String[] brandNoesArray = null;
		String[] managingCitiesArray = null;
		if(StringUtils.isNotEmpty(managingCities)){
		    managingCitiesArray = managingCities.replaceAll("'", "").split(",");
		}
		if(StringUtils.isNotEmpty(businessCircles)){
			businessCirclesArray = businessCircles.replaceAll("'", "").split(",");
		}
		if(StringUtils.isNotEmpty(brandNoes)){
		    brandNoesArray = brandNoes.replaceAll("'", "").split(",");
		}
		params.put("brand_noes", brandNoesArray);
		params.put("business_circles", businessCirclesArray);
		params.put("managing_cities", managingCitiesArray);
		try {
			return dimOrgAllinfoService.getMalls(dimOrgAllinfo, params,CommonUtil.transMapToString(params));
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

    @Override
    public List<DimSaleGenre> getSaleGeners(Map<String, Object> params) throws ManagerException {
        // TODO Auto-generated method stub
        try {
            String brand_detail_enamesStr = (String)params.get("brand_detail_enames");
            String[] brand_detail_enamesArray = null;
            if(StringUtils.isNotEmpty(brand_detail_enamesStr)){
                brand_detail_enamesArray = brand_detail_enamesStr.replaceAll("'", "").split(",");
            }
            params.put("brand_detail_enames", brand_detail_enamesArray);
            return dimOrgAllinfoService.getGeners(params,CommonUtil.transMapToString(params));
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new ManagerException(e.getMessage(), e);
        }
    }

    @Override
    public List<DimStyleSource> getStyleSource(Map<String, Object> params) throws ManagerException {

        // TODO Auto-generated method stub
        try {
            String brand_detail_enamesStr = (String)params.get("brand_detail_enames");
            String[] brand_detail_enamesArray = null;
            if(StringUtils.isNotEmpty(brand_detail_enamesStr)){
                brand_detail_enamesArray = brand_detail_enamesStr.replaceAll("'", "").split(",");
            }
            params.put("brand_detail_enames", brand_detail_enamesArray);
            return dimOrgAllinfoService.getStyleSource(params,CommonUtil.transMapToString(params));
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new ManagerException(e.getMessage(), e);
        }
    
    }

    @Override
    public List<DimRdsite> getRdsite(Map<String, Object> params) throws ManagerException {

        // TODO Auto-generated method stub
        try {
            String brand_detail_enamesStr = (String)params.get("brand_detail_enames");
            String[] brand_detail_enamesArray = null;
            if(StringUtils.isNotEmpty(brand_detail_enamesStr)){
                brand_detail_enamesArray = brand_detail_enamesStr.replaceAll("'", "").split(",");
            }
            params.put("brand_detail_enames", brand_detail_enamesArray);
            return dimOrgAllinfoService.getRdsite(params,CommonUtil.transMapToString(params));
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new ManagerException(e.getMessage(), e);
        }
    
    }

    @Override
    public List<DimLargeCategory> getLargeCategory(Map<String, Object> params)
            throws ManagerException {

        // TODO Auto-generated method stub
        try {
            String brand_detail_enamesStr = (String)params.get("brand_detail_enames");
            String[] brand_detail_enamesArray = null;
            if(StringUtils.isNotEmpty(brand_detail_enamesStr)){
                brand_detail_enamesArray = brand_detail_enamesStr.replaceAll("'", "").split(",");
            }
            params.put("brand_detail_enames", brand_detail_enamesArray);
            return dimOrgAllinfoService.getLargeCategory(params,CommonUtil.transMapToString(params));
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            throw new ManagerException(e.getMessage(), e);
        }
    }
}