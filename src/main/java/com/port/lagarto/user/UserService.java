package com.port.lagarto.user;


import com.port.lagarto.Const;
import com.port.lagarto.Utils;
import com.port.lagarto.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private Utils utils;
    @Autowired
    private HttpSession hs;


    public int insUser(UserEntity entity){
        UserEntity result = null;
        try {
            result = mapper.selUser(entity);
            if (result == null){
                mapper.insUser(entity);
                result = mapper.selUser(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        hs.setAttribute(Const.LOGIN_USER, result);
        return 0;
    }

    public UserEntity selUser(UserEntity entity){
        return mapper.selUser(entity);
    }

    public int facebookIns(UserEntity entity){
        System.out.println(utils.getLoginUserPk());
        entity.setIuser(utils.getLoginUserPk());
        return mapper.facebookIns(entity);
    }
}