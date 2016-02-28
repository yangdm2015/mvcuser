package com.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {	
	@RequestMapping("/hello.action")
	public @ResponseBody UData anwser(HttpServletRequest req,HttpServletResponse res ){
		/*String xing = req.getParameter("LastName");
		String ming = req.getParameter("FirstName");*/
		
		UData ud = new UData("002","Likq");
		return ud;
	}	
	
	
	@RequestMapping("/nihao.action")
	public @ResponseBody UData rsp(HttpServletRequest req,HttpServletResponse res ) throws ServletException, IOException{
		String xing = req.getParameter("LastName");
		String ming = req.getParameter("FirstName");
		
		UData ud = new UData(xing,ming);
		return ud;
	}	
}
