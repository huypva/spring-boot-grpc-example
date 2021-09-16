package io.codebyexample.springbootgrpcclient.core.usecase;

import io.codebyexample.springbootgrpcclient.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(String name);
}
