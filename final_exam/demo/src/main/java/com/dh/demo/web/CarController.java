package com.dh.demo.web;

import com.dh.demo.domain.Car;
import com.dh.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CarRequestDTO car){
        carService.addCar(car);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateCar(@RequestBody CarRequestDTO car,@PathVariable Long id){
        carService.update(id,car);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable long id){
        carService.delete(id);
    }

    public static class CarRequestDTO{
        private String model;
        private Integer year;
        private String brand;
        private String color;
        private String image;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
