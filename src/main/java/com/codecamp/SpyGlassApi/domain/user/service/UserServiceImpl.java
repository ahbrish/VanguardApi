package com.codecamp.SpyGlassApi.domain.user.service;

import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import com.codecamp.SpyGlassApi.domain.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private UserService userService;
//    private GoalService goalService;

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
        Optional<User> userOptional = userRepo.findByUserName(userName);
        if(userOptional.isEmpty())
            throw new UserNameNotFoundException("UserName not found");
        return userOptional.get();
    }

//    @Override
//    public Iterable<Goal> getAllGoals(User user) {
//        return (Iterable<Goal>) userRepo.getAllGoals();
//    }

    @Override
    public void deleteUserAccount(String userName) throws UserNameNotFoundException {
        Optional<User> userAccountExistOption = userRepo.findByUserName("tsunamiMaxx");
        if(userAccountExistOption.isEmpty())
            throw new UserNameNotFoundException("Account with username not found");
        User userAccountToRemove = userAccountExistOption.get();
        userRepo.delete(userAccountToRemove);
    }
}
