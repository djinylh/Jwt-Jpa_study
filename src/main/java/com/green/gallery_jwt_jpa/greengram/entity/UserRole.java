package com.green.gallery_jwt_jpa.greengram.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleIds userRoleIds;

    //관계 설정
    @ManyToOne
    @MapsId("userId") // 관계설정 필드 이름
    @JoinColumn(name="user_id")
    private User user;

}
