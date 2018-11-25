package com.pcwang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pcwang.entity.Employee;

/**
 * jpa提供的简化类接口，只要继承JpaRepository接口，默认提供了一些常用的数据库操作方法
 * sb运行启东市时会自动生成具体实现类
 * 使用此接口时，需要传入对应的实体类，和主键类型
 *
 * @author Administrator
 */
@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {


    /**
     * 此处的sql语句是JPQL查询语句，select后面的"*"需要换成别名,from后面是实体类
     * JPQL对like模糊查询支持不是很好，自定义sql实现like模糊查询，使用拼接字符串方式实现，用concat()函数拼接sql语句
     * 通过":参数名"传值,@Param()对应参数
     *
     * @param keyword
     * @return
     */
    @Query("select e from Employee e where ename like CONCAT('%',:keyword,'%')")
    public List<Employee> findByName(@Param("keyword") String keyword);

    /**
     * 通过Spring规定的接口命名方法自动创建复杂的CRUD操作
     * findByEnameContaining(String keyword)等同于
     * select * from emp where ename like '%keyword%';
     *
     * @param keyword
     * @return 官方给出的命名规则关键字如下：
     * Keyword						Sample								JPQL snippet
     * And					findByLastnameAndFirstname				… where x.lastname = ?1 and x.firstname = ?2
     * Or					findByLastnameOrFirstname				… where x.lastname = ?1 or x.firstname = ?2
     * Is,Equals			findByFirstname,findByFirstnameIs,findByFirstnameEquals		… where x.firstname = ?1
     * Between				findByStartDateBetween					… where x.startDate between ?1 and ?2
     * LessThan			findByAgeLessThan						… where x.age < ?1
     * LessThanEqual		findByAgeLessThanEqual					… where x.age <= ?1
     * GreaterThan			findByAgeGreaterThan					… where x.age > ?1
     * GreaterThanEqual	findByAgeGreaterThanEqual				… where x.age >= ?1
     * After
     * findByStartDateAfter
     * … where x.startDate > ?1
     * Before
     * findByStartDateBefore
     * … where x.startDate < ?1
     * IsNull
     * findByAgeIsNull
     * … where x.age is null
     * IsNotNull,NotNull
     * findByAge(Is)NotNull
     * … where x.age not null
     * Like
     * findByFirstnameLike
     * … where x.firstname like ?1
     * NotLike
     * findByFirstnameNotLike
     * … where x.firstname not like ?1
     * StartingWith
     * findByFirstnameStartingWith
     * … where x.firstname like ?1 (parameter bound with appended %)
     * EndingWith
     * findByFirstnameEndingWith
     * … where x.firstname like ?1 (parameter bound with prepended %)
     * Containing
     * findByFirstnameContaining
     * … where x.firstname like ?1 (parameter bound wrapped in %)
     * OrderBy
     * findByAgeOrderByLastnameDesc
     * … where x.age = ?1 order by x.lastname desc
     * Not
     * findByLastnameNot
     * … where x.lastname <> ?1
     * In
     * findByAgeIn(Collection<Age> ages)
     * … where x.age in ?1
     * NotIn
     * findByAgeNotIn(Collection<Age> age)
     * … where x.age not in ?
     * True
     * findByActiveTrue()
     * … where x.active = true
     * False
     * findByActiveFalse()
     * … where x.active = false
     * IgnoreCase
     * findByFirstnameIgnoreCase
     * … where UPPER(x.firstame) = UPPER(?1)
     */
    public List<Employee> findByEnameContaining(String keyword);

    /**
     * 通过?占位符和参数列表顺序1传值
     *
     * @param sal
     * @return
     */
    @Query("select e from Employee e where sal = ?1")
    public Employee findBySal(String sal);
}
