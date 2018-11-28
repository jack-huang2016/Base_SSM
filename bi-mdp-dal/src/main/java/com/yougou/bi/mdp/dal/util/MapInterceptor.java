package com.yougou.bi.mdp.dal.util;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })    
public class MapInterceptor implements Interceptor{

	@SuppressWarnings("unchecked")
	public Object intercept(Invocation invocation) throws Throwable {
		//获取结果集
		Object result = invocation.proceed();
		//如果是MAP一定封装在list里面
		if(result instanceof List){
			List<Map<Object,Object>> newResult = new ArrayList<Map<Object,Object>>();
			List<Object> list = (List<Object>) result;
			Map<Object,Object> tempMap = null;
			for(Object data : list){
				if(data instanceof Map<?,?>){
					tempMap = new HashMap<Object,Object>();
					Map<String,Object> m = (Map<String, Object>)data;
					Iterator<String> iterator = m.keySet().iterator(); 
					while (iterator.hasNext()) {  
						String key = iterator.next();
						tempMap.put(key.toUpperCase(), m.get(key));
					}
					newResult.add(tempMap);
				}else{
					return result;
				}
			}
			return newResult;
		}else{
			return result;
		}
	}
	
	public Object plugin(Object obj) {  
        return Plugin.wrap(obj,this);  
    }  
	
	public void setProperties(Properties props) {  
        
    }  
}
