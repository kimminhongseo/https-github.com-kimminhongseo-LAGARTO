package com.port.lagarto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {
    private int iuser;
    private String email;
    private String name;
    private String nickname;
}
