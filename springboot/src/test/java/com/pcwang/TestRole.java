package com.pcwang;

import com.pcwang.entity.Role;
import com.pcwang.mapper.RoleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.PrimitiveIterator;

public class TestRole {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void TestSelectRoles(){
       List<Role> roles =  roleMapper.selectRoles();
       // System.out.println(roles);
    }
}
