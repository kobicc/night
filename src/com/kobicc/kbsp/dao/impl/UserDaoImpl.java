package com.kobicc.kbsp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kobicc.kbsp.beans.User;
import com.kobicc.kbsp.dao.UserDao;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private int execute(String sql, Object[] obj){
		return jdbcTemplate.update(sql, obj);
	}
	 
	@Override
	public int add(User user) {
		String sql = "insert into t_user(userID,userName,password)values(?,?,?)";
		
		Object[] obj = new Object[]{
                user.getUserID(),
                user.getUserName(),
                user.getPassword()
        };
		
		return this.execute(sql, obj);
	}

	@Override
	public String del(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String find(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByID(int id) {
		
		String sql = "select * from t_user where userID=?";
		
		//将结果集通过Java的反射机制映射到Java对象中
        RowMapper<User> rowMapper = new BeanPropertyRowMapper(User.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<User> findAllUser() {
		String sql = "select * from t_user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper(User.class);
        return this.jdbcTemplate.query(sql, rowMapper);
	}

}
