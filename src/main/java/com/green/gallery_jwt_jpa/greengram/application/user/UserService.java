package com.green.gallery_jwt_jpa.greengram.application.user;

import com.green.gallery_jwt_jpa.greengram.application.user.model.UserSignReq;
import com.green.gallery_jwt_jpa.greengram.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignReq req, MultipartFile pic) {
        String hashedPassWord = passwordEncoder.encode(req.getUpw());

        User user = new User();
        user.setNickName(req.getNickName());
        user.setUid(req.getUid());
        user.setUpw(hashedPassWord);
        user.adduserRoles(req.getRoles());

        userRepository.save(user);
    }
}
