package com.green.gallery_jwt_jpa.greengram.application.feed;


import com.green.gallery_jwt_jpa.greengram.application.feed.model.FeedPostReq;
import com.green.gallery_jwt_jpa.greengram.config.model.ResultResponse;
import com.green.gallery_jwt_jpa.greengram.config.model.UserPrincipal;
import com.green.gallery_jwt_jpa.greengram.entity.Feed;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/feed")
public class FeedController {
    private FeedService feedService;


    @PostMapping
    public ResultResponse<?> postFeed(@AuthenticationPrincipal UserPrincipal userPrincipal, @Valid @RequestPart FeedPostReq req, @RequestPart(name="pic") List<MultipartFile> pics) {

        log.info("signUserId :{}", userPrincipal.getSignUserId());
        log.info("pics : {}", pics.size());
        log.info("req :{}", req);
        feedService.postFeed(userPrincipal.getSignUserId(), req,pics);
        return new ResultResponse<>("피드 등록 완료",null);
    }
}
