package com.example.springboot.base.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * 类职责：<br/>
 *
 * <p>Title: RedisConfigV2.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月29日 下午 4:23
 * <p></p>
 * <p> </p>
 */
@Slf4j
@EnableCaching
@Configuration
public class RedisConfigV2 extends CachingConfigurerSupport {
	
	@Resource
	private JedisConnectionFactory jedisConnectionFactory;
	
	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return ((target, method, params) -> {
			StringBuilder string = new StringBuilder();
			string.append(target.getClass().getName());
			string.append(":");
			string.append(method.getName());
			
			for (Object o : params) {
				string.append(":" + o);
			}
			String rsToUse = String.valueOf(string);
			log.info("自动生成Redis Key->[{}]", rsToUse);
			return rsToUse;
		});
	}
	
	@Bean
	@Override
	public CacheManager cacheManager() {
		log.info("初始化->[{}]", "CacheManager RedisCacheManager Start.");
		return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(jedisConnectionFactory).build();
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory jedisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory);
		Jackson2JsonRedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jsonRedisSerializer.setObjectMapper(om);
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		// key采用String的序列化方式
		template.setKeySerializer(stringRedisSerializer);
		// hash的key采用String的序列化方式
		template.setHashKeySerializer(stringRedisSerializer);
		// value序列化方式采用Jackson
		template.setValueSerializer(jsonRedisSerializer);
		// hash的key采用Jackson的序列化方式
		template.setHashValueSerializer(stringRedisSerializer);
		template.afterPropertiesSet();
		
		return template;
	}
	
	
	@Override
	public CacheErrorHandler errorHandler() {
		log.info("初始化-[{}]", "Redis CacheErrorHandler.");
		return new CacheErrorHandler() {
			@Override
			public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
				log.error("Redis occur handleCacheGetError: key ->[{}]", key, exception);
			}
			
			@Override
			public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
				log.error("Redis occur handleCachePutError: key ->[{}]", key, exception);
			}
			
			@Override
			public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
				log.error("Redis occur handleCacheEvictError: key ->[{}]", key, exception);
			}
			
			@Override
			public void handleCacheClearError(RuntimeException exception, Cache cache) {
				log.error("Redis occur handleCacheClearError: ", exception);
			}
		};
	}
	
	@Data
//	@Configuration
	@ConfigurationProperties("spring.redis")
	class DataJedisProperties {
		//		@Value("${spring.redis.host}")
		private String host;
		//		@Value("${spring.redis.password}")
		private String password;
		//		@Value("${spring.redis.port}")
		private int port;
		//		@Value("${spring.redis.timeout}")
		private int timeout;
		//		@Value("${spring.redis.database}")
		private int database;
		//		@Value("${spring.redis.jedis.pool.max-idle}")
		private int maxIdle;
		//		@Value("${spring.redis.jedis.pool.max-wait}")
		private long maxWaitMillis;
		
		@Bean
		JedisConnectionFactory jedisConnectionFactory() {
			log.info("Create JedisConnectionFactory successful");
			RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
			configuration.setHostName(host);
			configuration.setPort(port);
			configuration.setDatabase(database);
			configuration.setPassword(RedisPassword.of(password));
			
			return new JedisConnectionFactory(configuration);
		}
		
		@Bean
		public JedisPool redisPoolFactory() {
			log.info("JedisPool init ，host -> [{}],port -> [{}]", host, port);
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(maxIdle);
			jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
			
			JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
			return jedisPool;
		}
	}
}
