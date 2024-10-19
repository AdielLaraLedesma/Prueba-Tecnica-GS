package com.adiel.prueba_tecnica_backend.infrastructure.entities;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;
import jakarta.persistence.*;

@Entity
@Table(name = "Branch")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;

    public BranchEntity() {
    }

    public BranchEntity(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Branch toDomainModel(){
        return new Branch(id, name, address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
