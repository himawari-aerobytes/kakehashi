package com.himawari.kakehashi.service.common;

import com.himawari.kakehashi.domain.LoginUserAdditional;
import com.himawari.kakehashi.mapper.LoginUserAdditionalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserCommonService {
    @Autowired
    private LoginUserAdditionalMapper loginUserAdditionalMapper;

    public LoginUserAdditional getUserByLoginUserName(String email) {

        Optional<LoginUserAdditional> user = loginUserAdditionalMapper
                .selectUser(email)
                .stream()
                .findFirst();

        if (user.isEmpty()) {

            throw new BadCredentialsException("ユーザ名がデータベースに存在しません");
        }

        return user.get();
    }


}
