package com.yougou.bi.mdp.dal.jdbcconn;

public class DataSourceSwitch{  
    @SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder=new ThreadLocal();  
      
    @SuppressWarnings("unchecked")
	public static void setDataSourceType(String dataSourceType){  
        contextHolder.set(dataSourceType);  
    }  
      
    public static String getDataSourceType(){  
        return (String) contextHolder.get();  
    }  
      
    public static void clearDataSourceType(){  
        contextHolder.remove();  
    }  
}  
