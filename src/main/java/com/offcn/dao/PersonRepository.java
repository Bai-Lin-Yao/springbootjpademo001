package com.offcn.dao;

import com.offcn.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    //根据用户名查询
    public List<Person> findByNameContains(String name);

    //查询指定用户名和密码都相同的用户
    public Person findByNameEqualsAndAgeEquals(String name,Integer age);

    //查询包含指定名字的用户

}
