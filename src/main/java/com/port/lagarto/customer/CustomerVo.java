package com.port.lagarto.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVo extends CustomerEntity {

    private int iproduct;
    private String nickname;
    private String profileImg;
    private String reviewImg;
    private String productTitle;
    private String communityImg;

}
