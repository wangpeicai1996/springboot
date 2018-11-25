package com.pcwang.mapper;

import com.pcwang.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mybatis的mapper实体映射类
 */
//@Mapper
public interface RoleMapper {

    //@Select("select * from role")
    public List<Role> selectRoles();

    /*@Options(useGeneratedKeys = true,keyProperty = "roleid")//设置主键自增长
    @Insert("insert into role(roleid,rname,isuse) values(#{roleID},#{rname},#{isUse})")
    public void insertRole(Role role);

    @Delete("delete from role where roleid = #{roleID}")
    public void deleteRole(int roleID);*/
}
