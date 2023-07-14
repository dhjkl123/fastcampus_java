package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.prefs.BackingStoreException;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/naver")
    public String naver(){
        // https://openapi.naver.com/v1/search/local.json?
        // query=%EA%B0%88%EB%B9%84%EC%B0%9C
        // &display=10
        // &start=1
        // &sort=random
        String query = "갈비찜";

        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query",query)
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("sort","random")
                .encode().build().toUri();

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity.get(uri)
                .header("X-Naver-Client-Id", "v9FlvhoPmxlEOeZ1pp_E")
                .header("X-Naver-Client-Secret","KepiKCymAL")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }



    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }

    @PostMapping("/user/{userid}/name/{userName}")
    public Req<User> post(@RequestBody Req<User> user, @PathVariable int userid,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String auth,
                     @RequestHeader("custom-header") String custom){

        log.info("userid : {}, username : {}",userid, userName);
        log.info("auth : {}, custom : {}",auth, custom);
        log.info("client req : {}",user);

//        User user1 = new User();
//        user1.setAge(userid);
//        user1.setName(userName);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );

        response.setRBody(user.getRBody());

        return response;
    }

}

