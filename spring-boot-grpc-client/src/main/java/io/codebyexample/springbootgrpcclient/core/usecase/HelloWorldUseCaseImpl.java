package io.codebyexample.springbootgrpcclient.core.usecase;

import io.codebyexample.springbootgrpcclient.core.entity.Message;
import io.codebyexample.springbootgrpcclient.dataprovider.greeting.GreetingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Slf4j
@Component
public class HelloWorldUseCaseImpl implements HelloWorldUseCase {

  @Autowired
  GreetingClient greetingClient;

  @Override
  public Message hello(String name) {
    String greetingMsg = greetingClient.greet(name);

    Message message = new Message(String.format("Server message: %s", greetingMsg));
    return message;
  }
}
