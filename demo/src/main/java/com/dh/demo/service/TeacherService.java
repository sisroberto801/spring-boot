package com.dh.demo.service;

import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.TeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rOlguin
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(TeacherController.TeacherRequestDTO teacherDto){
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setCi(teacherDto.getCi());
        teacher.setPrefession(teacherDto.getPrefession());
        teacherRepository.save(teacher);
    }

    public void deleteByTeacherId(String teacherId){
        teacherRepository.delete(teacherId);
    }

    public void updateByTeacherIdByTeacher(String teacherId,Teacher teacher){
        Teacher temp  = teacherRepository.findOne(teacherId);
        temp.setName(teacher.getName());
        teacherRepository.save(temp);
    }

    public Teacher searchByTeacherId(String teacherId){
        return teacherRepository.findOne(teacherId);
    }

    public List<Teacher> searchTeacherByName(String id,String name){
        List<Teacher> list = teacherRepository.getTeacherByName(id,name);
        return list;
    }
}
