package com.yougou.bi.mdp.dal.database;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yougou.bi.mdp.common.model.ReportsInfo;
import com.yougou.logistics.base.common.exception.ManagerException;
import com.yougou.logistics.base.common.model.AuthorityParams;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.dal.database.BaseCrudMapper;

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
public interface ReportsInfoMapper extends BaseCrudMapper {

	public List<ReportsInfo> selectReports(@Param("page") SimplePage page,@Param("orderByField") String orderByField,@Param("orderBy") String orderBy,@Param("params")Map<String,Object> params,@Param("authorityParams") AuthorityParams authorityParams
			)throws ManagerException;
	
	public List<ReportsInfo> selectByPage1(@Param("page") SimplePage page,@Param("orderByField") String orderByField,@Param("orderBy") String orderBy,@Param("params")Map<String,Object> params,@Param("authorityParams") AuthorityParams authorityParams
			)throws ManagerException;

	public ReportsInfo getReports(@Param("str")String str);

	public List<ReportsInfo> getCombobox(@Param("model")ReportsInfo reportsInfo,
			@Param("params") Map<String, Object> params);
	
	public List<ReportsInfo> selectByParams1(@Param("params") Map<String, Object> paramMap);

	public void updateByPrimaryKeySelective1(ReportsInfo reportsInfo);
	
	public int synchronousMenuUpdata1(Map<String, String> map);
	public int synchronousMenuInsert1(Map<String, String> map);
	public int synchronousMenuDelete1(Map<String, String> map);
	public int selectCount();
}