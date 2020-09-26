package com.example.demo;

import com.example.demo.httpclient.HttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HttpClient httpClient;

    @Test
    public void testMethodGetInMainController() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //todo
    @Test
    public void tesThrowableExceptionMethodGetInMainController() throws Exception {
        Mockito.doThrow(ClassCastException.class).when(httpClient).get(anyString(), any());
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
