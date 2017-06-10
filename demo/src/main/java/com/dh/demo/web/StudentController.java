package com.dh.demo.web;

import com.dh.demo.domain.Student;
import com.dh.demo.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rOlguin
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody StudentRequestDTO studentDTO){
        studentService.addStudent(studentDTO);
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable String id){
        return studentService.searchByStudentId(id);
    }

    @RequestMapping(value = "/{studentId}",method = RequestMethod.PUT)
    public ResponseEntity updateStudent(@PathVariable String studentId,@RequestBody Student student){
        studentService.updateByStudentIdByStudent(studentId,student);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{studentId}",method = RequestMethod.DELETE)
    public ResponseEntity updateStudent(@PathVariable String studentId){
        studentService.deleteByStudentId(studentId);
        return  new ResponseEntity(HttpStatus.OK);
    }


    public static class StudentRequestDTO{
        private String name;
        private Long ci;
        private Long codeSis;

        public String getName() {
            return name;
        }

        public Long getCi() {
            return ci;
        }

        public Long getCodeSis() {
            return codeSis;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCi(Long ci) {
            this.ci = ci;
        }

        public void setCodeSis(Long codeSis) {
            this.codeSis = codeSis;
        }
    }
}

