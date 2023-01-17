package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.School;
import com.himawari.kakehashi.domain.SchoolExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchoolMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(SchoolExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(SchoolExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(School row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(School row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<School> selectByExample(SchoolExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    School selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") School row, @Param("example") SchoolExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") School row, @Param("example") SchoolExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(School row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(School row);
}