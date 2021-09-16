package io.codebyexample.springbootgrpcclient.core.usecase;

import io.codebyexample.springbootgrpcclient.core.entity.Message;

/**
 * @author huypva
 */
public interface HelloWorldUseCase {

  Message hello(String name);
}
