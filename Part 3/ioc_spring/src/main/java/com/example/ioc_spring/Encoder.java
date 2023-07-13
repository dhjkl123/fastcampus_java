package com.example.ioc_spring;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;

    }

    public void setiEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String Encoder(String msg) {
        return iEncoder.Encoder(msg);
    }
}
