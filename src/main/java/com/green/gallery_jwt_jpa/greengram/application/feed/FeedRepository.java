package com.green.gallery_jwt_jpa.greengram.application.feed;

import com.green.gallery_jwt_jpa.greengram.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, String> {
}
