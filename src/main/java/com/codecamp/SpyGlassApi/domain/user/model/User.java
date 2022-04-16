package com.codecamp.SpyGlassApi.domain.user.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

//    @OneToMany(targetEntity = Goal.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private List<Goal> listOfGoals;

    public User() {
    }
    public User(String userName, String firstName, String lastName, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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

//    public List<Goal> getListOfGoals() {
//        return listOfGoals;
//    }

//    public void setListOfGoals(List<Goal> listOfGoals) {
//        this.listOfGoals = listOfGoals;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
