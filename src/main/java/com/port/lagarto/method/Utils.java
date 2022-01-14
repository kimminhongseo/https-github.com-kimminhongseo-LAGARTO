package com.port.lagarto.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class Utils {


    @Autowired
    private HttpSession session;


    //    XSS공격 접근제한 메소드
    public static String replaceStr(String str) {
        return str.replace("<", "&lt")
                .replace(">", "&gt")
                .replace(".", "&#46")
                .replace("'", "&#39");
    }


    //id 뒷자리 4번째부터 *로치환
    public static String subString(String str) {
        return str.substring(0, 4) + str.substring(4).replaceAll("\\S", "*");
    }
}

