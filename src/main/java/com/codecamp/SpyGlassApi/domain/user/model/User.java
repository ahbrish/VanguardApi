package com.codecamp.SpyGlassApi.domain.user.model;

import com.codecamp.SpyGlassApi.domain.goal.model.Goal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private List<Goal> listOfGoals;

    public User() {
    }

    public User(String userName, String firstName, String lastName, List<Goal> listOfGoals) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.listOfGoals = listOfGoals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Goal> getListOfGoals() {
        return listOfGoals;
    }

    public void setListOfGoals(List<Goal> listOfGoals) {
        this.listOfGoals = listOfGoals;
    }
}
