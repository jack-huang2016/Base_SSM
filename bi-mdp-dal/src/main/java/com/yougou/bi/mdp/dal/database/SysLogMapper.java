package com.yougou.bi.mdp.dal.database;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yougou.bi.mdp.common.model.SysLog;
import com.yougou.logistics.base.common.exception.DaoException;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.model.AuthorityParams;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.dal.database.BaseCrudMapper;

/**
 * 请写出类的用途 
 * @author Administrator
 * @date  2014-11-11 16:41:37
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
public interface SysLogMapper extends BaseCrudMapper {

	public List<SysLog> searchSysLog(@Param("page") SimplePage page,@Param("orderByField") String orderByField,@Param("orderBy") String orderBy,@Param("params")Map<String,Object> params,@Param("authorityParams") AuthorityParams authorityParams)
			throws ManagerException;
	
	public int selectCount(@Param("params")Map<String,Object> params)
			throws ManagerException;
	
	/**
	 * @Title: getCostTimeRate
	 * @Description: 获取过去一周(包括今天)某个主题的平均执行计划和平均实际查询用时候的比
	 * @param subjectName 模板主题名
	 * @throws DaoException  异常情况说明
	*/
	public int getCostTimeRate(@Param("params")Map<String,Object> params)
			throws DaoException;
	/**
	 * @Title: getAVGTimeByReportId
	 * @Description: 获取当天改模板的平均用时
	 * @param reportId 模板编号
	 * @throws DaoException  异常情况说明
	*/
	public int getAVGTimeByReportId(@Param("params")Map<String,Object> params)
			throws DaoException;
	
	public int selectCDCount(@Param("params")Map<String,Object> params)
			throws ManagerException;
}