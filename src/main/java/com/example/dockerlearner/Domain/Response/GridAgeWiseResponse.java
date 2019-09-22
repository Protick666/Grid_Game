package com.example.dockerlearner.Domain.Response;

import com.example.dockerlearner.Domain.Grid;
import com.example.dockerlearner.Domain.GridRepresentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GridAgeWiseResponse implements Serializable {

    public class GridWithAgeStamp {
        int age;
        GridRepresentation grid;

        public GridWithAgeStamp() {}

        public GridWithAgeStamp(int age, GridRepresentation grid) {
            this.age = age;
            this.grid = grid;
        }
    }

    public int x;
    public int y;

    public List<GridWithAgeStamp> data;

    public GridAgeWiseResponse() {}

    public GridAgeWiseResponse(int x, int y) {
        this.x = x;
        this.y = y;
        this.data = new ArrayList<>();
    }

    public void insertGridStamps(int age, int[][] gridCells) {
        GridRepresentation representation = new GridRepresentation(gridCells);
        GridWithAgeStamp gridWithAgeStamp = new GridWithAgeStamp(age, representation);

        data.add(gridWithAgeStamp);
    }


}
