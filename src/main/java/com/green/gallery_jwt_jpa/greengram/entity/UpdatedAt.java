package com.green.gallery_jwt_jpa.greengram.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass //이 클래스를 상속하면 createAt 컬럼을 가지게 된다. 상속 받을 수 있도록 에노테이션
@EntityListeners(AuditingEntityListener.class) // 이벤트 연결 insert가 될 때 현재일시값 넣을 수 있도록 감시
public class UpdatedAt extends CreatedAt{
    @LastModifiedDate
    @Column(nullable=false)
    private LocalDateTime updatedAt;
}
