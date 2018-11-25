package com.pcwang.controller;

import com.pcwang.entity.Department;
import com.pcwang.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptRepository dept;


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Department> getDept(){
        List<Department> depts = dept.findAll();
        return depts;
    }

}
