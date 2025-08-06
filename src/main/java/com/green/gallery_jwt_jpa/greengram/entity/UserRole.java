package com.green.gallery_jwt_jpa.greengram.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleIds userRoleIds;

    @ManyToOne
    @MapsId("userId") // 관계설정 필드 이름
    @JoinColumn(name="user_id")
    private User user;

}
