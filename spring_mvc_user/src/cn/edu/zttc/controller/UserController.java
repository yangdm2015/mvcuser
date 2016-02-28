package cn.edu.zttc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.edu.zttc.vo.User;
import cn.edu.zttc.vo.UserException;


@Controller
@RequestMapping("/")
@SessionAttributes("loginUser")
public class UserController {
	
	private final static Map<String,User> users = new HashMap<String,User>();
	
	public UserController() {
		users.put("ldh",new User("ldh","刘德华","123","123123"));
		users.put("zxy",new User("zxy","张学友","123","123123"));
		users.put("gfc",new User("gfc","郭富城","123","123123"));
		users.put("lm",new User("lm","黎明","123","123123"));
	}
	
	@RequestMapping({"/users","/"})
	public String list(Model model) {
		model.addAttribute("users",users);//map
		return "user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());//User-->user
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Valid User user,BindingResult binding) {
		if(binding.hasErrors()) {
			return "user/add";
		}
		users.put(user.getUsername(), user);
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/user/users";
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String show(@PathVariable String username,Model model) {
		model.addAttribute(users.get(username));
		return "user/show";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.GET)
	public String update(@PathVariable String username,Model model) {
		model.addAttribute(users.get(username));
		return "user/update";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.POST)
	public String update(@PathVariable String username,@Valid User user,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "user/update";
		}
		users.put(username, user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{username}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String username) {
		users.remove(username);
		return "redirect:/user/users";
	}
	
	@ResponseBody
	@RequestMapping(value="/{username}",params="json")
	public User showJson(@PathVariable String username,Model model) {
		System.out.println(username);
		return users.get(username);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model) {
		if(!users.containsKey(username)) {
			throw new UserException("用户名不存在");
		}
		if(!password.equals(users.get(username).getPassword())) {
			throw new UserException("用户密码不正确");
		}
		model.addAttribute("loginUser", users.get(username));
		return "redirect:/user/users";
	}
	
	@ExceptionHandler(value={UserException.class})
	public String handlerException(Exception ex,HttpServletRequest req) {
		req.setAttribute("ex",ex);
		return "error";
	}
	
	@RequestMapping("/redir")
	public String redir(Model model,RedirectAttributes ra) {
		ra.addFlashAttribute("tttt", "吞吞吐吐");
		return "redirect:/user/users";
	}
	
}
