package com.example.erp_App.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class Student {
    private Integer roll_no;
    private String name;

    private String gender;
    private List<Double> marks= new ArrayList<>();

    private String city;


}
