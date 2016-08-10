package com.cs6392016.gbergy.stooperapp;

/**
 * Created by Tony on 7/6/16.
 */
public class User {
    String first, last, username, password, email;

    public User(String first, String last, String email, String username, String password){
        this.first = first;
        this.last = last;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}