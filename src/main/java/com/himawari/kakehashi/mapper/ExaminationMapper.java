package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.Examination;
import com.himawari.kakehashi.domain.ExaminationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ExaminationExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ExaminationExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Examination row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Examination row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Examination> selectByExample(ExaminationExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Examination selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Examination row, @Param("example") ExaminationExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Examination row, @Param("example") ExaminationExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Examination row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Examination row);
}