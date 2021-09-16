package io.codebyexample.springbootgrpcclient.dataprovider.greeting;

import io.codebyexample.greeting.grpc.GreetingGrpc.GreetingBlockingStub;
import io.codebyexample.greeting.grpc.GreetingRequest;
import io.codebyexample.greeting.grpc.GreetingResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 */
@Service
public class GreetingGrpcClient implements GreetingClient {

  @GrpcClient("greeting")
  private GreetingBlockingStub greetingBlockingStub;

  @Override
  public String greet(String name) {
    GreetingRequest greetingRequest = GreetingRequest.newBuilder().setName(name).build();

    GreetingResponse response = greetingBlockingStub.greet(greetingRequest);

    return response.getMessage();
  }
}
