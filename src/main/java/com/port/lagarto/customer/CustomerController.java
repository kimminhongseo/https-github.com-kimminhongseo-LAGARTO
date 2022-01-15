package com.port.lagarto.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/review")
    public void review(CustomerDto dto, Model model) { model.addAttribute("list", service.selReviewList(dto)); }

    @GetMapping("/help")
    public void help(CustomerDto dto, Model model) { model.addAttribute("list", service.selHelpList(dto)); }

    @GetMapping("/community")
    public void Community(CustomerDto dto, Model model) { model.addAttribute("list", service.selCommunityList(dto)); }


}
