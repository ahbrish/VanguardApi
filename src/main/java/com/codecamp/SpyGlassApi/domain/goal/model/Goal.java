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

    public Goal() {
    }

    public Goal(User user, TypeOfGoal typeOfGoal, String title, String description, String goalIcon, String customGoalColor, Double targetSavingsAmount, Double amountAlreadySaved, Date savingsDateGoal) {
        this.user = user;
        this.typeOfGoal = typeOfGoal;
        this.title = title;
        this.description = description;
        this.goalIcon = goalIcon;
        this.customGoalColor = customGoalColor;
        this.targetSavingsAmount = targetSavingsAmount;
        this.amountAlreadySaved = amountAlreadySaved;
        this.savingsDateGoal = savingsDateGoal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeOfGoal getTypeOfGoal() {
        return typeOfGoal;
    }

    public void setTypeOfGoal(TypeOfGoal typeOfGoal) {
        this.typeOfGoal = typeOfGoal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoalIcon() {
        return goalIcon;
    }

    public void setGoalIcon(String goalIcon) {
        this.goalIcon = goalIcon;
    }

    public String getCustomGoalColor() {
        return customGoalColor;
    }

    public void setCustomGoalColor(String customGoalColor) {
        this.customGoalColor = customGoalColor;
    }

    public Double getTargetSavingsAmount() {
        return targetSavingsAmount;
    }

    public void setTargetSavingsAmount(Double targetSavingsAmount) {
        this.targetSavingsAmount = targetSavingsAmount;
    }

    public Double getAmountAlreadySaved() {
        return amountAlreadySaved;
    }

    public void setAmountAlreadySaved(Double amountAlreadySaved) {
        this.amountAlreadySaved = amountAlreadySaved;
    }

    public Date getSavingsDateGoal() {
        return savingsDateGoal;
    }

    public void setSavingsDateGoal(Date savingsDateGoal) {
        this.savingsDateGoal = savingsDateGoal;
    }

    public Double getAmountLeftUntilGoal() {
        return amountLeftUntilGoal;
    }

    public void setAmountLeftUntilGoal(Double amountLeftUntilGoal) {
        this.amountLeftUntilGoal = amountLeftUntilGoal;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }
}
