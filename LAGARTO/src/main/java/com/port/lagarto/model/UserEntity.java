package com.port.lagarto.model;

import com.port.lagarto.enums.JoinResult;
import lombok.Data;

@Data
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String nickname;
    private String contact_first;
    private String contact_second;
    private String contact_third;
    private String profile_img;
    private String address_post;
    private String address_primary;
    private String address_secondary;
    private int desc;
    private int desc_choose;
    private int level;
    private int level_bar;
    private String rdt;

    private JoinResult result;
}
