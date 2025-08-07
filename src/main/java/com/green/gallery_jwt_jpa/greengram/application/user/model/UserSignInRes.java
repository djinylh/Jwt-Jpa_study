package com.green.gallery_jwt_jpa.greengram.application.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSignInRes {
    private Long userId;
    private String nickname;
    private String pic;
}
