package io.codebyexample.springbootgrpcclient.entrypoint;

import io.codebyexample.springbootgrpcclient.core.usecase.HelloWorldUseCase;
import io.codebyexample.springbootgrpcclient.core.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
public class Controller {

  @Autowired
  HelloWorldUseCase helloWorldUseCase;

  @GetMapping("/hello")
  public Message hello(@RequestParam(name = "name") String name) {
    return helloWorldUseCase.hello(name);
  }
}
