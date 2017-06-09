package cn.desc.www.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.desc.www.configbean.RedisConfig;
import cn.desc.www.entity.User;
import cn.desc.www.util.JsonObjectUtil;
import cn.desc.www.util.SerializeUtil;

@RestController
@RequestMapping("/index")
public class IndexController {
  @Autowired
  private JedisConnectionFactory jedisConnectionFactory;
  @RequestMapping("/getUser")
  public String getUser(HttpServletRequest request) throws Exception{
    RedisConnection connection = jedisConnectionFactory.getConnection();
    byte[] bs = connection.get("user".getBytes());
    User user = (User)SerializeUtil.unserialize(bs);
    return JsonObjectUtil.objectToJsonStr(user);
  }
}
