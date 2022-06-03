package com.example.spring.api.dto;
import com.example.spring.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
public class SaveUserDto {
    @Size(max = 32, min = 3)
    private String name;
    @NotNull
    private Integer age;

    public User toEntity() {
        return User.builder().name(name).age(age).build();
    }
}
