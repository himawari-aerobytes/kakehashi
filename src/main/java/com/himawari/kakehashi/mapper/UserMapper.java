package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectUser(@Param("email") String email);

}
