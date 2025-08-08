package com.green.gallery_jwt_jpa.greengram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
@Builder
//이름이 중요하지 않음
public class FeedPicIds implements Serializable {
    private Long feedId;
    @Column(length = 50)
    private String pic;
}
