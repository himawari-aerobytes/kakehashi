package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Position;
import com.himawari.kakehashi.domain.PositionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PositionMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(PositionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(PositionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Position row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Position row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Position> selectByExample(PositionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Position selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Position row, @Param("example") PositionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Position row, @Param("example") PositionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Position row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Position row);
}