package com.harish.rentcar.demoapplication.service;

import com.harish.rentcar.demoapplication.repository.StudentRepository;
import com.harish.rentcar.demoapplication.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  public Student fetchStudentById(int id) {
    Optional<Student> student = studentRepository.findById(id);
    if(student.isPresent()) {
      return student.get();
    }
    return null;
  }
}


