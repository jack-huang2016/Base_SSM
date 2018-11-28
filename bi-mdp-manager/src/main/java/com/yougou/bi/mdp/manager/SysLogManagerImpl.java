package com.yougou.bi.mdp.manager;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yougou.bi.mdp.common.model.SysLog;
import com.yougou.bi.mdp.service.SysLogService;
import com.yougou.logistics.base.common.enums.DataAccessRuleEnum;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.common.model.AuthorityParams;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.manager.BaseCrudManagerImpl;
import com.yougou.logistics.base.service.BaseCrudService;

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
@Service("sysLogManager")
class SysLogManagerImpl extends BaseCrudManagerImpl implements SysLogManager {
    @Resource
    private SysLogService sysLogService;

    @Override
    public BaseCrudService init() {
        return sysLogService;
    }

	@Override
	public List<SysLog> searchSysLog(SimplePage page,
			String sortColumn, String sortOrder, Map<String, Object> params)
			throws ManagerException {
		try {
			return sysLogService.searchSysLog(page, sortColumn, sortOrder, params,null);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}	
	}
	

	@Override
	public <ModelType> ModelType findById(ModelType modelType) throws ManagerException {
		try {
			return sysLogService.findById(modelType);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public <ModelType> int add(ModelType modelType) throws ManagerException {
		try {
			return sysLogService.add(modelType);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy, Map<String, Object> params)
			throws ManagerException {
		try {
			return this.findByPage(page, orderByField, orderBy, params,null);
		} catch (ManagerException e) {
			throw e;
		}
	}
	
	@Override
	public <ModelType> List<ModelType> findByPage(SimplePage page, String orderByField, String orderBy,
			Map<String, Object> params, AuthorityParams authorityParams, DataAccessRuleEnum... dataAccessRuleEnums)
			throws ManagerException {
		try {
			return sysLogService.findByPage(page, orderByField, orderBy, params, authorityParams, dataAccessRuleEnums);
		} catch (ServiceException e) {
			throw new ManagerException(e);
		}
	}

	@Override
	public int selectCount(Map<String, Object> params) throws ManagerException {
		try {
			return sysLogService.selectCount(params);
		} catch (ServiceException e) {
			throw new ManagerException(e);
		}
	}
	
	@Override
	public int getCostTimeRate(Map<String,Object> params) throws ManagerException {
		try {
			return sysLogService.getCostTimeRate(params);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public int getAVGTimeByReportId(Map<String,Object> params) throws ManagerException {
		try {
			return sysLogService.getAVGTimeByReportId(params);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}
	
	@Override
	public int selectCDCount(Map<String, Object> params) throws ManagerException {
		try {
			return sysLogService.selectCDCount(params);
		} catch (ServiceException e) {
			throw new ManagerException(e);
		}
	}
}