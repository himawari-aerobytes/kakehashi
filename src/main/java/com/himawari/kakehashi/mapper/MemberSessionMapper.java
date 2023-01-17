package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.MemberSession;
import com.himawari.kakehashi.domain.MemberSessionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberSessionMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(MemberSession row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(MemberSession row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<MemberSession> selectByExampleWithBLOBs(MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<MemberSession> selectByExample(MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    MemberSession selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") MemberSession row, @Param("example") MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleWithBLOBs(@Param("row") MemberSession row, @Param("example") MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") MemberSession row, @Param("example") MemberSessionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(MemberSession row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeyWithBLOBs(MemberSession row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(MemberSession row);
}