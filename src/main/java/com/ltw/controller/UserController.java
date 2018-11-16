package com.ltw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltw.entity.User;
import com.ltw.service.UserService;

@Controller
public class UserController {
 
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/index")
	@CrossOrigin(origins="http://localhost:8088")
	public String sava(Model model,HttpServletRequest request) {
		System.out.println(request.getAttribute("startTime"));
		User user = new User();
		user.setAge(14);
		user.setName("王五");
		user.setSex("男");
		user=userService.save(user);
		model.addAttribute("user", user);
		model.addAttribute("count",request.getSession().getAttribute("count"));
		return "index";
		
	}
	
	@RequestMapping(value="/find")
	public String find(Model model,int id) {
		User user =userService.findById(id);
		model.addAttribute("user", user);
		return "find";
	}
	@RequestMapping(value="/findAll")
	public String findAll(Model model) {
		List<User> list =userService.findAll();
		model.addAttribute("list", list);
		return "findAll";
	}
	
}
