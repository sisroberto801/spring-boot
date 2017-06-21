package com.dh.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rOlguin
 */
@Entity(name = "Seller")
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ci")
    private String ci;
    @Column(name = "age")
    private Integer age;
    @Column(name = "numCarsSold")
    private Integer numCarsSold;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<RegistryCarSold> registryCarSolds;

    public Seller() {
        registryCarSolds = new ArrayList<RegistryCarSold>();
        numCarsSold = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumCarsSold() {
        return numCarsSold;
    }

    public void setNumCarsSold(Integer numCarsSold) {
        this.numCarsSold = numCarsSold;
    }

    public List<RegistryCarSold> getRegistryCarSolds() {
        return registryCarSolds;
    }

    public void setRegistryCarSolds(List<RegistryCarSold> registryCarSolds) {
        this.registryCarSolds = registryCarSolds;
    }
}
