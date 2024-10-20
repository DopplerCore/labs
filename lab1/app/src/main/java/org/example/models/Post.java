package org.example.models;

public class Post {
    private int id;
    private String text;
    private String file;
    private int user_id;

    public Post() {}

    public Post(int id, String text, String file, int user_id) {
        this.id = id;
        this.text = text;
        this.file = file;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
}
