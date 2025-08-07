package com.green.gallery_jwt_jpa.greengram.config.model;

import com.green.gallery_jwt_jpa.greengram.config.enumcode.EnumUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class JwtUser {
    private Long signedUserId;
    private List<EnumUserRole> roles; //인가 처리 때 사용
    /*
    role 이름은 ROLE_아무거나

    ROLE_USER, ROLE_ADMIN, ROLE_MANAGER, ROLE_LEVEL_1 ...
     */
}
