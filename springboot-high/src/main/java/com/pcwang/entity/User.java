package com.pcwang.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class User implements Serializable {


    private Integer uid;
    @NotBlank//非空校验
    private String name;
    @NotBlank//非空校验
    @Length(min=6, message="密码长度不能少于六位")
    private String password;
    private Integer age;

    public User() {
    }

    public User(Integer uid, @NotBlank String name, @NotBlank @Length(min = 6, message = "密码长度不能少于六位") String password, Integer age) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
