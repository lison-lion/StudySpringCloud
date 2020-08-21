package com.study.redis;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
		private static JedisPool jp = null;
		private static String host = null;
		private static int port;
		private static int maxTotal;
		private static int maxIdle;
		
		static {
			ResourceBundle rb = ResourceBundle.getBundle("redis");
			host = rb.getString("redis.host");
			port = Integer.parseInt(rb.getString("redis.port"));
			maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
			maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
			
			JedisPoolConfig jpc = new JedisPoolConfig();
			jpc.setMaxTotal(maxTotal);
			jpc.setMaxIdle(maxIdle);
			 jp = new JedisPool(jpc, host, port);
		}
		
		public static Jedis getJedis() {
			return jp.getResource();
		}
}
