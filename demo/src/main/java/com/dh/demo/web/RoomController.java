package com.dh.demo.web;

import com.dh.demo.domain.Room;
import com.dh.demo.domain.Teacher;
import com.dh.demo.service.RoomService;
import com.dh.demo.service.StudentService;
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
@RequestMapping("/rooms")
public class RoomController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Room> getRoom(){
        return roomService.getAllRooms();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity addRoom(@RequestBody RoomRequestDTO roomRequestDTO){
        roomService.addRoom(roomRequestDTO);
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    public static class RoomRequestDTO{
        private String code;
        private Long capacity;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Long getCapacity() {
            return capacity;
        }

        public void setCapacity(Long capacity) {
            this.capacity = capacity;
        }
    }
}
