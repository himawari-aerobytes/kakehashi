package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Citizen;
import com.himawari.kakehashi.domain.CitizenExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CitizenMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CitizenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CitizenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Citizen row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Citizen row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Citizen> selectByExample(CitizenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Citizen selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Citizen row, @Param("example") CitizenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Citizen row, @Param("example") CitizenExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Citizen row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Citizen row);
}