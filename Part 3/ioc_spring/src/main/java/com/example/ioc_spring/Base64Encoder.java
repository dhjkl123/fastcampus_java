package com.example.ioc_spring;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("Base74Encoder")
public class Base64Encoder implements IEncoder {
    @Override
    public String Encoder(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
