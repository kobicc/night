package com.kobicc.kbsp.dao;

import java.util.List;

import com.kobicc.kbsp.beans.User;

public interface UserDao {

	public int add(User user);
	
	public String del(User user);
	
	public String edit(User user);
	
	public String find(User user);
	
	public User findUserByID(int id);
	
    public List<User> findAllUser();
}
