package com.port.lagarto.user;

import com.port.lagarto.Utils;
import com.port.lagarto.enums.JoinResult;
import com.port.lagarto.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired //필요한 메소드 자동찾기
    private UserService service;

    @GetMapping("/login")
    public void login(Model model) {
        model.addAttribute("title", "로그인");
    }

    @PostMapping("/login")
    @ResponseBody
    public void loginProc(@RequestBody UserEntity entity) {
        service.insUser(entity);
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

    @GetMapping("/certification")
    public void certification() {

    }

    @ResponseBody
    @PostMapping("/certification")
    public Map<String, Integer> certificationProc(@ModelAttribute("userEntity") UserEntity entity) {
        Map<String, Integer> result = new HashMap<>();

        // 중복된 번호
        int contactCheck = 0;

        service.contactCheck(entity);
        JoinResult joinRslt = entity.getResult();

        // 사용 가능한 번호
        if (joinRslt == JoinResult.AVAILABLE_CONTACT) {
            contactCheck = 1;
        }

        result.put("result", contactCheck);
        System.out.println("result : " + contactCheck);
        return result;
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("userEntity") UserEntity entity, RedirectAttributes reAttr, Model model) {
        if (entity.getResult() == JoinResult.AVAILABLE_CONTACT) {
            model.addAttribute("title", "회원가입");
            return "/user/join";
        }
        reAttr.addFlashAttribute("err", "휴대전화 인증을 먼저 해주세요.");
        return "redirect:/user/certification";
    }

    @PostMapping("/join")
    public void joinProc(UserEntity entity) {
        System.out.println(entity.getNickname());
        service.facebookIns(entity);
    }


}

