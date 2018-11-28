package com.yougou.bi.mdp.service;

import java.util.List;
import java.util.Map;
import com.yougou.bi.mdp.common.model.ReportsInfo;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.common.utils.SimplePage;
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
public interface ReportsInfoService extends BaseCrudService {

	public List<ReportsInfo> searchReports(SimplePage page, String sortColumn,
			String sortOrder, Map<String, Object> params, Object object)throws ServiceException;
	
	public List<ReportsInfo> selectByPage(SimplePage page, String sortColumn,
			String sortOrder, Map<String, Object> params, Object object)throws ServiceException;

	public void addReports(ReportsInfo reportsInfo)throws ServiceException;

	public ReportsInfo getReports(String str)throws ServiceException;

	public List<ReportsInfo> getCombobox(ReportsInfo reportsInfo,
			Map<String, Object> params)throws ServiceException;
	
	public  List<ReportsInfo> findByBizs( Map<String, Object> paramMap)
		    throws ServiceException;

	public void editReportsInfo(ReportsInfo reportsInfo)throws ServiceException;

	public void setCancelStatus(ReportsInfo reportsInfo)throws ServiceException;

	public void setRecoverStatus(ReportsInfo reportsInfo)throws ServiceException;

	public void synchronousMenu(List<Map<String, String>> kvList);
	
	public int selectCount();
}