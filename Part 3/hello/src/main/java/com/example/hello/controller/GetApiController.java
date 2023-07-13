package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi",method = RequestMethod.GET)
    public String hi(){
        return "get hi";
    }

    // ../api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName, String name){
        System.out.println(pathName);
        return pathName;
    }

    // ../api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(e-> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println();

            sb.append(e.getKey() + " = " + e.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name +" "+ email + " "+ age;
    }


    //?user=steve&email=steve@gmail.com&age=30
    //변수와 키 값을 매칭
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
