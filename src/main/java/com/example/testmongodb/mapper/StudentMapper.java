package com.example.testmongodb.mapper;

import com.example.testmongodb.model.Student;
import com.example.testmongodb.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
}
