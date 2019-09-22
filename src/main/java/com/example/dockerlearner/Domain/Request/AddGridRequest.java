package com.example.dockerlearner.Domain.Request;

import java.io.Serializable;
import java.util.List;

public class AddGridRequest implements Serializable {
    public int x;
    public int y;
    public List<Integer> gridDescription;
}
