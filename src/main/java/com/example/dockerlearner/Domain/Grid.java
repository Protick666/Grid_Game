package com.example.dockerlearner.Domain;

import com.example.dockerlearner.Domain.Request.AddOrModifyGridRequest;

public class Grid {
    int id;
    int x;
    int y;

    int[][] gridCells;

    public Grid() {};

    public Grid(int id, AddOrModifyGridRequest request) {
        this.id = id;

        this.x = request.x;
        this.y = request.y;

        gridCells = new int[x][y];

        //check constraint
        int index = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                gridCells[i][j] = request.data.get(index++);
            }
        }

    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getGridCells() {
        return gridCells;
    }
}
