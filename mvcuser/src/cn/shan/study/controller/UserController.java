package cn.shan.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.shan.study.meta.User;

@Controller
@RequestMapping("/user")
public class UserController { 
	private final static Map<String,User>users=new HashMap<String,User>();

	public UserController() {
		users.put("ldh",new User("ldh","刘德华","123","123123"));
		users.put("zxy",new User("zxy","张学友","123","123123"));
		users.put("gfc",new User("gfc","郭富城","123","123123"));
		users.put("lm",new User("lm","黎明","123","123123"));
	}
	@RequestMapping("/users") 
	public String list(Model model){
		System.out.println("list"); 
		model.addAttribute("users",users);
		return "user/list";		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());
		return "user/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid User user,BindingResult binding){
		users.put(user.getUsername(),user);
		if(binding.hasErrors()){
			return "redirect:user/add";
		}
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/user/users";
	}

}
