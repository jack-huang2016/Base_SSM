package com.yougou.bi.mdp.service.condition;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.yougou.bi.mdp.common.model.DimLargeCategory;
import com.yougou.bi.mdp.common.model.DimOrgAllinfo;
import com.yougou.bi.mdp.common.model.DimRdsite;
import com.yougou.bi.mdp.common.model.DimSaleGenre;
import com.yougou.bi.mdp.common.model.DimStyleSource;
import com.yougou.bi.mdp.dal.database.DimOrgAllinfoMapper;
import com.yougou.bi.mdp.service.DimOrgAllinfoService;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.dal.database.BaseCrudMapper;
import com.yougou.logistics.base.service.BaseCrudServiceImpl;

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
@Service("dimOrgAllinfoService")
class DimOrgAllinfoServiceImpl extends BaseCrudServiceImpl implements
		DimOrgAllinfoService {
	@Resource
	private DimOrgAllinfoMapper dimOrgAllinfoMapper;

	@Override
	public BaseCrudMapper init() {
		return dimOrgAllinfoMapper;
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-storecategoryno1", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getStoreCategoryNo1(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
		try {
			return dimOrgAllinfoMapper.selectStoreCategoryNo1(dimOrgAllinfo,
					params);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-managecity", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getQueryManageCity(Map<String, Object> params,
			String cacheKey) throws ServiceException {
		List<DimOrgAllinfo> list = null;
		try {
			list = dimOrgAllinfoMapper.getQueryManageCity(params);
		} catch (Exception e) {
			throw new ServiceException("", e);
		}
		return list;
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-businesscity", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getBusinessCity(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectBusinessCity(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-subarea", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getSubArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.getSubArea(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-businesscitynew", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getBusinessCityNew(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey) {
		return dimOrgAllinfoMapper.getBusinessCityNew(params);
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-partarea", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getPartArea(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectPartArea(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-businesscircle", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getBusinessCircle(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectBusinessCircle(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-mall", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getMall(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectMall(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-mallnobyname", key = "#name", condition = "#name!=null")
	public String selectMallNoByName(String name) throws ServiceException {
		try {
			return dimOrgAllinfoMapper.selectMallNoByName(name);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-businessgroup", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getBusinessGroup(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectBusinessGroup(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-location", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getLocation(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
		try {
			return dimOrgAllinfoMapper.selectLocation(dimOrgAllinfo, params);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-counties", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getCounties(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectCounties(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-allinfocategoryno", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getCategoryNo(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
		try {
			return dimOrgAllinfoMapper.selectCategoryNo(dimOrgAllinfo, params);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-provinces")
	public List<Map<String, String>> queryProvinces() throws ServiceException {
		try {
			return dimOrgAllinfoMapper.queryProvinces();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-countys", key = "'bi-mdp-condition-dimorgallinfo-countys-queryCountys-cacheKey'")
	public List<Map<String, String>> queryCountys() throws ServiceException {
		try {
			return dimOrgAllinfoMapper.queryCountys();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-conditionegionnameforlog", key = "#cacheKey", condition = "#cacheKey!=null")
	public String selectRegionNameForLog(Map<String, Object> params,
			String cacheKey) throws ServiceException {
		try {
			return dimOrgAllinfoMapper.selectRegionNameForLog(params);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	@Cacheable(value = "bi-mdp-conditionmanagingcitynobyname", key = "#cacheKey", condition = "#cacheKey!=null")
	public String selectManagingCityNo(Map<String, Object> params,
			String cacheKey) throws ServiceException {
		try {
			return dimOrgAllinfoMapper.selectManagingCityNo(params);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-orderunits", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<Map<String, String>> getOrderUnits(Map<String, Object> params,
			String cacheKey) {
	    List<Map<String, String>> list;
	    list = dimOrgAllinfoMapper.getOrderUnits(params);
		return list;
	}
	
	@Override
	@Cacheable(value = "bi-mdp-condition-dimorgallinfo-mall", key = "#cacheKey", condition = "#cacheKey!=null")
	public List<DimOrgAllinfo> getMalls(DimOrgAllinfo dimOrgAllinfo,
			Map<String, Object> params, String cacheKey)
			throws ServiceException {
	    List<DimOrgAllinfo> list;
		try {
		    list = dimOrgAllinfoMapper.selectMalls(dimOrgAllinfo, params);
			return list;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

    @Override
    @Cacheable(value = "bi-mdp-condition-dimorgallinfo-gener", key = "#cacheKey", condition = "#cacheKey!=null")
    public List<DimSaleGenre> getGeners(Map<String, Object> params, String cacheKey)
            throws ServiceException {
        List<DimSaleGenre> list;
        try {
            list = dimOrgAllinfoMapper.getGeners(params);
            return list;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Cacheable(value = "bi-mdp-condition-dimorgallinfo-style-source", key = "#cacheKey", condition = "#cacheKey!=null")
    public List<DimStyleSource> getStyleSource(Map<String, Object> params, String cacheKey)
            throws ServiceException {
        List<DimStyleSource> list;
        try {
            list = dimOrgAllinfoMapper.getStyleSource(params);
            return list;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Cacheable(value = "bi-mdp-condition-dimorgallinfo-rdsite", key = "#cacheKey", condition = "#cacheKey!=null")
    public List<DimRdsite> getRdsite(Map<String, Object> params, String cacheKey)
            throws ServiceException {
        List<DimRdsite> list;
        try {
            list = dimOrgAllinfoMapper.getRdsite(params);
            return list;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    @Cacheable(value = "bi-mdp-condition-dimorgallinfo-large-category", key = "#cacheKey", condition = "#cacheKey!=null")
    public List<DimLargeCategory> getLargeCategory(Map<String, Object> params, String cacheKey)
            throws ServiceException {
        List<DimLargeCategory> list;
        try {
            list = dimOrgAllinfoMapper.getLargeCategory(params);
            return list;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}