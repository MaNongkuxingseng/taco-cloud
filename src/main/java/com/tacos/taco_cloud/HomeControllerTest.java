package taco.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@webMvcTest(HomeController.class)
public class HomeControllerTest {
    // 自动装配 MockMvc 对象，用于模拟 MVC 测试
    @autowired
    private MockMvc mockMvc;
 
    // 测试主页的 HTTP 请求和响应
    @Test
    public void testHomePage() throws Exception {
        // 执行对根路径的 GET 请求，并预期状态码为 200 OK，视图为 "home"，且内容中包含特定字符串
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("home"))
               .andExpect(content.string(containsString("Welcome to...")));
    }
}