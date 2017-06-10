package com.dh.demo.web;

import com.dh.demo.domain.Subject;
import com.dh.demo.service.SubjectService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rOlguin
 */
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Subject> getSubject(){
        return subjectService.getAllSubjects();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity addSubject(@RequestBody SubjectRequestDTO subjectRequestDTO){
        subjectService.addSubject(subjectRequestDTO);
        return  new ResponseEntity(HttpStatus.CREATED);
    }



    public static class SubjectRequestDTO {
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
