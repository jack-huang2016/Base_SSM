package com.yougou.bi.mdp.web.security;

import com.yougou.logistics.base.common.model.SystemUser;

public class Authorization {
	
	private SystemUser user;
	
	private static ThreadLocal<Authorization> context = new ThreadLocal<Authorization>(){
        protected synchronized Authorization initialValue() {
            return new Authorization();
        }
    };
    
	private Authorization()
	{
		
	}
	
    public static Authorization get(){
    	return context.get();
    }
    
    public SystemUser getUser(){
    	return user;
    }
    
    public void setUser(SystemUser val){ user = val;}
}
