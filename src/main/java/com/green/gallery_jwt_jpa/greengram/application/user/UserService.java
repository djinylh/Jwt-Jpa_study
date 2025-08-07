package com.green.gallery_jwt_jpa.greengram.application.user;

import com.green.gallery_jwt_jpa.greengram.application.user.model.UserSignInDto;
import com.green.gallery_jwt_jpa.greengram.application.user.model.UserSignInReq;
import com.green.gallery_jwt_jpa.greengram.application.user.model.UserSignInRes;
import com.green.gallery_jwt_jpa.greengram.application.user.model.UserSignReq;
import com.green.gallery_jwt_jpa.greengram.config.enumcode.EnumUserRole;
import com.green.gallery_jwt_jpa.greengram.config.model.JwtUser;
import com.green.gallery_jwt_jpa.greengram.config.util.ImgUploadManager;
import com.green.gallery_jwt_jpa.greengram.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ImgUploadManager imgUploadManager;


    @Transactional
    public void signUp(UserSignReq req, MultipartFile pic) {
        String hashedPassWord = passwordEncoder.encode(req.getUpw());

        User user = new User();
        user.setNickName(req.getNickName());
        user.setUid(req.getUid());
        user.setUpw(hashedPassWord);
        user.adduserRoles(req.getRoles());

        userRepository.save(user);

        if(pic != null) {
            String savedFileName = imgUploadManager.saveProfilePic(user.getUserId(), pic);
            user.setPic(savedFileName);
        }
    }
    public UserSignInDto signIn(UserSignInReq req) {
        User user = userRepository.findByUid(req.getUid());
        if(user == null || !passwordEncoder.matches(req.getUpw(), user.getUpw())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "아이디/비밀번호를 확인해 주세요.");
        }
        //user 튜플을 가져왔는데 user_role에 저장되어 있는 데이터까지 가져올 수 있었던건 양방향 관계 설정을 했기 때문에 가능
        List<EnumUserRole> roles = user.getUerRoles().stream().map(item -> item.getUserRoleIds().getRoleCode()).toList();
        log.info("roles: {}", roles);
        JwtUser jwtUser = new JwtUser(user.getUserId(), roles);

        UserSignInRes userSignInRes = UserSignInRes.builder()
                .userId(user.getUserId())
                .nickname(user.getNickName())
                .pic(user.getPic())
                .build();

        return UserSignInDto.builder()
                .jwtUser(jwtUser)
                .userSignInRes(userSignInRes)
                .build();
    }
}
