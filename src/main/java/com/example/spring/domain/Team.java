package com.example.spring.domain;

import com.example.spring.api.dto.TeamDto;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Team extends BaseEntity{
    private String name;
    public TeamDto toDto() {
        return new TeamDto(this);
    }
}
