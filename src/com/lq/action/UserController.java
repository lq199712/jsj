package com.lq.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lq.po.PageObject;
import com.lq.po.User;
import com.lq.service.IUserService;

@Controller
@RequestMapping("/user")
@SessionAttributes({"u","a"})
public class UserController  {

	@Resource
	private IUserService userService;
	private List<User> users = new ArrayList<User>();
	private User user = new User();
 	
	@RequestMapping("/add")
	public String add(HttpServletResponse response,User user) throws IOException
	{
		userService.add(user);
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String delete(HttpServletResponse response,@PathVariable Integer id) throws IOException
	{
		userService.deleteById(id);
		
		return "redirect:/user/list.do";
	}
	
	@RequestMapping(value= "/list")
	public String list(ModelMap map,PageObject pageObject)
	{
		if (pageObject.getConvalue() != null && !pageObject.getConvalue().equals("")) {
			pageObject.setConvalue(URLDecoder.decode(pageObject.getConvalue(), "utf-8"));
		}
		
		if (pageObject.getPage() < 1) {
			pageObject.setPage(1);
		}
		// 总记录数
		pageObject.setTotalCount(userService.getTotalCount(pageObject.getCon(), pageObject.getConvalue()));
		totalCount = unitService.getTotalCount(con, convalue, userRoleo);
		// 总页数
		pageCount = unitService.getPageCount(totalCount, size);
		if (page > pageCount && pageCount != 0) {
			page = pageCount;
		}
		// 所有当前页记录对象
		units = unitService.queryList(con, convalue, userRoleo, page, size);
		
		
		
		
		users = new ArrayList<User>();
		users =  userService.getUsers();
		map.put("users",users);
		return "user_manage";
	}
	
	
	@RequestMapping(value= "/load/{id}")
	public String load(ModelMap map,@PathVariable Integer id)
	{
		user =  userService.loadById(id);
		map.put("user",user);
		return "/user/user_update";
	}
	
	
	@RequestMapping("/update")
	public String update(User user) throws IOException
	{
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		userService.update(user);
		return "redirect:/user/list.do";
	}
	
	
	
	@RequestMapping(params="method=reg2")
	public ModelAndView reg2(User user){
		System.out.println("UserController.reg2()");
		System.out.println(user.getUsername());
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	
	@RequestMapping(params="method=reg3")
	public String reg3(@RequestParam("uname") String name,HttpServletRequest req,ModelMap map){
		System.out.println("UserController.reg()");
		System.out.println(name);
		req.getSession().setAttribute("c", "ccc");
		map.put("a", "aaa");
		
		return "index";
	}
	
	@RequestMapping(params="method=reg4")
	public String reg4(@ModelAttribute("a") String a,HttpServletRequest req,ModelMap map){
		System.out.println("UserController.reg4()");
		System.out.println(a);
		return "redirect:http://www.baidu.com";
	}
	
	@RequestMapping(params="method=reg5")
	public ModelAndView reg5(String uname){
		System.out.println("UserController.reg5()");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		User u = new User("lq","");
		User u2 = new User("pl","");
		
		mav.addObject(u);
		mav.addObject("uu", u2);
		
		return mav;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
}
