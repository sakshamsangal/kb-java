package com.example.rest;

import lombok.Data;


@Data
public class Person {

    private int id;
    private String name;
    private String description;
    private double price;
}