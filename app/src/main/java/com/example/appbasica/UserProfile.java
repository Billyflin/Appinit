package com.example.appbasica;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserProfile {
    public static ArrayList<UserProfile> Users= new ArrayList<>();
    private static String ID="0";
    private String Name;
    private String Nickname;
    private String Email;


    public UserProfile(String name, String nickname, String email,String Id) {
        Name = name;
        Nickname = nickname;
        Email = email;
        ID = Id;
    }
    public UserProfile(String name, String nickname, String email) {
        ID = IDGenerator.getRandomString(15);
        Name = name;
        Nickname = nickname;
        Email = email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getEmail() {
        return Email;
    }

    @NonNull
    @Override
    public String toString() {
        return
                Name + ',' +
                Nickname + ',' +
                Email + ',' +
                ID;
    }


    @NotNull
    public static String getID() {
        return ID;
    }
}
