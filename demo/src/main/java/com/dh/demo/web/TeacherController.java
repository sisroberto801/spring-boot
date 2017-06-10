package com.dh.demo.web;

import com.dh.demo.domain.Teacher;
import com.dh.demo.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/teachers")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class TeacherController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    TeacherService teacherService;

    //@ApiOperation(value = "Search a product with an ID",response = Teacher.class)
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Teacher> getTeacher(){
        return teacherService.getAllTeachers();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity addTeacher(@RequestBody TeacherRequestDTO teacherDTO){
        teacherService.addTeacher(teacherDTO);
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Teacher getTeacherById(@PathVariable String id){
        return teacherService.searchByTeacherId(id);
    }

    @RequestMapping(value = "/{teacherId}",method = RequestMethod.PUT)
    public ResponseEntity updateTeacher(@PathVariable String teacherId,@RequestBody Teacher teacher){
        teacherService.updateByTeacherIdByTeacher(teacherId,teacher);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{teacherId}",method = RequestMethod.DELETE)
    public ResponseEntity updateTeacher(@PathVariable String teacherId){
        teacherService.deleteByTeacherId(teacherId);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/updateName/{id}/{name}",method = RequestMethod.GET)
    public List<Teacher> getTeacherByName(@PathVariable String id,@PathVariable String name){
        return teacherService.searchTeacherByName(id,name);
    }


    public static class TeacherRequestDTO{
        private String name;
        private long ci;
        private String prefession;

        public void setName(String name) {
            this.name = name;
        }

        public void setCi(long ci) {
            this.ci = ci;
        }

        public void setPrefession(String prefession) {
            this.prefession = prefession;
        }

        public String getName() {
            return name;
        }

        public long getCi() {
            return ci;
        }

        public String getPrefession() {
            return prefession;
        }
    }
}

