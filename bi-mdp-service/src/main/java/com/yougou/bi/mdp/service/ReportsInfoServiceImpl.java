package com.yougou.bi.mdp.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yougou.bi.mdp.common.annotation.SwitchDataSource;
import com.yougou.bi.mdp.common.model.ReportsInfo;
import com.yougou.bi.mdp.dal.database.ReportsInfoMapper;
import com.yougou.logistics.base.common.exception.ServiceException;
import com.yougou.logistics.base.common.utils.SimplePage;
import com.yougou.logistics.base.dal.database.BaseCrudMapper;
import com.yougou.logistics.base.service.BaseCrudServiceImpl;

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
@Service("reportsInfoService")
@SwitchDataSource("oracleDataSourcePT")
class ReportsInfoServiceImpl extends BaseCrudServiceImpl implements ReportsInfoService {
    @Resource
    private ReportsInfoMapper reportsInfoMapper;

    @Override
    public BaseCrudMapper init() {
        return reportsInfoMapper;
    }

	@Override
	public List<ReportsInfo> searchReports(SimplePage page,
			String sortColumn, String sortOrder, Map<String, Object> params,
			Object object) throws ServiceException {
		try {
			return reportsInfoMapper.selectReports(page, sortColumn, sortOrder, params,null);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}
	
	@Override
	public List<ReportsInfo> selectByPage(SimplePage page,
			String sortColumn, String sortOrder, Map<String, Object> params,
			Object object) throws ServiceException {
		try {
			return reportsInfoMapper.selectByPage1(page, sortColumn, sortOrder, params,null);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
	}

	@Override
	public void addReports(ReportsInfo reportsInfo) throws ServiceException {
		try {
			reportsInfoMapper.updateByPrimaryKeySelective1(reportsInfo);
		} catch (Exception e) {
			throw new ServiceException("",e);
		}
		
	}

	@Override
	public ReportsInfo getReports(String str) throws ServiceException {
		// TODO Auto-generated method stub
		try{
			return reportsInfoMapper.getReports(str);
		} catch(Exception e){
			throw new ServiceException("",e);
		}
	}

	@Override
	public List<ReportsInfo> getCombobox(ReportsInfo reportsInfo,
			Map<String, Object> params) throws ServiceException{
		// TODO Auto-generated method stub
		try{
			return reportsInfoMapper.getCombobox(reportsInfo, params);
		} catch(Exception e){
			throw new ServiceException("",e);
		}
	}

	@Override
	public void editReportsInfo(ReportsInfo reportsInfo)
			throws ServiceException {
		try{
			reportsInfoMapper.updateByPrimaryKeySelective1(reportsInfo);
		} catch(Exception e){
			throw new ServiceException("",e);
		}
		
	}

	@Override
	public void setCancelStatus(ReportsInfo reportsInfo)
			throws ServiceException {
		try{
			reportsInfoMapper.updateByPrimaryKeySelective1(reportsInfo);
		} catch(Exception e){
			throw new ServiceException("",e);
		}
	}

	@Override
	public void setRecoverStatus(ReportsInfo reportsInfo)
			throws ServiceException {
		try{
			reportsInfoMapper.updateByPrimaryKeySelective1(reportsInfo);
		} catch(Exception e){
			throw new ServiceException("",e);
		}	
	}
	
	@Override
	public void synchronousMenu(List<Map<String, String>> kvList) {
		//写死去查多品库
		for(Map<String, String> map : kvList){
			int temp = 0;
			temp = reportsInfoMapper.synchronousMenuUpdata1(map);
			if(temp == 0 ){
				reportsInfoMapper.synchronousMenuInsert1(map);
			}
			reportsInfoMapper.synchronousMenuDelete1(map);
		}
	}
	@Override
	public int selectCount() {
			return reportsInfoMapper.selectCount();
	}

	@Override
	public List<ReportsInfo> findByBizs(Map<String, Object> params)
			throws ServiceException {
		try
	    {
	      return reportsInfoMapper.selectByParams1(params);
	    } catch (Exception e) {
	      throw new ServiceException(new StringBuilder().append("Problem invoking method, Cause:").append(e.getMessage()).toString(), e);
	    }
	}
	
}