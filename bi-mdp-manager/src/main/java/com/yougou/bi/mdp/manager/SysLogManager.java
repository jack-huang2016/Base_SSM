package com.yougou.bi.mdp.manager;

import java.util.List;
import java.util.Map;
import com.yougou.bi.mdp.common.model.SysLog;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.manager.BaseCrudManager;

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
public interface SysLogManager extends BaseCrudManager {

	public  int selectCount(Map<String,Object> params) throws ManagerException;
	
	/**
	 * 按照查询条件取总条数
	 * @param params
	 * @return
	 * @throws ManagerException
	 */
	public  int selectCDCount(Map<String,Object> params) throws ManagerException;
	
	public List<SysLog> searchSysLog(SimplePage page, String sortColumn,
			String sortOrder, Map<String, Object> params) throws ManagerException;
	
	public <ModelType> List<ModelType> findByBiz(ModelType modelType,Map<String,Object> params)throws ManagerException;
	
	public <ModelType> int add(ModelType modelType) throws ManagerException;
	
	public <ModelType> List<ModelType> findByPage(SimplePage page,String orderByField,String orderBy,Map<String,Object> params)throws ManagerException;

	int getCostTimeRate(Map<String, Object> params) throws ManagerException;
	int getAVGTimeByReportId(Map<String, Object> params) throws ManagerException;
}