package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    public UserResponse hello(){

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/api/server/hello")
                .queryParam("name","steve")
                .queryParam("age",20)
                .encode().build().toUri();

        log.info(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        UserResponse result = restTemplate.getForObject(uri,UserResponse.class);

        return result;


    }

    public UserRequest post(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/api/server/user/{userid}/name/{username}")
                .encode().build().expand(100,"steve").toUri();

        log.info(uri.toString());

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserRequest> response = restTemplate.postForEntity(uri,req,UserRequest.class);


        log.info(response.getStatusCode().toString());
        log.info(response.getHeaders().toString());
        log.info(response.getBody().toString());




        return response.getBody();

    }

    public UserResponse exchange(){

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/api/server/user/{userid}/name/{username}")
                .encode().build().expand(100,"steve").toUri();

        log.info(uri.toString());

        UserResponse req = new UserResponse();
        req.setName("steve");
        req.setAge(10);

        RequestEntity<UserResponse> resquestRequestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> responseRequestEntity = restTemplate.exchange(resquestRequestEntity, UserResponse.class);

        return responseRequestEntity.getBody();


    }

    public Req<UserResponse> generic (){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/api/server/user/{userid}/name/{username}")
                .encode().build().expand(100,"steve").toUri();

        log.info(uri.toString());

        UserRequest userRequest = new UserRequest();
        userRequest.setName("steve");
        userRequest.setAge(10);

        Req req = new Req();
        req.setHeader(
                new Req.Header()
        );

        req.setRBody(
                userRequest
        );


        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<Req<UserResponse>>(){});

        return response.getBody();
    }

}
