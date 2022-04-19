package com.codecamp.SpyGlassApi.domain.user.service;

import com.codecamp.SpyGlassApi.domain.goal.model.Goal;
import com.codecamp.SpyGlassApi.domain.goal.service.GoalService;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import com.codecamp.SpyGlassApi.domain.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private UserService userService;
    private GoalService goalService;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, GoalService goalService){
        this.userRepo = userRepo;
        this.goalService = goalService;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserByUserName(String userName) throws UserNameNotFoundException {
        Optional<User> userOptional = userRepo.findByUserName(userName);
        if(userOptional.isEmpty())
            throw new UserNameNotFoundException("UserName not found");
        return userOptional.get();
    }

    @Override
    public List<Goal> getAllGoalsForUser(User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepo.findByUserName(user.getUserName());
        if(userOptional.isEmpty())
            throw new UserNotFoundException("User not found");
        User user1 = userOptional.get();
        List<Goal> goals = user1.getListOfGoals();
        return goals;
    }


    @Override
    public void deleteUserAccount(String userName) throws UserNameNotFoundException {
        Optional<User> userAccountExistOption = userRepo.findByUserName("tsunamiMaxx");
        if(userAccountExistOption.isEmpty())
            throw new UserNameNotFoundException("Account with username not found");
        User userAccountToRemove = userAccountExistOption.get();
        userRepo.delete(userAccountToRemove);
    }

    @Override
    public User assignGoalsToUser(User user, Goal goal) throws UserNameNotFoundException {
       Optional<User> userAccountExistOption = userRepo.findByUserName("tsunamiMaxx");
        if(userAccountExistOption.isEmpty())
            throw new UserNameNotFoundException("Account with username not found");
        User userFound = userAccountExistOption.get();

        List<Goal> listOfGoals = userFound.getListOfGoals();
        goalService.create(goal);
        listOfGoals.add(goal);
        userFound.setListOfGoals(listOfGoals);
        return userRepo.save(userFound);
    }
}

