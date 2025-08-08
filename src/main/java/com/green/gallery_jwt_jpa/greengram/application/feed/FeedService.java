package com.green.gallery_jwt_jpa.greengram.application.feed;

import com.green.gallery_jwt_jpa.greengram.application.feed.model.FeedPostReq;
import com.green.gallery_jwt_jpa.greengram.config.util.ImgUploadManager;
import com.green.gallery_jwt_jpa.greengram.entity.Feed;
import com.green.gallery_jwt_jpa.greengram.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FeedService {
    private FeedRepository feedRepository;
    private ImgUploadManager imgUploadManager;

    @Transactional
    public void postFeed(long signedUserId, FeedPostReq req, List<MultipartFile> pics) {
        User writerUser = new User();
        writerUser.setUserId(signedUserId);

        Feed feed = Feed.builder()
                .writerUser(writerUser)
                .location(req.getLocation())
                .contents(req.getContents())
                .build();

        feedRepository.save(feed); //feed객체는 영속성을 가진다

        List<String> fileNames = imgUploadManager.saveFeedPics(feed.getFeedId(),pics);
        feed.addFeedPics(fileNames);
    }

}
