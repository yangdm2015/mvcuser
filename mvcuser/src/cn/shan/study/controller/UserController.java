package cn.shan.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.shan.study.meta.User;

@Controller

public class UserController {
	private final static Map<String,User>users=new HashMap<String,User>();

	public UserController() {
		users.put("ldh",new User("ldh","刘德华","123","123123"));
		users.put("zxy",new User("zxy","张学友","123","123123"));
		users.put("gfc",new User("gfc","郭富城","123","123123"));
		users.put("lm",new User("lm","黎明","123","123123"));
	}
	@RequestMapping(value={"/users"})
	public String list(Model model){
		model.addAttribute("users",users);
		return "user/list";		
	}
	@RequestMapping("/")
	public String hello(Model model){
		System.out.println("hello");
		return "user/list";		
	}
	@RequestMapping("/user")
	public String hello1(Model model){
		System.out.println("hello1");
		return "user/list";		
	}

}
