package com.port.lagarto.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper mapper;

    public List<CustomerVo> selReviewList(CustomerDto dto) { return mapper.selReviewList(dto);}
    public List<CustomerVo> selHelpList(CustomerDto dto) { return mapper.selHelpList(dto);}
    public List<CustomerVo> selCommunityList(CustomerDto dto) { return mapper.selCommunityList(dto);}

}
