package com.yougou.bi.mdp.manager;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yougou.bi.mdp.common.model.ReportsInfo;
import com.yougou.bi.mdp.service.ReportsInfoService;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.manager.BaseCrudManagerImpl;
import com.yougou.logistics.base.service.BaseCrudService;

/**
 * 请写出类的用途 
 * @author Administrator
 * @date  2014-10-28 14:21:27
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
@Service("reportsInfoManager")
class ReportsInfoManagerImpl extends BaseCrudManagerImpl implements ReportsInfoManager {
    @Resource
    private ReportsInfoService reportsInfoService;

    @Override
    public BaseCrudService init() {
        return reportsInfoService;
    }

	@Override
	public List<ReportsInfo> searchReports(SimplePage page,
			String sortColumn, String sortOrder, Map<String, Object> params)
			throws ManagerException {
		try {
			return reportsInfoService.searchReports(page, sortColumn, sortOrder, params,null);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}	
	}
	
	@Override
	public List<ReportsInfo> selectByPage(SimplePage page,
			String sortColumn, String sortOrder, Map<String, Object> params)
					throws ManagerException {
		try {
			return reportsInfoService.selectByPage(page, sortColumn, sortOrder, params,null);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}	
	}

	@Override
	public void addReports(ReportsInfo reportsInfo) throws ManagerException {
		try {
			reportsInfoService.addReports(reportsInfo);
	} catch (ServiceException e) {
		throw new ManagerException(e.getMessage(), e);
	}
	}

	@Override
	public ReportsInfo getReports(String str) throws ManagerException {
		// TODO Auto-generated method stub
		try{
			return reportsInfoService.getReports(str);
		}catch(ServiceException e){
			throw new ManagerException(e.getMessage(),e);
		}
	}

	@Override
	public List<ReportsInfo> getCombobox(ReportsInfo reportsInfo,
			Map<String, Object> params) throws ManagerException {
		try {
			return reportsInfoService.getCombobox(reportsInfo, params);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<ReportsInfo> findByBizs(Map<String, Object> params) throws ManagerException
	  {
	    try
	    {
	      return reportsInfoService.findByBizs(params);
	    } catch (ServiceException e) {
	      throw new ManagerException(e.getMessage(), e);
	    }
	  }
	
	@Override
	public void editReportsInfo(ReportsInfo reportsInfo)
			throws ManagerException {
		try {
			reportsInfoService.editReportsInfo(reportsInfo);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
		
	}

	@Override
	public void setCancelStatus(ReportsInfo reportsInfo)
			throws ManagerException {
		try {
			reportsInfoService.setCancelStatus(reportsInfo);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
		
	}

	@Override
	public void setRecoverStatus(ReportsInfo reportsInfo)
			throws ManagerException {
		try {
			reportsInfoService.setRecoverStatus(reportsInfo);
		} catch (ServiceException e) {
			throw new ManagerException(e.getMessage(), e);
		}
		
	}
	
	@Override
	public void synchronousMenu(List<Map<String, String>> kvList) {
		reportsInfoService.synchronousMenu(kvList);
	}

	@Override
	public int selectCount() throws ManagerException {
		return reportsInfoService.selectCount();
	}
}