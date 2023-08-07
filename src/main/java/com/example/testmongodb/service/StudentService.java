package com.example.testmongodb.service;

import com.example.testmongodb.model.Student;
import com.example.testmongodb.model.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudentById(String id);
    Student addStudent(StudentDto studentDto);
}
