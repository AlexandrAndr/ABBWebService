package ru.meschanov.webService;

import generated.GetClientResponse;
import generated.GetClientsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClientEndpoint {

    private static final String NAMESPACE_URI = "http://ru/meschanov/webService";
    private ClientRepository clientRepository;

    @Autowired
    public  ClientEndpoint(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientsRequest")
    @ResponsePayload
    public GetClientResponse getClient(@RequestPayload GetClientsRequest request){
        GetClientResponse response = new GetClientResponse();
        response.setClient(clientRepository.findClient(request.getClient()));
        return response;
    }
}
