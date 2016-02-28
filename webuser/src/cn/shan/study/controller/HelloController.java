package cn.shan.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.shan.study.meta.User;

@Controller
@RequestMapping("/user")
public class HelloController {
	private final static Map<String,User>users=new HashMap<String,User>();
	
	public HelloController() {
		users.put("ldh",new User("ldh","刘德华","123","123123"));
		users.put("zxy",new User("zxy","张学友","123","123123"));
		users.put("gfc",new User("gfc","郭富城","123","123123"));
		users.put("lm",new User("lm","黎明","123","123123"));
	}
	@RequestMapping(value={"/users"})
	public String list(Model model){
		System.out.println("list");
		return "user/list";		
	}

	@RequestMapping (value={"/h","/hh"})
	public String hello1( int isd){
		System.out.println(isd);
		System.out.println("hello1");
	    return "hello";
	}/**/

	

}
