package com.lucky.hello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author 600006
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class InitControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        InitController controller = new InitController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getHello() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1:8080/init/hello")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();

        //断言预期结果和状态
        Assert.assertTrue("错误", status == 200);
        String expectedResult = "init finish";
        Assert.assertFalse("数据不一致", !expectedResult.equals(content));

    }


}
