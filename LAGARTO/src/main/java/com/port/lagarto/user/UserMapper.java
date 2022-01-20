package com.port.lagarto.user;

import com.port.lagarto.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    int selContactCount(UserEntity entity);
    int selUidCount(UserEntity entity);
    UserEntity selUser(UserEntity entity);
    int facebookIns(UserEntity entity);
}
