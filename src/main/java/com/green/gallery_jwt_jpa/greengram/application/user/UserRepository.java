package com.green.gallery_jwt_jpa.greengram.application.user;

import com.green.gallery_jwt_jpa.greengram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
