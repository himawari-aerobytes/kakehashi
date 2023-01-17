package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.LoginUser;
import com.himawari.kakehashi.domain.LoginUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginUserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(LoginUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(LoginUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(LoginUser row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(LoginUser row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<LoginUser> selectByExample(LoginUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    LoginUser selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") LoginUser row, @Param("example") LoginUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") LoginUser row, @Param("example") LoginUserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(LoginUser row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(LoginUser row);
}