package com.example.spring.dto;

import com.example.spring.database.domain.BaseEntity;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public abstract class BaseResultDto {
    private final Long id;
    private final ZonedDateTime createdDate;
    private final ZonedDateTime modifiedDate;

    @QueryProjection
    public BaseResultDto(BaseEntity baseEntity){
        id = baseEntity.getId();
        createdDate = baseEntity.getCreatedDate();
        modifiedDate = baseEntity.getModifiedDate();
    }
}
