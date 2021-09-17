package io.codebyexample.springbootgrpcserver.entrypoint;

import io.codebyexample.greeting.grpc.GreetingGrpc;
import io.codebyexample.greeting.grpc.GreetingRequest;
import io.codebyexample.greeting.grpc.GreetingResponse;
import io.codebyexample.springbootgrpcserver.core.usecase.GreetUseCase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huypva
 */
@GrpcService
public class Controller extends GreetingGrpc.GreetingImplBase {

  @Autowired
  GreetUseCase greetUseCase;

  @Override
  public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
    String message = greetUseCase.greet(request.getName());

    GreetingResponse response = GreetingResponse.newBuilder()
        .setMessage(message)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
