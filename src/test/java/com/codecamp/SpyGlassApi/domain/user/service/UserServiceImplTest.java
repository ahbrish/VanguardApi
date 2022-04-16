package com.codecamp.SpyGlassApi.domain.user.service;

import com.codecamp.SpyGlassApi.domain.user.exceptions.UserNameTakenException;
import com.codecamp.SpyGlassApi.domain.user.model.User;
import com.codecamp.SpyGlassApi.domain.user.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.doReturn;

import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @MockBean
    private UserRepo mockUserRepo;

    @Autowired
    private UserService userService;

    private User inputUser01;
    private User outputUser01;

    @BeforeEach
    public void setUp(){
        inputUser01 = new User("tsunamiMaxx","Maxx","Blue", "tsunamiMaxx@gmail.com");
        outputUser01 = new User("tsunamiMaxx","Maxx","Blue","tsunamiMaxx@gmail.com");
        outputUser01.setUserName("tsunamiMaxx");
//        outputUser01.setId(1L);
    }


    @Test
    @DisplayName("Creating a User - Success")
    public void createUserAccountTest01() throws UserNameTakenException {
        doReturn(outputUser01).when(mockUserRepo).save(ArgumentMatchers.any());
        User returnedUser = userService.createUser(inputUser01);
        Assertions.assertNotNull(returnedUser);
        Assertions.assertEquals(returnedUser.getUserName(), "tsunamiMaxx");
    }


//    @Test
//    @DisplayName("")
//    public void findByUserByUserName() throws UserNameNotFoundException {
//        Optional<User> userOptional = mockUserRepo.findByUserName();
//    }

//    @Test
//    @DisplayName("Delete a User Account - Success")
//    public void deleteUserAccount01() throws UserNameNotFoundException{
//        Optional<User> userExistOption = mockUserRepo.findByUserName("tsunamiMaxx");
//        if(userExistOption.isEmpty())
//            throw new UserNameNotFoundException("No account found with given username");
//        User userAccountToRemove = userExistOption.get();
//        mockUserRepo.delete(userAccountToRemove);
    }

//}
