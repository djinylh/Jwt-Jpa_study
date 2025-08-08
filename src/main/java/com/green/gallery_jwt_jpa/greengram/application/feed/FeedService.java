package com.green.gallery_jwt_jpa.greengram.application.feed;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedService {
    private FeedRepository feedRepository;
}
