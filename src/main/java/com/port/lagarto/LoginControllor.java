package com.port.lagarto;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import com.port.lagarto.model.UserEntity;
import com.port.lagarto.user.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.scribejava.core.model.OAuth2AccessToken;


/*
 * Handles requests for the application home page.
 */

@Controller
public class LoginControllor {

    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;

    @Autowired
    private NaverService service;

    @Autowired
    private Utils utils;


    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    //로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, HttpSession session) {
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125

        System.out.println("네이버:" + naverAuthUrl);
//네이버
        model.addAttribute("url", naverAuthUrl);
        System.out.println("모델 : "+model);
        return "login";
    }


    //네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value = "/callback", method = {RequestMethod.GET, RequestMethod.POST})
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
        System.out.println("여기는 callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);

        //1. 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
/* apiResult json 구조
 {"resultcode":"00",
 "message":"success",
 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
 */

//2. String형식인 apiResult를 json형태로 바꿈
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;
//3. 데이터 파싱
//Top레벨 단계 _response 파싱
        JSONObject response_obj = (JSONObject) jsonObj.get("response");
//response의 nickname값 파싱


        String email = (String) response_obj.get("email");
        System.out.println(email);
        String name = (String) response_obj.get("name");
        System.out.println(name);
        //여기서 바로 service.naver?
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setEmail(email);
        service.insUser(entity);

//4.파싱 닉네임 세션으로 저장 --여기서 정보 저장하는곳임

        session.setAttribute("sessionEmail", email); //세션 생성
        session.setAttribute("sessionname",name);//세션 생성
        model.addAttribute("result", apiResult);
        System.out.println(model);
        return "redirect:http://localhost:8090/user/join"; //네이버 로그인 누르면 가는곳.
    }



    //로그아웃
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session) throws IOException {
        System.out.println("여기는 logout");
        session.invalidate(); //세션 삭제
        return "redirect:index.jsp";

    }
}



