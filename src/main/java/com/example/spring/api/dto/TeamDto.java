package com.example.spring.api.dto;

import com.example.spring.domain.Team;
import lombok.Getter;

@Getter
public class TeamDto extends BaseResultDto {

    private final String name;

    public TeamDto(Team team) {
        super(team);
        name = team.getName();
    }
}
