package com.kobicc.kbsp.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kobicc.kbsp.beans.User;
import com.kobicc.kbsp.factory.UserFactory;
import com.kobicc.kbsp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;

	@RequestMapping("/addUser")
	public String addUser() {
		User user = (new UserFactory()).createUser("小明", 7, "123456");
		int id = userService.add(user);
		System.out.println("addUser controller.id=" + id);
		return "/user/list";
	}
	
	@RequestMapping("/editUser")
	public String editUser() {
		String uuid = userService.edit(null);
		System.out.println("editUser controller.");
		return "/editUser.html";
	}
	
	@RequestMapping("/findUserByID")
	public String findUserByID() {
		User user = userService.findUserByID(2);
		System.out.println("user = " + user.toString());
		return "/user/list";
	}
}
