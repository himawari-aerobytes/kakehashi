package com.himawari.kakehashi.service.account;

import com.himawari.kakehashi.domain.LoginUserExample;
import com.himawari.kakehashi.domain.SimpleLoginUser;
import com.himawari.kakehashi.mapper.LoginUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimpleUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginUserMapper loginUserMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("ログイン処理:[{}]", email);
        LoginUserExample example = new LoginUserExample();
        example
                .createCriteria()
                .andEmailEqualTo(email);

        return loginUserMapper
                .selectByExample(example)
                .stream()
                .map(u -> new SimpleLoginUser(u.getLoginUserName(), null, null))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("ユーザが見つかりません:[" + email + "]"));
    }
}
