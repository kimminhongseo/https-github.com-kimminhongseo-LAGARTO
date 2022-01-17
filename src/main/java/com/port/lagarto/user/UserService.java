package com.port.lagarto.user;

import com.port.lagarto.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession hs;

    public int insUser(UserEntity entity){
        return mapper.insUser(entity);
    }

    public UserEntity selUser(UserEntity entity){
        return mapper.selUser(entity);
    }

}