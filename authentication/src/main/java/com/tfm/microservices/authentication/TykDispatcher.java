package com.tfm.microservices.authentication;

import com.tfm.microservices.authentication.config.JwtTokenUtil;
import coprocess.CoprocessObject;
import coprocess.CoprocessReturnOverrides;
import coprocess.CoprocessSessionState;
import coprocess.DispatcherGrpc;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
@Slf4j
public class TykDispatcher extends DispatcherGrpc.DispatcherImplBase {

    final String FOOBAR = "foobar";

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void dispatch(CoprocessObject.Object request,
                         io.grpc.stub.StreamObserver<CoprocessObject.Object> responseObserver) {

        System.out.println("*** Incoming Request ***");
        System.out.println("Hook name: " + request.getHookName());

        final CoprocessObject.Object modifiedRequest = MyAuthHook(request);
        responseObserver.onNext(modifiedRequest);

        System.out.println("*** Transformed Request ***");

        responseObserver.onCompleted();
    }

    CoprocessObject.Object MyAuthHook(CoprocessObject.Object request) {
        String authHeader = request.getRequest().getHeadersOrDefault("Authorization", "");
        log.warn("Header: " + authHeader);
        boolean validJwt = jwtTokenUtil.validateJwtToken(authHeader);
        if(!validJwt) {
            CoprocessObject.Object.Builder builder = request.toBuilder();
            CoprocessReturnOverrides.ReturnOverrides retOverrides = CoprocessReturnOverrides.ReturnOverrides.newBuilder()
            .setResponseCode(403)
            .setResponseError("Not authorized")
            .build();

            builder.getRequestBuilder().setReturnOverrides(retOverrides);
            return builder.build();
        }

        final long expiryTime = (System.currentTimeMillis() / 1000) + 5;

        CoprocessSessionState.SessionState session = CoprocessSessionState.SessionState.newBuilder()
        .setRate(1000.0)
        .setPer(1.0)
        .setIdExtractorDeadline(expiryTime)
        .build();

        CoprocessObject.Object.Builder builder = request.toBuilder();
        // Mandatory fields
        builder.putMetadata("token", FOOBAR);  // Used for downstream chains
        builder.setSession(session);

        return builder.build();
    }
}
