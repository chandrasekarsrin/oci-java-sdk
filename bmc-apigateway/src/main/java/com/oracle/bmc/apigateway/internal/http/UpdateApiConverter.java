/**
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.apigateway.internal.http;

import com.oracle.bmc.http.internal.ResponseHelper;
import com.oracle.bmc.apigateway.model.*;
import com.oracle.bmc.apigateway.requests.*;
import com.oracle.bmc.apigateway.responses.*;
import org.apache.commons.lang3.Validate;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20190501")
@lombok.extern.slf4j.Slf4j
public class UpdateApiConverter {
    private static final com.oracle.bmc.http.internal.ResponseConversionFunctionFactory
            RESPONSE_CONVERSION_FACTORY =
                    new com.oracle.bmc.http.internal.ResponseConversionFunctionFactory();

    public static com.oracle.bmc.apigateway.requests.UpdateApiRequest interceptRequest(
            com.oracle.bmc.apigateway.requests.UpdateApiRequest request) {

        return request;
    }

    public static com.oracle.bmc.http.internal.WrappedInvocationBuilder fromRequest(
            com.oracle.bmc.http.internal.RestClient client,
            com.oracle.bmc.apigateway.requests.UpdateApiRequest request) {
        Validate.notNull(request, "request instance is required");
        Validate.notBlank(request.getApiId(), "apiId must not be blank");
        Validate.notNull(request.getUpdateApiDetails(), "updateApiDetails is required");

        com.oracle.bmc.http.internal.WrappedWebTarget target =
                client.getBaseTarget()
                        .path("/20190501")
                        .path("apis")
                        .path(
                                com.oracle.bmc.util.internal.HttpUtils.encodePathSegment(
                                        request.getApiId()));

        com.oracle.bmc.http.internal.WrappedInvocationBuilder ib = target.request();

        ib.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);

        if (request.getIfMatch() != null) {
            ib.header("if-match", request.getIfMatch());
        }

        if (request.getOpcRequestId() != null) {
            ib.header("opc-request-id", request.getOpcRequestId());
        }

        return ib;
    }

    public static com.google.common.base.Function<
                    javax.ws.rs.core.Response,
                    com.oracle.bmc.apigateway.responses.UpdateApiResponse>
            fromResponse() {
        final com.google.common.base.Function<
                        javax.ws.rs.core.Response,
                        com.oracle.bmc.apigateway.responses.UpdateApiResponse>
                transformer =
                        new com.google.common.base.Function<
                                javax.ws.rs.core.Response,
                                com.oracle.bmc.apigateway.responses.UpdateApiResponse>() {
                            @Override
                            public com.oracle.bmc.apigateway.responses.UpdateApiResponse apply(
                                    javax.ws.rs.core.Response rawResponse) {
                                LOG.trace(
                                        "Transform function invoked for com.oracle.bmc.apigateway.responses.UpdateApiResponse");
                                com.google.common.base.Function<
                                                javax.ws.rs.core.Response,
                                                com.oracle.bmc.http.internal.WithHeaders<Void>>
                                        responseFn = RESPONSE_CONVERSION_FACTORY.create();

                                com.oracle.bmc.http.internal.WithHeaders<Void> response =
                                        responseFn.apply(rawResponse);
                                javax.ws.rs.core.MultivaluedMap<String, String> headers =
                                        response.getHeaders();

                                com.oracle.bmc.apigateway.responses.UpdateApiResponse.Builder
                                        builder =
                                                com.oracle.bmc.apigateway.responses
                                                        .UpdateApiResponse.builder();

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcWorkRequestIdHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-work-request-id");
                                if (opcWorkRequestIdHeader.isPresent()) {
                                    builder.opcWorkRequestId(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-work-request-id",
                                                    opcWorkRequestIdHeader.get().get(0),
                                                    String.class));
                                }

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcRequestIdHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-request-id");
                                if (opcRequestIdHeader.isPresent()) {
                                    builder.opcRequestId(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-request-id",
                                                    opcRequestIdHeader.get().get(0),
                                                    String.class));
                                }

                                com.oracle.bmc.apigateway.responses.UpdateApiResponse
                                        responseWrapper = builder.build();

                                ResponseHelper.closeResponseSilentlyIfNotBuffered(rawResponse);
                                return responseWrapper;
                            }
                        };
        return transformer;
    }
}