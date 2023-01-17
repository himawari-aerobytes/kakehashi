package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.TimeLineAdditional;
import com.himawari.kakehashi.domain.Timeline;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TimelineAdditionalMapper {
    int updateByKeySelective(Timeline timeline);

    List<TimeLineAdditional> selectTimeLineZone(@Param("zoneId") int zoneId);

    List<TimeLineAdditional> selectTimeLineAll();

    List<TimeLineAdditional> selectTimeLineWard(@Param("zoneId") int zoneId, @Param("wardId") int wardId);

    List<TimeLineAdditional> selectTimeLineHeadquarter(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("headquarterId") int headquarterId);
}
