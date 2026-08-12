package com.mvc.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.config.AppConfig;
import com.mvc.entity.Employee;
import com.mvc.impl.EmployeeDAOImpl;

@Controller
@RequestMapping("/home")
public class HomeController {

	private AnnotationConfigApplicationContext ac;

	@RequestMapping("/**")
	public String error()
	{
		return "pageNotFound";
	}
	
	@RequestMapping("/enterData")
	public String enterData()
	{
		return "collectData";
	}
	
	@RequestMapping("/sendData")
	public String sendData(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("desg") String desg,
			@RequestParam("salary") int salary,
			Model model)
	{
		
		System.out.println(id+" "+name+" "+desg+" "+salary);
		
		ac = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeDAOImpl edao = ac.getBean(EmployeeDAOImpl.class);
		Employee e = (Employee) ac.getBean("employee");
		
		e.setEmpid(id);
		e.setEmpName(name);
		e.setEmpDesg(desg);
		e.setEmpSalary(salary);
		
		edao.insertEmployee(e);
		model.addAttribute("name", name);
		
		
		return "dispData";
	}
	
	@RequestMapping("/deleteData")
	public String delete(@RequestParam("id") int id, Model model)
	{
		ac = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeDAOImpl edao = ac.getBean(EmployeeDAOImpl.class);
		Employee e = (Employee) ac.getBean("employee");
		
		edao.delete(id);
		model.addAttribute("id", id);
		
		return "delete";
		
	}
}
