package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.RoomController;
import com.dh.demo.web.TeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rOlguin
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public void addRoom(RoomController.RoomRequestDTO roomDto){
        Room room = new Room();
        room.setCode(roomDto.getCode());
        room.setCapacity(roomDto.getCapacity());
        roomRepository.save(room);
    }
}
