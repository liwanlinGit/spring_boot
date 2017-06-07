package cn.desc.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.desc.www.entity.User;
import cn.desc.www.mapper.UserMapper;
import cn.desc.www.service.UserService;
import cn.desc.www.util.ExceptionUtil;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

		@Override
		public List<User> findUserList() {
			return mapper.findUserList();
		}

		@Override
		public void insertUser(User user) {
			mapper.insertUser(user);
			
		}

		@Override
		public void deleteUser(String id) {
			mapper.deleteUser(id);
			
		}

		@Override
		public void insertDelete(User user)   {
				mapper.insertUser(user);
				mapper.deleteUser(user.getId());
		}
    
    
    
}
