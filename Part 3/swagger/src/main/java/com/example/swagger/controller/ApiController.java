package com.example.swagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API를 정보를 제공하는 COntroller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/plus/{x}")
    public int hello(@PathVariable int x, @RequestParam int y){
        return x+y;
    }

}
