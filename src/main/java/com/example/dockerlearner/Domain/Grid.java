package com.example.dockerlearner.Domain;

import com.example.dockerlearner.Domain.Request.AddGridRequest;

public class Grid {
    int x;
    int y;

    int[][] gridCells;

    public Grid() {};

    public Grid(AddGridRequest request) {
        this.x = request.x;
        this.y = request.y;

        gridCells = new int[x][y];

        //cehck constraint
        int index = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                gridCells[i][j] = request.gridDescription.get(index++);
            }
        }

    }
}
