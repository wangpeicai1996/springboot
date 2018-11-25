package com.pcwang.controller;

import java.util.List;
import java.util.Optional;

import com.pcwang.bean.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pcwang.entity.Employee;
import com.pcwang.repository.EmpRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private AppConfig app;


	@RequestMapping("/{id}")//通过路径变量传入参数
	@ResponseBody
	public Employee findById(@PathVariable("id") Integer id) {
		//Optional是实体类的包装类，用于判断对象是否存在
		Optional<Employee> optional = empRepository.findById(id);
		Employee emp = null;
		if(optional.isPresent()) {//用于判断传入的id是否有对应的数据，有就返回true,否则返回false
			emp = optional.get();//获取到对应的包装类包装的实体类
		}
		return emp;
	}
	
	@RequestMapping("/find/{id}")//通过路径变量传入参数
	@ResponseBody
	public ModelAndView findById2(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("index");
		Employee emp = empRepository.findById(id).get();
		model.addObject("emps", emp);
		return model;
	}
	
	
	@RequestMapping("/")
	@ResponseBody
	public String findAll(WebRequest req, HttpServletRequest request) {
		List<Employee> emps = empRepository.findAll();
		//req.setAttribute("emp", emps );
        request.setAttribute("emp", emps);
		return "index";
	}
	
	@RequestMapping("/key/{keyword}")//通过路径变量传入参数
	@ResponseBody
	public ModelAndView findByName(@PathVariable("keyword") String keyword) {
		ModelAndView model = new ModelAndView("index");
		System.out.println("关键字========"+keyword);
		//List<Employee> emps = empRepository.findByName(keyword);
		List<Employee> emps = empRepository.findByEnameContaining(keyword);
		model.addObject("emps", emps);
		return model;
	}
	
	@RequestMapping("/key")
	@ResponseBody
	public ModelAndView findBySal(String sal) {
		ModelAndView model = new ModelAndView("index");
		System.out.println("工资========"+sal);
		Employee emps = empRepository.findBySal(sal);
		model.addObject("emps", emps);
		return model;
	}

	@RequestMapping(value = "/ename",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView findByEname(String keyword){
		System.out.println("ename = " + keyword);
		ModelAndView model = new ModelAndView("index");
		List<Employee> emps = empRepository.findByEnameContaining(keyword);
		if(emps.size()>0){
			model.addObject("emps",emps);
		}else{
			model = new ModelAndView("error");
		}
		return model;
	}

	/**
	 * 返回一个jsp页面
	 * @return
	 */
	@RequestMapping("/jsp")
	public String getAllEmps(Model model){
		List<Employee> emps = empRepository.findAll();
		model.addAttribute("emps",emps);
		return "employee";
	}

}
