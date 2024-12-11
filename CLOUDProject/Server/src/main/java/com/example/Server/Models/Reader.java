package com.example.Server.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    private int id;
    private String name;
    private String surname;
    private String registrationDate;

    @Override
    public String toString(){
        return  String.valueOf(id)+","+name+","+surname+","+registrationDate;
    }

    public Reader(String reader){
        String[] parameters = reader.split(",");
        id = Integer.parseInt(parameters[0]);
        name = parameters[1];
        surname = parameters[2];
        registrationDate = parameters[3];
    }
}
