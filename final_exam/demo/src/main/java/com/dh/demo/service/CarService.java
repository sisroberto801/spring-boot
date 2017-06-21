package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.domain.Car;
import com.dh.demo.repository.CarRepository;
import com.dh.demo.web.BuyerController;
import com.dh.demo.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(CarController.CarRequestDTO car){
        carRepository.save(changeDTOToObject(new Car(),car));
    }
    public void update(Long id,CarController.CarRequestDTO car){
        carRepository.save(changeDTOToObject(carRepository.findOne(id),car));
    }
    public void delete(Long id){
        carRepository.delete(id);
    }

    private Car changeDTOToObject(Car temp , CarController.CarRequestDTO dto){
        temp.setBrand(dto.getBrand());
        temp.setColor(dto.getColor());
        temp.setImage(dto.getImage());
        temp.setModel(dto.getModel());
        temp.setYear(dto.getYear());
        return temp;
    }
}
