package com.example.spring.api.dto;

import com.example.spring.domain.BaseEntity;
import lombok.Getter;
import java.time.ZonedDateTime;

@Getter
public abstract class BaseResultDto {
    private final Long id;
    private final ZonedDateTime createdDate;
    private final ZonedDateTime modifiedDate;

    public BaseResultDto(BaseEntity baseEntity){
        id = baseEntity.getId();
        createdDate = baseEntity.getCreatedDate();
        modifiedDate = baseEntity.getModifiedDate();
    }
}
