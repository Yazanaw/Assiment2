package com.example.assiment2;

public class user {
    String name;
    String pass;
    String email;
    String date;

    public user(String name ,String pass ,String email,String date) {
        this.name = name;
        this.pass=pass;
        this.email=email;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + ',' +
                ", pass='" + pass + ',' +
                ", email='" + email + ',' +
                ", date='" + date + ',' +
                '}';
    }
}






