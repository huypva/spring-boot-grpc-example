package io.codebyexample.springbootgrpcserver.core.usecase;

import io.codebyexample.springbootgrpcclient.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  String greet(String name);
}
