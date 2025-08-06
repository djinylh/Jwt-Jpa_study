package com.green.gallery_jwt_jpa.greengram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable // 포함될 수 있는 [복합키]
//복합키가 있는 class는 Serializable를 implements 해줘야함
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowIds implements Serializable {
    private Long fromUserId;
    private Long toUserId;


}
