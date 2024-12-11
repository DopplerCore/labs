package com.example.Server.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String surname;
    private int experience;
    private int section;

    @Override
    public String toString(){
        return  String.valueOf(id)+","+name+","+surname+","+String.valueOf(experience)+","+String.valueOf(section);
    }

    public Employee(String employee){
        String[] parameters = employee.split(",");
        id = Integer.parseInt(parameters[0]);
        name = parameters[1];
        surname = parameters[2];
        experience = Integer.parseInt(parameters[3]);
        section = Integer.parseInt(parameters[4]);
    }
}
