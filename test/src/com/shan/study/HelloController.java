package com.shan.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class HelloController {
	
	@RequestMapping (value={"/hii","/hi"})
	public String hello(@RequestParam("userid") int id){
		System.out.println(id);
		System.out.println("hellouserid");
	    return "hello";
	}/**/
	@RequestMapping (value={"/h","/hh"})
	public String hello1( int isd){
		System.out.println(isd);
		System.out.println("hello1");
	    return "hello";
	}/**/
	
	@RequestMapping (value={"/hello"})
	public String hello( String id,Map<String,Object> mapssss){
		System.out.println(id);
		System.out.println("Hello");
		mapssss.put("hello", id);
	return "hello";
	}
	
	@RequestMapping (value={"/see"})
	public String see(Model mod, String id,String name){
		System.out.println(id);
		System.out.println("Hello");
		mod.addAttribute("hello", "this is see replying:"+id);
		mod.addAttribute("says", "\n replying:"+name);
		
	return "say";
	}
	
	@RequestMapping(value ="/say")
	public String say(Model model){
		model.addAttribute("hello","hello's value");

		model.addAttribute("says","say's value");
		//String dddd = "get string";
		//return "hello";	
		return "say";
		//从这段看，@RequestMapping方法 的返回值是一个键值对的key，这个key同时也被认为是视图的名字，
		//该方法的参数都可以被视图页面用$(key)的方式调用
		//选哪个视图
	}
	
	@RequestMapping("/req")
	public String req(HttpServletRequest req){
		System.out.println(req.getParameter("username"));
		return"hello";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest req){
		
		return"reply";
	}
}
