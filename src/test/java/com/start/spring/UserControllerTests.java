package com.start.spring;

import com.start.spring.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    void shouldReturnCustomMessage() throws Exception {
        this.mockMvc.perform(get("/hello").param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Alice!"));
    }
}
