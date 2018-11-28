package com.yougou.bi.mdp.web.syslog;

import java.util.HashMap;
import java.util.Map;
import com.yougou.bi.mdp.manager.DimOrgAllinfoManager;
import com.yougou.bi.mdp.web.controller.modelparse.transfer.SpringContextHolder;
import com.yougou.logistics.base.common.exception.ManagerException;
public class RegionParseForSystemLog {
	
    private DimOrgAllinfoManager dimOrgAllinfoManager;
    private String organNo;
	private String organName;
    private int    organLevel;
    
    public RegionParseForSystemLog() {
	}
	public RegionParseForSystemLog(String organNo, String organName, int organLevel) {
		super();
		this.organNo = organNo;
		this.organName = organName;
		this.organLevel = organLevel;
		dimOrgAllinfoManager=(DimOrgAllinfoManager) SpringContextHolder.getBean("dimOrgAllinfoManager");
	}
	public String getOrganNo() {
		return organNo;
	}
	public void setOrganNo(String organNo) {
		this.organNo = organNo;
	}
	public int getOrganLevel() {
		return organLevel;
	}
	public void setOrganLevel(int organLevel) {
		this.organLevel = organLevel;
	}
    public String getRegionForSystemLog() throws ManagerException{
    	String field=getOrganField(organLevel);
    	if(field==null){
//    		if(organLevel==2){
//    			return "本部";
//    		}
    		return organName;
    	}else{
    		Map<String,Object>params=new HashMap<String,Object>();
    		params.put(field, organNo);
    		return dimOrgAllinfoManager.selectRegionNameForLog(params);
    	}
    }
	private String getOrganField(int organLevel) {
		switch(organLevel){
			case 1:
				return null;
			case 2:
				return null;
			case 3:
				return null;
			case 4:
				return "managing_city_no";
			case 5:
				return "business_city_no";
			case 6:
				return "organ_no";
			default:
				return null;
		}
	}
}
