package com.fastcampus.bookmanger.domain;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Builder
public class MyUser {
    @Id
    @GeneratedValue// 자동으로 증가
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}
