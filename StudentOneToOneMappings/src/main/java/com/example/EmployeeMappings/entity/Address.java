package com.example.EmployeeMappings.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;


@Embeddable
public class Address {
    private int addressId;
    private String city;
}
