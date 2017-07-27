package com.kobicc.kbsp.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String> rt;

	@RequestMapping("/addKey")
	public String addUser() {
		ValueOperations<String, String> values = rt.opsForValue();
		values.set("kobicc", "de");
		String name = values.get("wzg");
		System.out.println(name);
		return "/user/list";
	}
}
