package com.port.lagarto.user;

import com.port.lagarto.Utils;
import com.port.lagarto.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired //필요한 메소드 자동찾기
    private UserService service;

    @GetMapping("/login")
    public void login(Model model){
        model.addAttribute("title", "로그인");
    }



     @PostMapping("/login")
     @ResponseBody
     public int loginProc(@RequestBody UserEntity entity){
        UserEntity dbentity = service.selUser(entity);
        if (dbentity == null){
            service.insUser(entity);
            return 1;
        }
         Utils.randomPw();
         return 0;
     }

     @GetMapping("/join")
     public void join(Model model){
         model.addAttribute("title", "회원가입");
     }

    @PostMapping("/join")
    public void joinProc(UserEntity entity){
        System.out.println(entity.getNickname());
        service.facebookIns(entity);
    }

}