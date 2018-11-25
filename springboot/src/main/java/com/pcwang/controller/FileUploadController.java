package com.pcwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 处理上传文件
 */
@RestController
public class FileUploadController {

    @RequestMapping("/file")
    public ModelAndView fileHtml(){
        ModelAndView model = new ModelAndView("upload");
        return  model;
    }

    @RequestMapping("/fileUpload")
    public ModelAndView fileUpload(@RequestParam("filename") MultipartFile file) throws IOException {
        ModelAndView model = new ModelAndView("index");
        String orginName =  file.getOriginalFilename();//文件原始名称
        String extName = orginName.substring(orginName.lastIndexOf("."),orginName.length());
        System.out.println("extName = " + extName);
        file.transferTo(new File("d:/files/"+new Date().getTime()+extName));
        return model;
    }


    @RequestMapping("/filesUpload")
    public ModelAndView filesUpload(HttpServletRequest request) throws IOException {
        ModelAndView model = new ModelAndView("index");
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("filename");
        for(MultipartFile file : files){//循环上传
            String orginName =  file.getOriginalFilename();//文件原始名称
            System.out.println("orginName = " + orginName);
            String extName = orginName.substring(orginName.lastIndexOf("."),orginName.length());
            file.transferTo(new File("d:/files/"+new Date().getTime()+extName));
        }
        return model;
    }
}
