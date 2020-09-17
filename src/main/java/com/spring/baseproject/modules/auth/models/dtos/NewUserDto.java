package com.spring.baseproject.modules.auth.models.dtos;

import com.spring.baseproject.annotations.validator.text.length.MinLength;
import com.spring.baseproject.annotations.validator.text.no_space.NoSpace;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class NewUserDto {
    @ApiModelProperty(notes = "username của người dùng", example = "NOT_EMPTY, NO_SPACE")
    @NoSpace
    private String username;
    @ApiModelProperty(notes = "password của người dùng", example = "NOT_EMPTY, MIN_LENGTH=6", position = 1)
    @NotEmpty
    @MinLength(6)
    private String password;
}
