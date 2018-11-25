package com.pcwang.controller;

import com.pcwang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

/**
 * 表单数据校验
 */
@Controller
public class UserController {

    @RequestMapping("/add")
    public String addUser(User user){
        return "add";
    }

    /**
     * 完成用户添加
     * @Valid 开启对User对象的数据校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("u")@Valid User user, BindingResult result){
        if(result.hasErrors()){//判断当前校验结果是否出错
               return "add";//校验出错就返回此页面
        }
        System.out.println("user = " + user);
        return "success";
    }

    @RequestMapping("/showuser")
    public String showUser(){
        String str = null;
        str.length();
        return "index";
    }


}
