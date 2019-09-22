package com.example.dockerlearner.Domain.Response;

import com.example.dockerlearner.Domain.Grid;
import com.example.dockerlearner.Domain.GridRepresentation;
import com.example.dockerlearner.Domain.GridWithAgeStamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GridAgeWiseResponse implements Serializable {

    public int x;
    public int y;

    public List<GridWithAgeStamp> data;

    public GridAgeWiseResponse() {}

    public GridAgeWiseResponse(int x, int y) {
        this.x = x;
        this.y = y;
        this.data = new ArrayList<>();
    }

    public void insertGridStamp(int age, int[][] gridCells) {
        GridRepresentation representation = new GridRepresentation(gridCells);
        GridWithAgeStamp gridWithAgeStamp = new GridWithAgeStamp(age, representation);

        data.add(gridWithAgeStamp);
    }


}
