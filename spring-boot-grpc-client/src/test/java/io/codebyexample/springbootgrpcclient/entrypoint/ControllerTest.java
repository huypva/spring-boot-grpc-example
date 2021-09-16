package io.codebyexample.springbootgrpcclient.entrypoint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.codebyexample.springbootgrpcclient.core.usecase.HelloWorldUseCase;
import io.codebyexample.springbootgrpcclient.core.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(Controller.class)
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private HelloWorldUseCase helloWorldUseCase;

  @Test
  void greet() throws Exception {
    String api = "/hello?name=World";
    String expectResponse = "Server message: Hello World!";

    given(helloWorldUseCase.hello("World"))
        .willReturn(new Message("Server message: Hello World!"));

    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());

    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is(expectResponse)));
  }
}