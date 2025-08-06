package com.green.gallery_jwt_jpa.greengram.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserFollow extends CreatedAt{
    @EmbeddedId
    private UserFollowIds fromUserId;

    @ManyToOne
    @MapsId("fromUserId")
    @JoinColumn(name="from_user_id")
    private User fromUser;

    @ManyToOne
    @MapsId("toUserId")
    @JoinColumn(name="to_user_id")
    private User toUser;


}
