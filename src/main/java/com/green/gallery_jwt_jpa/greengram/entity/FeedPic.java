package com.green.gallery_jwt_jpa.greengram.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class FeedPic extends CreatedAt{
    @EmbeddedId
    private FeedPicIds feedPicIds;

    //관계 설정
    @ManyToOne
    @MapsId("feedId")
    @JoinColumn(name = "feed_id")
    private Feed feed;


}
