package com.example.spring.dto;

import com.example.spring.database.domain.Team;
import lombok.Getter;

@Getter
public class TeamDto extends BaseResultDto {

    private final String name;

    public TeamDto(Team team) {
        super(team);
        name = team.getName();
    }

    public static TeamDto fromEntity(Team team){
        return new TeamDto(team);
    }
}
