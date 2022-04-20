package com.codecamp.SpyGlassApi.domain.goal.controller;

import com.codecamp.SpyGlassApi.domain.goal.service.GoalService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class);
public class GoalControllerTest {

    @MockBean
    private GoalService goalService;

    @Autowired
    private MockMvc mockMvc;


}
