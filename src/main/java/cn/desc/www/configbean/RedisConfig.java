package cn.desc.www.configbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import cn.desc.www.util.rediscache.RedisCacheTransfer;
import redis.clients.jedis.JedisPoolConfig;
@Configuration
@EnableRedisHttpSession   //session共享
@ConfigurationProperties(prefix="spring.redis")
public class RedisConfig {
  private String host;
  private String password;
  private Integer port;
  private Integer maxIdle;
  private Integer maxActive;
  private Integer maxWait;
  private Boolean testOnBorrow;
  
  //redis的redis.clients.jedis.JedisPoolConfig配置
  @Bean
  public JedisPoolConfig poolConfig(){
    JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
    jedisPoolConfig.setMaxIdle(getMaxIdle());
    jedisPoolConfig.setMaxTotal(getMaxActive());
    jedisPoolConfig.setMaxWaitMillis(getMaxWait());
    jedisPoolConfig.setTestOnBorrow(getTestOnBorrow());
    return jedisPoolConfig;
  }
  //redis的org.springframework.data.redis.connection.jedis.JedisConnectionFactory配置
  //如果需要有session 共享 此类就是共享session核心 
  @Bean
  public JedisConnectionFactory jedisConnectionFactory(){
    JedisConnectionFactory connectionFactory=new  JedisConnectionFactory();
    connectionFactory.setHostName(getHost());
    connectionFactory.setPort(getPort());
    connectionFactory.setPoolConfig(poolConfig());
    return new JedisConnectionFactory();
  }
  //注入RedisCacheTransfer类cn.desc.www.util.RedisCacheTransfer
  @Bean
  public RedisCacheTransfer redisCacheTransfer(){
    RedisCacheTransfer cacheTransfer=new RedisCacheTransfer();
    cacheTransfer.setJedisConnectionFactory(jedisConnectionFactory());
    return cacheTransfer;
  }
  public String getHost() {
    return host;
  }
  public void setHost(String host) {
    this.host = host;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Integer getPort() {
    return port;
  }
  public void setPort(Integer port) {
    this.port = port;
  }
  public Integer getMaxIdle() {
    return maxIdle;
  }
  public void setMaxIdle(Integer maxIdle) {
    this.maxIdle = maxIdle;
  }
  public Integer getMaxActive() {
    return maxActive;
  }
  public void setMaxActive(Integer maxActive) {
    this.maxActive = maxActive;
  }
  public Integer getMaxWait() {
    return maxWait;
  }
  public void setMaxWait(Integer maxWait) {
    this.maxWait = maxWait;
  }
  public Boolean getTestOnBorrow() {
    return testOnBorrow;
  }
  public void setTestOnBorrow(Boolean testOnBorrow) {
    this.testOnBorrow = testOnBorrow;
  }
  
  
}
