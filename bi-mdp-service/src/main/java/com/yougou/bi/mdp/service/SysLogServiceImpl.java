package com.yougou.bi.mdp.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yougou.bi.mdp.common.annotation.SwitchDataSource;
import com.yougou.bi.mdp.common.model.SysLog;
import com.yougou.bi.mdp.dal.database.SysLogMapper;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.common.model.AuthorityParams;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.dal.database.BaseCrudMapper;
import com.yougou.logistics.base.service.BaseCrudServiceImpl;

/**
 * 请写出类的用途 
 * @author Administrator
 * @date  2014-11-07 10:20:29
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
@Service("sysLogService")
@SwitchDataSource("oracleDataSourcePT")
class SysLogServiceImpl extends BaseCrudServiceImpl implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public BaseCrudMapper init() {
        return sysLogMapper;
    }

	@Override
	public List<SysLog> searchSysLog(SimplePage page,
			String sortColumn, String sortOrder, Map<String, Object> params,
			Object object) throws ServiceException {
		try {
			return sysLogMapper.searchSysLog(page, sortColumn, sortOrder, params,null);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	@Override
	public <ModelType> List<ModelType> findByBiz(ModelType modelType,
			Map<String, Object> params) throws ServiceException {
		try {
			return sysLogMapper.selectByParams(modelType, params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	
	@Override
	public <ModelType> int add(ModelType modelType) throws ServiceException {
		try {
			validate(modelType);
			return sysLogMapper.insertSelective(modelType);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	
	@Override
	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField,
			String orderBy,Map<String,Object> params) throws ServiceException {
		try {
			return this.findByPage(page, orderByField, orderBy, params,null);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	
	@Override
	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy,
			Map<String, Object> params, AuthorityParams authorityParams) throws ServiceException {
		try {
			return sysLogMapper.selectByPage(page, orderByField, orderBy,params,authorityParams);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	@Override
	public int selectCount(Map<String, Object> params) throws ServiceException {
		try {
			return sysLogMapper.selectCount(params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	@Override
	public int selectCDCount(Map<String, Object> params) throws ServiceException {
		try {
			return sysLogMapper.selectCDCount(params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	@Override
	public int getCostTimeRate(Map<String,Object> params) throws ServiceException {
		try {
			return sysLogMapper.getCostTimeRate(params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	@Override
	public int getAVGTimeByReportId(Map<String,Object> params) throws ServiceException {
		try {
			return sysLogMapper.getAVGTimeByReportId(params);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
}