package com.codecamp.SpyGlassApi.domain.user.service;

import com.codecamp.SpyGlassApi.domain.goal.model.Goal;
import com.codecamp.SpyGlassApi.domain.goal.service.GoalService;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import com.codecamp.SpyGlassApi.domain.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private GoalService goalService;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserByUserName(String userName) throws UserNameNotFoundException {
        return null;
    }

    @Override
    public Iterable<Goal> getAllGoals(User user) {
        return null;
    }


    @Override
    public void deleteUserAccount(String userName) throws UserNameNotFoundException {

    }
}
