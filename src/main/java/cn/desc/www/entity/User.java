package cn.desc.www.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
  private String id;
  private Integer version;
  private Date createTime;
  private String userNo;// 用户帐号(当用户类型为“子帐号”时使用，否则为空)
  private String mainUserId;// 主账号ID
  private String userPwd; // 登录密码
  private String userName; // 姓名
  private String mobileNo; // 手机号
  private String email;// 邮箱
  private Integer status; // 状态(100:可用，101:不可用 )
  private String userType; // 用户类型（1:超级管理员，0:普通用户），超级管理员由系统初始化时添加，不能删除
  private Date lastLoginTime;// 最后登录时间
  private Boolean isChangedPwd;// 是否更改过密码
  private Integer pwdErrorCount; // 连续输错密码次数（连续5次输错就冻结帐号）
  private Date pwdErrorTime; // 最后输错密码的时间
  private String remark; // 描述
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Integer getVersion() {
    return version;
  }
  public void setVersion(Integer version) {
    this.version = version;
  }
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
  public String getUserNo() {
    return userNo;
  }
  public void setUserNo(String userNo) {
    this.userNo = userNo;
  }
  public String getMainUserId() {
    return mainUserId;
  }
  public void setMainUserId(String mainUserId) {
    this.mainUserId = mainUserId;
  }
  public String getUserPwd() {
    return userPwd;
  }
  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getMobileNo() {
    return mobileNo;
  }
  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }
  public String getUserType() {
    return userType;
  }
  public void setUserType(String userType) {
    this.userType = userType;
  }
  public Date getLastLoginTime() {
    return lastLoginTime;
  }
  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }
  public Boolean getIsChangedPwd() {
    return isChangedPwd;
  }
  public void setIsChangedPwd(Boolean isChangedPwd) {
    this.isChangedPwd = isChangedPwd;
  }
  public Integer getPwdErrorCount() {
    return pwdErrorCount;
  }
  public void setPwdErrorCount(Integer pwdErrorCount) {
    this.pwdErrorCount = pwdErrorCount;
  }
  public Date getPwdErrorTime() {
    return pwdErrorTime;
  }
  public void setPwdErrorTime(Date pwdErrorTime) {
    this.pwdErrorTime = pwdErrorTime;
  }
  public String getRemark() {
    return remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
   
}
