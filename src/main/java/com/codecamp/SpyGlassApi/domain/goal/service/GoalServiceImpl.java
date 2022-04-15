package com.codecamp.SpyGlassApi.domain.goal.service;

import com.codecamp.SpyGlassApi.domain.goal.exceptions.GoalNotFoundException;
import com.codecamp.SpyGlassApi.domain.goal.model.Goal;
import com.codecamp.SpyGlassApi.domain.goal.model.TypeOfGoal;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService{
    @Override
    public Goal create(Goal goal) {
        return null;
    }

    @Override
    public Goal getById(Long id) throws GoalNotFoundException {
        return null;
    }

    @Override
    public Goal getByGoal(String name) throws GoalNotFoundException {
        return null;
    }

    @Override
    public Goal getByGoalType(TypeOfGoal typeOfGoal) throws GoalNotFoundException {
        return null;
    }

    @Override
    public Iterable<Goal> findAllGoalsForUser(User user) {
        return null;
    }

    @Override
    public Goal updateGoal(Goal goal) throws GoalNotFoundException {
        return null;
    }

    @Override
    public void deleteGoal(Goal goal) throws GoalNotFoundException {

    }

    private Integer calculateProgessPercentage(Double targetSavingsAmount, Double amountAlreadySaved){
        return null;

    }

    private Integer calculateAmountLeftUntilGoal(Double targetSavingsAmount, Double amountAlreadySaved){
        return null;
    }

}
