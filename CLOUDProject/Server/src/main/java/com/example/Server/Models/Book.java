package com.example.Server.Models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
    private String author;
    private int pageNumber;
    private int readerId;
    private Boolean inLibrary;

    @Override
    public String toString(){
        return  String.valueOf(id)+","+name+","+author+","+String.valueOf(pageNumber)+","+String.valueOf(readerId)+","+String.valueOf(inLibrary);
    }


    public Book(String line){
        String[] parameters = line.split(",");
        id = Integer.parseInt(parameters[0]);
        name = parameters[1];
        author = parameters[2];
        pageNumber = Integer.parseInt(parameters[3]);
        readerId = Integer.parseInt(parameters[4]);
        inLibrary = Boolean.parseBoolean(parameters[5]);
    }
}
