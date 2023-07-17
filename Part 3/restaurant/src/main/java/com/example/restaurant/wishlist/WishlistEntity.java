package com.example.restaurant.wishlist;

import com.example.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishlistEntity extends MemoryDbEntity {
    private String title;                   //음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String readAddress;             // 도로명
    private String homePageLink;            // 링크
    private String imageLink;               // 이미지 링크
    private boolean isVisit;                // 방문 여부
    private int visitCount;                 // 방문 횟수
    private LocalDateTime lastVisitDate;    // 방문 일자


}
