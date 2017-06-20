package cn.desc.www.util.rediscache.usercache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Repository;

import cn.desc.www.util.serialize.SerializeUtil;

@Repository
public class CacheUser {
  @Autowired  //临时调用redis
  private JedisConnectionFactory jedisConnectionFactory;
  
  public  void setUser(String requestId,Object obj){
    RedisConnection connection = jedisConnectionFactory.getConnection();
    connection.set(SerializeUtil.serialize(requestId), SerializeUtil.serialize(obj));
  }
  public  Object getUser(String requestId){
    RedisConnection connection = jedisConnectionFactory.getConnection();
    byte[] bs = connection.get(SerializeUtil.serialize(requestId));
    Object obj = SerializeUtil.unserialize(bs);
    return obj;
  }
}
