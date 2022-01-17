package com.port.lagarto.user;

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

// <<<<<<< dyeyoung
//     @PostMapping("/login")
//     @ResponseBody
//     public void loginProc(@RequestBody UserEntity entity){
//         service.insUser(entity);
//     }

//     @GetMapping("/join")
//     public void join(Model model){
//         model.addAttribute("title", "회원가입");
//     }

// =======
// >>>>>>> master
}