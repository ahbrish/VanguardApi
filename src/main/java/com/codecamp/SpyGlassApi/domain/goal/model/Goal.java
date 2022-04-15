package com.codecamp.SpyGlassApi.domain.goal.model;

import com.codecamp.SpyGlassApi.domain.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private TypeOfGoal typeOfGoal;
    private String title;
    private String description;
    private String goalIcon;
    private String customGoalColor;
    private Double targetSavingsAmount;
    private Double amountAlreadySaved;
    private Date savingsDateGoal;
    private Double amountLeftUntilGoal;
    private Integer progressPercentage;

    public User getUser() {
        return user;
    }

    public Goal() {
    }

}
