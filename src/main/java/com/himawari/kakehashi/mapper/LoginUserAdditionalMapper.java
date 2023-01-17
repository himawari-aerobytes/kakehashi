package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.LoginUserAdditional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginUserAdditionalMapper {

    List<LoginUserAdditional> selectUser(@Param("email") String email);

    int updateRole(@Param("role_name") String roleName, @Param("email") String email);

}
