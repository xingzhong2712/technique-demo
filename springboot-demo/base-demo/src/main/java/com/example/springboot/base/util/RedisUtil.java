package com.example.springboot.base.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 类职责：redis工具类<br/>
 *
 * <p>Title: RedisUtil.java</p>
 * <p>Description: redis工具类</p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月29日 下午 3:36
 * <p>Seen</p>
 * <p>V1.0 </p>
 *
 * @author Administrator
 */
@Slf4j
@Component
public class RedisUtil {
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 指定缓存失效时间
	 *
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, long time) {
		try {
			if (time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			
			return true;
		} catch (Exception e) {
			log.error("调用redis失败：{}", e.getMessage());
			return false;
		}
	}
	
	/**
	 * 根据key获取过期时间
	 *
	 * @param key
	 * @return 时间（s），返回0代表永久有效
	 */
	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}
	
	/**
	 * 判断key是否存在
	 *
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			log.error("调用redis失败：{}", e.getMessage());
			return false;
		}
	}
	
	/**
	 * 删除缓存
	 *
	 * @param keys
	 */
	public void delete(String... keys) {
		if (!ObjectUtils.isEmpty(keys)) {
			if (keys.length == 1) {
				redisTemplate.delete(keys[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(keys));
			}
		}
	}
	
	/**
	 * 普通缓存获取
	 *
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return StringUtils.isEmpty(key) ? null : redisTemplate.opsForValue().get(key);
	}
	
	/**
	 * 普通缓存存入
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key, Object value) {
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			log.error("调用redis失败：{}", e.getMessage());
			return false;
		}
	}
	
	/**
	 * 普通缓存存入并设置过期时间
	 *
	 * @param key
	 * @param value
	 * @param time
	 * @return
	 */
	public boolean set(String key, Object value, long time) {
		try {
			if (time > 0) {
				redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			} else {
				set(key, value);
			}
			return true;
		} catch (Exception e) {
			log.error("调用redis失败：{}", e.getMessage());
			return false;
		}
	}
	
	/**
	 * 递增
	 *
	 * @param key
	 * @param delta 递增因子
	 * @return
	 */
	public long incr(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递增因子必须大于0！");
		}
		
		return redisTemplate.opsForValue().increment(key, delta);
	}
	
	/**
	 * 递减
	 *
	 * @param key
	 * @param delta 递减因子
	 * @return
	 */
	public long decr(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递减因子必须大于0！");
		}
		
		return redisTemplate.opsForValue().increment(key, -delta);
	}
	
	/**
	 * HashGet
	 *
	 * @param key
	 * @param item
	 * @return
	 */
	public Object hget(String key, String item) {
		return redisTemplate.opsForHash().get(key, item);
	}
	
	/**
	 * 获取hashKey对应的所有键值
	 *
	 * @param key
	 * @return
	 */
	public Map<Object, Object> hmget(String key) {
		return redisTemplate.opsForHash().entries(key);
	}
	
	/**
	 * HashSet
	 *
	 * @param key
	 * @param map
	 * @return
	 */
	public boolean hmget(String key, Map<Object, Object> map) {
		try {
			redisTemplate.opsForHash().putAll(key, map);
			return true;
		} catch (Exception e) {
			log.error("调用redis失败：{}", e.getMessage());
			return false;
		}
	}
	
	
}
