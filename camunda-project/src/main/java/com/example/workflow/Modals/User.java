package com.example.workflow.Modals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private long age;

    private boolean adult;
    private String videoGame;

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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean canEnter) {
        this.adult = canEnter;
    }

    public String getVideoGame() {
        return videoGame;
    }

    public void setVideoGame(String videoGame) {
        this.videoGame = videoGame;
    }
}
