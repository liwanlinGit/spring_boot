package cn.desc.www.mapper;

import java.util.List;

import cn.desc.www.entity.User;

public interface UserMapper {
  public List<User> findUserList();
  public void insertUser(User user);
  public void deleteUser(String id);
}
