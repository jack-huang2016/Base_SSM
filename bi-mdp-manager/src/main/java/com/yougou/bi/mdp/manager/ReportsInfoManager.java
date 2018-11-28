package com.yougou.bi.mdp.manager;

import java.util.List;
import java.util.Map;
import com.yougou.bi.mdp.common.model.ReportsInfo;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.manager.BaseCrudManager;

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
public interface ReportsInfoManager extends BaseCrudManager {

	public List<ReportsInfo> searchReports(SimplePage page, String sortColumn,
			String sortOrder, Map<String, Object> params)throws ManagerException;
	
	
	public List<ReportsInfo> selectByPage(SimplePage page, String sortColumn,
			String sortOrder, Map<String, Object> params)throws ManagerException;


	public void addReports(ReportsInfo reportsInfo)throws ManagerException;
	
	public int selectCount()throws ManagerException;


	public ReportsInfo getReports(String str)throws ManagerException;


	public List<ReportsInfo> getCombobox(ReportsInfo reportsInfo,
			Map<String, Object> params)throws ManagerException;
	
	 public  List<ReportsInfo> findByBizs( Map<String, Object> paramMap)
			    throws ManagerException;


	public void editReportsInfo(ReportsInfo reportsInfo)throws ManagerException;

	public void setCancelStatus(ReportsInfo reportsInfo)throws ManagerException;


	public void setRecoverStatus(ReportsInfo reportsInfo)throws ManagerException;


	public void synchronousMenu(List<Map<String, String>> kvList);
}