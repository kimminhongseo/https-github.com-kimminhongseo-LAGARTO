package com.port.lagarto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVo extends CustomerEntity {
    private String productTitle;
    private String nickname;
}
