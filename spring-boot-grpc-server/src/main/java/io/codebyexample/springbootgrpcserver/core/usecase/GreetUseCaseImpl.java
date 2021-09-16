package io.codebyexample.springbootgrpcserver.core.usecase;

import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class GreetUseCaseImpl implements GreetUseCase {

  @Override
  public String greet(String name) {
    String message = String.format("Hi %s!", name);
    return message;
  }
}
