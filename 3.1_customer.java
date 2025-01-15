package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                 // PK

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Professor professor;

    public Customer() { }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public Long getId() {
        return id;
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

    public Professor getProfessor() {
       return professor;
    }

    public void setProfessor(Professor professor) {
       this.professor = professor;
    }
}
