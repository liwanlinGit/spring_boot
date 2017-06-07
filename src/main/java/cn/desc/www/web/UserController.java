package cn.desc.www.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.desc.www.entity.User;
import cn.desc.www.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private UserService userService;
  @RequestMapping("/user")
  public String user(){
 	List<User> findUserList = userService.findUserList();
 	 return findUserList.get(0).getName();
  }
  @RequestMapping("/userAll")
  public String userAll(){
  	User user=new User();
 	  user.setId("1313123");
 	  user.setName("王二麻子");
 	 List<User> findUserList1 = userService.findUserList();
 	  userService.insertUser(user);
 	 List<User> findUserList = userService.findUserList();
 	 return findUserList.get(0).getName();
  }
  @RequestMapping("/addUser")
  public String addUser(){
 	  User user=new User();
 	  user.setId("1111");
 	  user.setName("李四");
 	  userService.insertUser(user);
 	  return "ok";
  }
  @RequestMapping("/deleteUser")
  public String deleteUser(){
 	  userService.deleteUser("1");
 	  return "ok";
  }
  @RequestMapping("/id")
  public String id(){
  	User user=new User();
 	  user.setId("2");
 	  user.setName("张三");
	  userService.insertDelete(user);
 	  return "ok";
  }
}
