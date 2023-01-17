package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Role;
import com.himawari.kakehashi.domain.RoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(RoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(RoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Role row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Role row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Role row, @Param("example") RoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Role row, @Param("example") RoleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Role row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Role row);
}