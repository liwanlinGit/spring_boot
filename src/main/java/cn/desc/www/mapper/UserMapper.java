package cn.desc.www.mapper;

import java.util.List;

import cn.desc.www.entity.User;

public interface UserMapper {
  public User findUserByUserNo(String userNo);
  public void updateUser(User user);
  public List<User> findUserList();
  public void insertUser(User user);
  public void deleteUser(String id);
}
