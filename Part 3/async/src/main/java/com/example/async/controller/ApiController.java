package com.example.async.controller;

import com.example.async.service.AsycService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsycService asycService;

    @GetMapping("/hello")
    public CompletableFuture hello(){
        log.info("CompletableFuture init");
        return asycService.run();
    }
}
