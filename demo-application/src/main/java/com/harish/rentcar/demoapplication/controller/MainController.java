package com.harish.rentcar.demoapplication.controller;

import com.harish.rentcar.demoapplication.model.Student;
import com.harish.rentcar.demoapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @Autowired
  StudentService studentService;

  @RequestMapping(value = "/hello", method=  RequestMethod.GET)
  public String greeting1(){
    return "Hello Springboot from GET";
  }

  @RequestMapping(value = "/hello", method=  RequestMethod.POST)
  public String greeting2(){
    return "Hello Springboot from POST";
  }

  @RequestMapping(value = "/student", method = RequestMethod.POST)
  public Student save(@RequestBody Student student) {
    return studentService.save(student);
  }

  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public ResponseEntity<Student> fetchStudent(@RequestParam int id) {
    Student student = studentService.fetchStudentById(id);
    if(student == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(student);
  }
}
