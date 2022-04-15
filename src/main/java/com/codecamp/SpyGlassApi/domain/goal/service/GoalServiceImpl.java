package com.codecamp.SpyGlassApi.domain.goal.service;

import com.codecamp.SpyGlassApi.domain.goal.exceptions.GoalNotFoundException;
import com.codecamp.SpyGlassApi.domain.goal.model.Goal;
import com.codecamp.SpyGlassApi.domain.goal.model.TypeOfGoal;
import com.codecamp.SpyGlassApi.domain.goal.repo.GoalRepo;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class GoalServiceImpl implements GoalService{

    private GoalRepo goalRepo;

    @Autowired
    public GoalServiceImpl(GoalRepo goalRepo){
        this.goalRepo = goalRepo;
    }

    @Override
    public Goal create(Goal goal) {
        calculateProgressPercentage(goal);
        return goalRepo.save(goal);
    }

    @Override
    public Goal getById(Long id) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findById(id);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal Not Found");
        return goalOptional.get();
    }

    @Override
    public Goal getByGoal(String name) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findByGoal(name);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal Not Found");
        return goalOptional.get();
    }

    @Override
    public Goal getByGoalType(TypeOfGoal typeOfGoal) throws GoalNotFoundException {
        Optional<Goal> goalOptional = goalRepo.findByGoalType(typeOfGoal);
        if(goalOptional.isEmpty())
            throw new GoalNotFoundException("Goal Not Found");
        return goalOptional.get();
    }

    @Override
    public Iterable<Goal> findAllGoalsForUser(User user) {
        return null;
    }

    @Override
    public Goal updateGoal(Goal goal) throws GoalNotFoundException {
        Long id = goal.getId();
        Optional<Goal> goalOptional = goalRepo.findById(id);
        if(goalOptional.isEmpty()){
            throw new GoalNotFoundException("Goal not found");
        }
        return null;
    }

    @Override
    public void deleteGoal(Goal goal) throws GoalNotFoundException {

    }

    private static void calculateProgressPercentage(Goal goal){
        Double amountAlreadySaved = goal.getAmountAlreadySaved();
        Double targetSavingsAmount = goal.getTargetSavingsAmount();
        Double decimal = (amountAlreadySaved / targetSavingsAmount) * 100;
        goal.setProgressPercentage(decimal);

        Double amountLeft = targetSavingsAmount - amountAlreadySaved;
        goal.setAmountLeftUntilGoal(amountLeft);
    }

}
