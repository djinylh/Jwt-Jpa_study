package com.green.gallery_jwt_jpa.greengram.application.user;


import com.green.gallery_jwt_jpa.greengram.application.user.model.UserSignReq;
import com.green.gallery_jwt_jpa.greengram.config.model.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResultResponse<?> signUp(@Valid @RequestPart UserSignReq req, @RequestPart(required = false) MultipartFile pic) {

        log.info("req : {} ", req);
        log.info("pic : {} ", pic != null ? pic.getOriginalFilename() : pic);
        userService.signUp(req, pic);
        return new ResultResponse<Integer>("",1);
    }
}
