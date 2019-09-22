package com.example.dockerlearner.Domain;

import java.io.Serializable;

public class GridWithAgeStamp implements Serializable {
    public int age;
    public GridRepresentation grid;

    public GridWithAgeStamp() {}

    public GridWithAgeStamp(int age, GridRepresentation grid) {
        this.age = age;
        this.grid = grid;
    }
}