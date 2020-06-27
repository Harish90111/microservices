package com.harish.rentcar.demoapplication.service;

import com.harish.rentcar.demoapplication.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
  Student save(Student student);
  Student fetchStudentById(int id);
}
