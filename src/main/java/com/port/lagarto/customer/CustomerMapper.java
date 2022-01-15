package com.port.lagarto.customer;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerVo> selReviewList(CustomerDto dto);
    List<CustomerVo> selHelpList(CustomerDto dto);
    List<CustomerVo> selCommunityList(CustomerDto dto);
}
