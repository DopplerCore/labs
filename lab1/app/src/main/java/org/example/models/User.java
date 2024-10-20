package org.example.models;

public class User {
    private int id;
    private String name;
    private String bio;
    private String adress;
    private String phone;
    
    public User() {}

    public User(int id, String name, String bio, String adress, String phone) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.adress = adress;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
