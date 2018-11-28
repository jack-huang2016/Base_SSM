package com.yougou.bi.mdp.redis.util;

import java.util.Set;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import com.yougou.bi.mdp.web.controller.modelparse.transfer.SpringContextHolder;

/**
 * Redis 工具类
 * 
 * @author li.l
 */
public class RedisUtil {

	protected static Logger logger = Logger.getLogger(RedisUtil.class);
	private static JedisPool jedisPool = null;

	/**
	 * 初始化Redis连接池
	 */
	private static void initialPool() {
		jedisPool=(JedisPool) SpringContextHolder.getBean("jedisPool");
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (jedisPool == null) {
			initialPool();
		}
	}

	/**
	 * 同步获取Jedis实例
	 * 
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		if (jedisPool == null) {
			poolInit();
		}
		Jedis jedis = null;
		try {
			if (jedisPool != null) {
				jedis = jedisPool.getResource();
			}
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			logger.error("Get jedis error : " + e);
		}
		return jedis;
	}

	/**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null && jedisPool != null) {
			jedisPool.returnResource(jedis);
		}
	}

	public static void returnBrokenResource(final Jedis jedis) {
		if (jedis != null && jedisPool != null) {
			jedisPool.returnBrokenResource(jedis);
		}
	}
	
	/**
	 * 设置 String
	 * 
	 * @param key
	 * @param value
	 */
	public static void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			logger.error("Set key error : " + e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 设置 过期时间
	 * 
	 * @param key
	 * @param seconds
	 *            以秒为单位
	 * @param value
	 */
	public static void set(String key, int seconds, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			logger.error("Set keyex error : " + e);
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return value
	 */
	public static String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getJedis();
			if (jedis == null || !jedis.exists(key)) {
				return null;
			}
			value = jedis.get(key);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			logger.error("get keyex error : " + e);
		} finally {
			returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * 清除redis缓存
	 */
	public static void flushdb() {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			Set<String> keys = jedis.keys("*");
			if (keys != null && !keys.isEmpty()) {
				logger.debug("Performing cleanup redis cache,key size:"
						+ keys.size());
				jedis.flushDB();
			}
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			logger.error("flushdb error : " + e);
		} finally {
			returnResource(jedis);
		}
	}

}
