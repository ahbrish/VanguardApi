package com.codecamp.SpyGlassApi.domain.user.service;


import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameTakenException;
import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNotFoundException;
import com.codecamp.SpyGlassApi.domain.user.model.User;

public interface UserService {

    User createUser(User user) throws UserNameTakenException;
    User findUserByUserName(String userName) throws UserNameNotFoundException;
//    Iterable<Goal> getAllGoals(User user);
    void deleteUserAccount(String userName) throws UserNameNotFoundException;

}
