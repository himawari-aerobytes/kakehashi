package com.himawari.kakehashi.interfaces;

import com.himawari.kakehashi.domain.School;

import java.util.List;

public interface AdminServiceInterface {

    int register(UserInfoDomainInterface user);

    List<School> index(UserInfoDomainInterface user);

    int delete(int id);

    int update(UserInfoDomainInterface user);
}
