package cn.desc.www.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.desc.www.entity.User;
import cn.desc.www.util.json.JsonObjectUtil;
import cn.desc.www.util.rediscache.usercache.CacheUser;

@RestController
@RequestMapping("/index")
public class IndexController {
  @Autowired
  private CacheUser cacheUser;
  @RequestMapping("/getUser")
  public String getUser(HttpServletRequest request) throws Exception{
    
    System.out.println(request.getSession().getId()+"-=-=-"+"demo1");
    User user =(User) request.getSession().getAttribute("user");
    System.out.println(user);
    //redis 取数据
    //User user = (User) cacheUser.getUser(request.getSession().getId());
    return JsonObjectUtil.objectToJsonStr(user);
  }
}
