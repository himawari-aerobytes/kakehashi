package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Zone;
import com.himawari.kakehashi.domain.ZoneExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZoneMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ZoneExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ZoneExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Zone row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Zone row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Zone> selectByExample(ZoneExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Zone selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Zone row, @Param("example") ZoneExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Zone row, @Param("example") ZoneExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Zone row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Zone row);
}