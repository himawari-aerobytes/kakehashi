package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Timeline;
import com.himawari.kakehashi.domain.TimelineExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TimelineMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(TimelineExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(TimelineExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("memberId") Integer memberId, @Param("districtId") Integer districtId, @Param("branchId") Integer branchId, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Timeline row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Timeline row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Timeline> selectByExample(TimelineExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Timeline selectByPrimaryKey(@Param("id") Integer id, @Param("memberId") Integer memberId, @Param("districtId") Integer districtId, @Param("branchId") Integer branchId, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Timeline row, @Param("example") TimelineExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Timeline row, @Param("example") TimelineExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Timeline row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Timeline row);
}