package com.dh.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rOlguin
 */
@Entity(name = "Buyer")
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buyer_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ci")
    private String ci;
    @Column(name = "profession")
    private String profession;
    @Column(name = "cellphone")
    private String cellphone;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<RegistryCarSold> registryCarSolds;

    public Buyer(){
        registryCarSolds = new ArrayList<>();
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<RegistryCarSold> getRegistryCarSolds() {
        return registryCarSolds;
    }

    public void setRegistryCarSolds(List<RegistryCarSold> registryCarSolds) {
        this.registryCarSolds = registryCarSolds;
    }
}
