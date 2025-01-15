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

    // One-to-one relationship (Customer is the “parent” side)
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Professor professor;

    public Customer() { }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // --- Getters / Setters ---

    public Long getId() {
        return id;
    }

    // No need for setId(...) if you’re relying on auto-generation

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
