package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.District;
import com.himawari.kakehashi.domain.DistrictExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DistrictMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DistrictExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DistrictExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("branchId") Integer branchId, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(District row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(District row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<District> selectByExample(DistrictExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    District selectByPrimaryKey(@Param("id") Integer id, @Param("branchId") Integer branchId, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") District row, @Param("example") DistrictExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") District row, @Param("example") DistrictExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(District row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(District row);
}