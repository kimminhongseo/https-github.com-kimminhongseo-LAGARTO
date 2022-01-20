package com.port.lagarto.customer;

import com.port.lagarto.Utils;
import com.port.lagarto.model.CustomerDto;
import com.port.lagarto.model.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper mapper;

    @Autowired
    private Utils utils;

    public List<CustomerVo> selList(CustomerDto dto) { return mapper.selList(dto); }
}
