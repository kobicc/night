package com.kobicc.kbsp.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobicc.kbsp.beans.User;
import com.kobicc.kbsp.dao.UserDao;
import com.kobicc.kbsp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public int add(User user) {
		
//		String sql = "create table t_user(userID int primary key auto_increment, userName varchar(20), password varchar(32))";
		
		return userDao.add(user);
	}

	@Override
	public String del(User user) {
		String uuid = UUID.randomUUID().toString();
		System.out.println("del uuid=" + uuid);
		return uuid;
	}

	@Override
	public String edit(User user) {
		String uuid = UUID.randomUUID().toString();
		System.out.println("edit uuid=" + uuid);
		return uuid;
	}

	@Override
	public String find(User user) {
		String uuid = UUID.randomUUID().toString();
		System.out.println("find uuid=" + uuid);
		return uuid;
	}

	@Override
	public User findUserByID(int id) {
		return userDao.findUserByID(id);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
