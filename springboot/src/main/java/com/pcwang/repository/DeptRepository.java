package com.pcwang.repository;

import com.pcwang.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeptRepository extends JpaRepository<Department,Integer> {

    public List<Department> findByDeptno(Integer deptno);

}
