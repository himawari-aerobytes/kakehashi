package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Ward;
import com.himawari.kakehashi.domain.WardExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WardMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WardExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WardExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Ward row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Ward row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Ward> selectByExample(WardExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Ward selectByPrimaryKey(@Param("id") Integer id, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Ward row, @Param("example") WardExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Ward row, @Param("example") WardExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Ward row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Ward row);
}