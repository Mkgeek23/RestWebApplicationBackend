package pl.emkgeek.restwebapplicationbackend.pingpong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PingPongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetPong() throws Exception {
        // given

        // when
        MvcResult mvcResult = mockMvc.perform(get("/status/ping"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();

        // then
        Assertions.assertEquals("pong", mvcResult.getResponse().getContentAsString());
    }
}