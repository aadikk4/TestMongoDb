package com.example.testmongodb.service.Impl;

import com.example.testmongodb.exception.StudentNotFoundException;
import com.example.testmongodb.mapper.StudentMapper;
import com.example.testmongodb.model.Student;
import com.example.testmongodb.model.StudentDto;
import com.example.testmongodb.repository.StudentRepository;
import com.example.testmongodb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper.INSTANCE::toDto)
                .toList();
    }

    @Override
    public StudentDto getStudentById(String id) {
        return StudentMapper.INSTANCE.toDto(studentRepository.findById(id).
                orElseThrow(() -> new StudentNotFoundException("Student with id " + id + "not found")));
    }

    @Override
    public Student addStudent(StudentDto studentDto) {
        return studentRepository.insert(StudentMapper.INSTANCE.toEntity(studentDto));
    }
}
