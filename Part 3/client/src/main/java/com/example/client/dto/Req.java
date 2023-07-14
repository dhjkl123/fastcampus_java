package com.example.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Req<T> {

    private Header header;
    private T rBody;

    @Getter
    @Setter
    public static class Header {
        private String responseCode;
    }

    @Override
    public String toString() {
        return "Req{" +
                "header=" + header +
                ", body=" + rBody +
                '}';
    }
}
