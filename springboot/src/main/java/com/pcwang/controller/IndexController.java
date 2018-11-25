package com.pcwang.controller;

import com.pcwang.entity.Employee;
import com.pcwang.entity.Role;
import com.pcwang.mapper.RoleMapper;
import com.pcwang.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private EmpRepository emp;

	@RequestMapping("/")
    @ResponseBody
	public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        List<Employee> emps = emp.findAll();
	    model.addObject("emps", emps);
		return model;
	}

	@Autowired
	private RoleMapper roleMapper;

	@RequestMapping("/role")
	public void selectRoles(){
        List<Role> roles = roleMapper.selectRoles();
        System.out.println("roles = " + roles);
     }
   /* @RequestMapping("/insert")
    public void insertRole(){
       Role role = new Role();
       role.setRoleID(1030);
       role.setRname("R003");
       role.setIsUse(1);
       roleMapper.insertRole(role);
    }

    @RequestMapping("/delete")
    public void deleteRole(int roleID){
	    roleMapper.deleteRole(roleID);
    }*/
}
