package com.dh.demo.service;

import com.dh.demo.domain.Student;
import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.StudentRepository;
import com.dh.demo.web.StudentController;
import com.dh.demo.web.TeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rOlguin
 */

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(StudentController.StudentRequestDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setCi(studentDTO.getCi());
        student.setCodeSis(studentDTO.getCodeSis());
        studentRepository.save(student);
    }

    public void deleteByStudentId(String studentId){
        studentRepository.delete(studentId);
    }

    public void updateByStudentIdByStudent(String studentId,Student student){
        Student temp  = studentRepository.findOne(studentId);
        temp.setName(student.getName());
        studentRepository.save(temp);
    }
    public Student searchByStudentId(String studentId){
        return studentRepository.findOne(studentId);
    }

}
