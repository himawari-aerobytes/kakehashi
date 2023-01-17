package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.MemberSessionAdditional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberSessionAdditionalMapper {
    List<MemberSessionAdditional> selectMemberSessionAll();

    List<MemberSessionAdditional> selectMemberSessionHeadquarter(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("headquarterId") int headquarterId);

    List<MemberSessionAdditional> selectMemberSessionWard(@Param("zoneId") int zoneId, @Param("wardId") int wardId);

    List<MemberSessionAdditional> selectMemberSessionZone(@Param("zoneId") int zoneId);

    List<MemberSessionAdditional> selectMemberSessionAllByMemberId(@Param("memberId") int memberId);

    List<MemberSessionAdditional> selectMemberSessionHeadquarterByMemberId(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("headquarterId") int headquarterId, @Param("memberId") int memberId);

    List<MemberSessionAdditional> selectMemberSessionWardByMemberId(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("memberId") int memberId);

    List<MemberSessionAdditional> selectMemberSessionZoneByMemberId(@Param("zoneId") int zoneId, @Param("memberId") int memberId);


}
