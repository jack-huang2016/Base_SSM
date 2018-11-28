package com.yougou.bi.mdp.service;

import java.util.List;
import java.util.Map;
import com.yougou.bi.mdp.common.model.SysLog;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.common.model.AuthorityParams;
import com.yougou.logistics.base.common.utils.SimplePage;
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
public interface SysLogService extends BaseCrudService {
	
	public int getCostTimeRate(Map<String,Object> params) throws ServiceException;
	public int getAVGTimeByReportId(Map<String,Object> params) throws ServiceException;

	public List<SysLog> searchSysLog(SimplePage page, String sortColumn,
			String sortOrder, Map<String, Object> params, Object object) throws ServiceException;
	
	public <ModelType> List<ModelType> findByBiz(ModelType modelType,Map<String,Object> params)throws ServiceException;
	
	public  int selectCount(Map<String,Object> params) throws ServiceException;
	
	/**
	 * 按照查询条件取总条数
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public  int selectCDCount(Map<String,Object> params) throws ServiceException;
	
	public <ModelType> int add(ModelType modelType) throws ServiceException;
	
	public <ModelType> List<ModelType> findByPage(SimplePage page,String orderByField,String orderBy,Map<String,Object> params,AuthorityParams authorityParams)throws ServiceException;
}