package com.tacos.taco_cloud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    // 自动装配 MockMvc 对象，用于模拟 MVC 测试
    @Autowired
    private MockMvc mockMvc;
 
    // 测试主页的 HTTP 请求和响应
    @Test
    public void testHomePage() throws Exception {
        // 执行对根路径的 GET 请求，并预期状态码为 200 OK，视图为 "home"，且内容中包含特定字符串
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("home"))
               .andExpect(content().string(containsString("Welcome to")));        // thymeleaf 模板中页面标题声明为：Welcome to Taco Cloud。content() 方法用于验证响应内容。
    }
}