package com.himawari.kakehashi.service.manage;

import com.himawari.kakehashi.domain.School;
import com.himawari.kakehashi.domain.SchoolExample;
import com.himawari.kakehashi.exception.ServiceError;
import com.himawari.kakehashi.interfaces.AdminServiceInterface;
import com.himawari.kakehashi.interfaces.UserInfoDomainInterface;
import com.himawari.kakehashi.mapper.SchoolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.himawari.kakehashi.constants.ErrorCode.ARGS_ERR;
import static com.himawari.kakehashi.constants.ErrorCode.RET_CODE_SUCCESS;

@Service
@Slf4j
public class SchoolAdminService implements AdminServiceInterface {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    @Transactional
    public int register(UserInfoDomainInterface user) {
        //　引数チェック
        if (!(user instanceof School)) {
            throw new IllegalArgumentException(ARGS_ERR);
        }

        try {
            final School school = (School) user;
            schoolMapper.insertSelective(school);

        } catch (Exception e) {
            throw new ServiceError(e);
        }
        return RET_CODE_SUCCESS;
    }

    @Override
    public List<School> index(UserInfoDomainInterface user) {
        if (!(user instanceof School)) {
            throw new IllegalArgumentException(ARGS_ERR);
        }

        try {
            final School school = (School) user;
            SchoolExample example = new SchoolExample();

            if (school.getId() != null) {
                example
                        .createCriteria()
                        .andIdEqualTo(school.getId());

            } else {
                example
                        .createCriteria()
                        .andSchoolNameEqualTo(school.getSchoolName());

            }


            return schoolMapper.selectByExample(example);

        } catch (Exception e) {
            throw new ServiceError(e);
        }
    }

    @Override
    @Transactional
    public int delete(int id) {
        try {
            schoolMapper.deleteByPrimaryKey(id);
            return RET_CODE_SUCCESS;
        } catch (Exception e) {
            throw new ServiceError(e);
        }
    }

    @Override
    @Transactional
    public int update(UserInfoDomainInterface user) {
        if (!(user instanceof School)) {
            throw new IllegalArgumentException(ARGS_ERR);
        }

        try {
            final School school = (School) user;

            if (school.getId() != null) {
                schoolMapper.updateByPrimaryKeySelective(school);
            }
            return RET_CODE_SUCCESS;

        } catch (Exception e) {
            throw new ServiceError(e);
        }
    }
}
