package com.green.gallery_jwt_jpa.greengram.application.feed.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedPostReq {
    @Size(max=1000)
    private String contents;
    @Size(max=30)
    private String location;
}
