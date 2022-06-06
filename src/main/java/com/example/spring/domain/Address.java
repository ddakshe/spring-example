package com.example.spring.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address {
    @Size(max = 64, min = 5)
    private String roadAddress;
    private String city;
    private String zipNo;
}
