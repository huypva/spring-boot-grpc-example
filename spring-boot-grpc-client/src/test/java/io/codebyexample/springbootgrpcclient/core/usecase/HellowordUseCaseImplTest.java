package io.codebyexample.springbootgrpcclient.core.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import io.codebyexample.springbootgrpcclient.core.entity.Message;
import io.codebyexample.springbootgrpcclient.dataprovider.greeting.GreetingClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huypva
 */
@ExtendWith(SpringExtension.class)
@Import(HelloWorldUseCaseImpl.class)
class HellowordUseCaseImplTest {

  @Autowired
  HelloWorldUseCaseImpl helloWorldUseCaseImpl;

  @MockBean
  GreetingClient greetingClient;

  @Test
  void helloworld() {
    String name = "World";
    String defaultValue = "Server message: Hello World!";
    given(greetingClient.greet(name)).willReturn("Hello " + name + "!");

    Message message = helloWorldUseCaseImpl.hello(name);
    assertThat(defaultValue).isEqualTo(message.getMessage());
  }
}