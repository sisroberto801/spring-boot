package com.dh.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rOlguin
 */
@Entity(name = "Car")
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "brand")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<RegistryCarSold> registryCarSolds;

    public Car(){
        registryCarSolds = new ArrayList<RegistryCarSold>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<RegistryCarSold> getRegistryCarSolds() {
        return registryCarSolds;
    }

    public void setRegistryCarSolds(List<RegistryCarSold> registryCarSolds) {
        this.registryCarSolds = registryCarSolds;
    }
}
