package com.dh.demo.service;

import com.dh.demo.domain.Subject;
import com.dh.demo.repository.SubjectRepository;
import com.dh.demo.web.RoomController;
import com.dh.demo.web.SubjectController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rOlguin
 */
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public void addSubject(SubjectController.SubjectRequestDTO subjectDto){
        Subject subject = new Subject();
        subject.setCode(subjectDto.getCode());
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
    }
}
