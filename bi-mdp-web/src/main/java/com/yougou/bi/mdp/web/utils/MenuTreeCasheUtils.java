package com.yougou.bi.mdp.web.utils;

import javax.servlet.http.HttpSession;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import cn.wonhigh.retail.uc.common.api.service.SSOApi;
import com.yougou.bi.mdp.common.constans.PublicConstans;
import com.yougou.bi.mdp.redis.util.RedisUtil;
import com.yougou.logistics.base.common.exception.RpcException;
import com.yougou.logistics.base.common.model.SystemUser;
import redis.clients.jedis.Jedis;

public class MenuTreeCasheUtils {

	protected static final XLogger logger = XLoggerFactory.getXLogger(MenuTreeCasheUtils.class);

	/**
	 * 获取缓存到redis的菜单信息
	 * @param session
	 * @param jedis
	 * @param systemId
	 * @return 菜单信息
	 */
	public static String getCasheMenuTree(SSOApi ssoApi, HttpSession session) {
		
		String casheKey = PublicConstans.AREA_SYSTEM_ID + "_MENU_TREE_CASHE_" + session.getId();
		SystemUser loginUser = (SystemUser) session.getAttribute(PublicConstans.SESSION_USER);
		String menuTree = "";
		Jedis jedis = null;
		
		//如果redis里已经存储菜单信息，直接从redis中取
		try {
			jedis = RedisUtil.getJedis();
			
			if (jedis.exists(casheKey)) {
				menuTree = jedis.get(casheKey);
			} else {
				//从dubbo接口获取BI系统菜单 
				menuTree = ssoApi.userMenuTree(loginUser.getUserid(), PublicConstans.AREA_SYSTEM_ID);
				//缓存到redis,有效期默认是2个小时
				jedis.set(casheKey, menuTree);
			}
		} catch (RpcException e) {
			logger.error(e.getMessage());
		} catch(Exception e){
			RedisUtil.returnBrokenResource(jedis);
			logger.error(e.getMessage());
		}finally{
			//用完jedis，释放资源
			RedisUtil.returnResource(jedis);
		}
		return menuTree;
	}

	/**
	 * 获取系统的菜单信息到redis中
	 * @param session
	 * @param jedis
	 * @param systemId
	 */
	public static void setCasheMenuTree(SSOApi ssoApi, HttpSession session) {
		
		String casheKey = PublicConstans.AREA_SYSTEM_ID + "_MENU_TREE_CASHE_" + session.getId();
		SystemUser loginUser = (SystemUser) session.getAttribute(PublicConstans.SESSION_USER);
		
		try {
			//从dubbo接口获取BI系统菜单 
			String menuTree = ssoApi.userMenuTree(loginUser.getUserid(), PublicConstans.AREA_SYSTEM_ID);
			//缓存到redis,有效期默认是2个小时
			RedisUtil.set(casheKey, menuTree);
		} catch (RpcException e) {
			logger.error("获取菜单出错，错误信息："+e.getMessage());
		}
	}
	
	/**
	 * 删除redis中缓存的菜单
	 * @param session
	 */
	public static void removeCasheMenuTree(String sessionId) {
		String casheKey = PublicConstans.AREA_SYSTEM_ID + "_MENU_TREE_CASHE_" + sessionId;
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			if(null != jedis && jedis.exists(casheKey)){
			    jedis.del(casheKey);
			}
		} catch (Exception e) {
			RedisUtil.returnBrokenResource(jedis);
			logger.error("删除redis缓存菜单出错，错误信息："+e.getMessage());
		}finally{
			RedisUtil.returnResource(jedis);
		}
	}
}
