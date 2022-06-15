package com.example.spring.database.domain;

import lombok.*;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address {
    private String roadAddress;
    private String city;
    private String zipNo;
}
