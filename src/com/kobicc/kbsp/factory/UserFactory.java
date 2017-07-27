package com.kobicc.kbsp.factory;

import com.kobicc.kbsp.beans.User;

public class UserFactory {

	public User createUser(String name, int id, String password){
        User user = new User();
        user.setUserName(name);
        user.setUserID(id);
        user.setPassword(password);
        return user;
    }
}
