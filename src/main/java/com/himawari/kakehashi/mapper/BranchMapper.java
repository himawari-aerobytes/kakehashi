package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Branch;
import com.himawari.kakehashi.domain.BranchExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BranchMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BranchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BranchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Branch row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Branch row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Branch> selectByExample(BranchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Branch selectByPrimaryKey(@Param("id") Integer id, @Param("headquarterId") Integer headquarterId, @Param("wardId") Integer wardId, @Param("zoneId") Integer zoneId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Branch row, @Param("example") BranchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Branch row, @Param("example") BranchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Branch row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Branch row);
}