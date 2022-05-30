package com.example.admin.teacher;

public class TeacherData {
    private String name, phone, post, jon, image, key;

    public TeacherData() {
    }

    public TeacherData(String name, String phone, String post, String jon, String image, String key) {
        this.name = name;
        this.phone = phone;
        this.post = post;
        this.jon = jon;
        this.image = image;
        this.key = key;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getJon() {
        return jon;
    }

    public void setJon(String jon) {
        this.jon = jon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
