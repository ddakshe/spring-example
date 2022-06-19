package com.example.spring.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Users", schema = "spring")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User extends BaseEntity {

    @Column(nullable = false, length = 64)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 32)
    private String name;
    @Column(nullable = false)
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Embedded
    private Address homeAddress;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Role role;


    /*동적으로 Team 을 넣기위해 메소드 생성
    * 일부러 만들었다는 것을 보여주기 위해 직접 생성*/
    public void setTeam(Team team) {
        this.team = team;
    }
}
