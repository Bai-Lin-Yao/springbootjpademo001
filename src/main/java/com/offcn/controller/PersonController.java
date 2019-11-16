package com.offcn.controller;

import com.offcn.dao.PersonRepository;
import com.offcn.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    //新增
    @PostMapping("/")
    public String add(@RequestBody Person person){
        personRepository.save(person);
        return"add-ok";
    }

    //查询全部
    @GetMapping("/")
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    //修改
    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,@RequestBody Person person){
        person.setId(id);
        personRepository.saveAndFlush(person);
        return "update-ok";
    }

    //删除
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        personRepository.deleteById(id);
        return "delete-ok";
    }

    //根据id查询用户
    @GetMapping("/{id}")
    public Person findOne(@PathVariable("id") Long id){
        return personRepository.findById(id).get();
    }

}
