package com.green.gallery_jwt_jpa.greengram.application.user;


import com.green.gallery_jwt_jpa.greengram.config.model.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResultResponse<?> signUp() {
        return null;
    }
}
