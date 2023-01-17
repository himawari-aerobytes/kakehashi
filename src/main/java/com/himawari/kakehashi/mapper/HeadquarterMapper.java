package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Headquarter;
import com.himawari.kakehashi.domain.HeadquarterExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HeadquarterMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(HeadquarterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(HeadquarterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Headquarter row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Headquarter row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Headquarter> selectByExample(HeadquarterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Headquarter selectByPrimaryKey(@Param("id") Integer id, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Headquarter row, @Param("example") HeadquarterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Headquarter row, @Param("example") HeadquarterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Headquarter row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Headquarter row);
}