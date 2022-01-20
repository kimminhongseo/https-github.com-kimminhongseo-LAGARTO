package com.port.lagarto;


import com.port.lagarto.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NaverMapper {
    int insUser(UserEntity entity);
    UserEntity selUser(UserEntity entity);
    int naverIns(UserEntity entity);


}
