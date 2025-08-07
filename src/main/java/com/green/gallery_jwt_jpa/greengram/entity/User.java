package com.green.gallery_jwt_jpa.greengram.entity;

import com.green.gallery_jwt_jpa.greengram.config.enumcode.EnumUserRole;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"uid"}
                )
        }
)
public class User extends UpdatedAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 30)
    private String nickName;

    @Column(nullable = false, length = 50)
    private String uid;

    @Column(length = 100)
    private String pic;

    @Column(nullable = false,length = 100)
    private String upw;

    // mappedBy에는 UserRole 의 관계설정 된 필드명
    // cascade는 자식과 나랑 연결 ( 내가 영속성되면 자식도 영속성이 되어서, 내가 삭제되면 자식도 삭제 된다.)
    //ohphanRemoval은 userRoles에서 자식을 하나 제거함. 그러면 DB에도 뺀 자식은 삭제처리가 된다.
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<UserRole> uerRoles = new ArrayList<>(1);


    public void adduserRoles(List<EnumUserRole> enumUserRole) {
        for (EnumUserRole e : enumUserRole) {
            UserRoleIds ids = new UserRoleIds(this.userId, e);
            UserRole userRole =  new UserRole(ids, this);
            this.uerRoles.add(userRole);
        }
    }
}
