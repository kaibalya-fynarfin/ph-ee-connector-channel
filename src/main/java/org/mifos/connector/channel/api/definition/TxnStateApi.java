package org.mifos.connector.channel.api.definition;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mifos.connector.channel.examples.SuccessfulTxnStateResponseDTO;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

public interface TxnStateApi {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SuccessfulTxnStateResponseDTO.class))) })
    @GetMapping("/channel/txnState/{X-CorrelationID}")
    TxnStateResponseDTO txnState(@RequestHeader(value = "Platform-TenantId") String tenant,
            @PathVariable(value = CLIENTCORRELATIONID) String correlationId, @RequestHeader(value = "requestType") String requestType)
            throws JsonProcessingException;
}
