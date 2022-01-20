package com.port.lagarto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerEntity {
    private int iboard;
    private int board_type;
    private int product_num;
    private String title;
    private String ctnt;
    private String ctnt_img;
    private int iuser;
    private String rdt;
    private String mdt;
}
