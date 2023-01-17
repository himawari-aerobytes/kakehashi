package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Member;
import com.himawari.kakehashi.domain.MemberExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(MemberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(MemberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("districtId") Integer districtId, @Param("branchId") Integer branchId, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Member row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Member row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Member> selectByExample(MemberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Member selectByPrimaryKey(@Param("id") Integer id, @Param("districtId") Integer districtId, @Param("branchId") Integer branchId, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Member row, @Param("example") MemberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Member row, @Param("example") MemberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Member row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Member row);
}