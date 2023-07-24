package com.fastcampus.jpa.bookmanager.repository.dto;

import lombok.Data;

@Data
public class BookStatus {
    private int code;
    private String description;

    public BookStatus(int code){
        this.code = code;
        this.description = parsDescription(code);
    }

    public String parsDescription(int code){

        switch (code) {
            case 100:
                return "판매 종료";
            case 200:
                return  "판매중";
            case 300:
                return  "판매 보류";
            default:
                return  "미지원";
        }
    }

    public boolean isDisplayed() {
        return code == 200;
    }
}
