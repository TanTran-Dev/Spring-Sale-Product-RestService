package com.spring.baseproject.modules.auth.models.dtos;

import com.spring.baseproject.modules.auth.models.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class UserDto {
    @ApiModelProperty(notes = "id của người dùng")
    private String id;
    @ApiModelProperty(notes = "tên đăng nhập của người dùng", position = 1)
    private String username;
    @ApiModelProperty(notes = "tài khoản có đang bị vô hiệu hóa hay không", position = 2)
    private boolean isBanned;
    @ApiModelProperty(notes = "thời điểm thực hiện xác thực cuối cùng", position = 3)
    private Date lastActive;
    // always create an empty constructor
    public UserDto() {
    }

    public UserDto(String id, String username,
                   Boolean isBanned, //should be Boolean, not boolean, because isBanned may be null
                   Date lastActive) {
        this.id = id;
        this.username = username;
        this.isBanned = isBanned == null ? false : isBanned;
        this.lastActive = lastActive;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.isBanned = user.isBanned();
        this.lastActive = user.getLastActive();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

}
