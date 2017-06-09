package cn.desc.www.web;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.desc.www.entity.User;
import cn.desc.www.service.UserService;


@RestController
@RequestMapping("/login")
public class LoginUserController {
  @Autowired
  private UserService userService;
  @RequestMapping("/login")
  public String login(String userNo,String password){
    String userNoMsg="";
    String userPwdMsg="";
    String errorMsg="";
    String flg="no";
    if(userNo!=null&&!"".equals(userNo.trim())){
       if(password!=null&&!"".equals(password)){
         User user = userService.findUserByUserNo(userNo);
         if(user!=null){
            if(user.getUserPwd().equals(password)){
              user.setLastLoginTime(new Date());
              user.setPwdErrorCount(0);
              userService.updateUser(user);
              flg="ok";
            }else{
              Integer pwdErrorCount = user.getPwdErrorCount();
              if (pwdErrorCount == null) {
                pwdErrorCount = 0;
               }
               user.setPwdErrorCount(pwdErrorCount + 1);
               user.setPwdErrorTime(new Date());
              if(user.getPwdErrorCount()>=5){
                userPwdMsg="<br/><br/>密码已连续输错【5次】，帐号已被冻结";
              }else{
                userPwdMsg="<br/><br/>密码错误，再输错【" + (5 - user.getPwdErrorCount()) + "】次将冻结帐号";
              }
              userService.updateUser(user);
            }
         }else{
           userNoMsg="没有此用户名";
         }
       }else{
         userPwdMsg="密码不能为空";
       }
    }else{
      userNoMsg="用户名不能为空";
    }
    return "{\"flg\":\""+flg+"\",\"userNoMsg\":\""+userNoMsg+"\",\"userPwdMsg\":\""+userPwdMsg+"\",\"errorMsg\":\""+errorMsg+"\"}";
  }
}
