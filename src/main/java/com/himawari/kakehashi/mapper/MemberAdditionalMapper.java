package com.himawari.kakehashi.mapper;

import com.himawari.kakehashi.domain.MemberAdditional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberAdditionalMapper {
    List<MemberAdditional> selectMemberAll();

    List<MemberAdditional> selectMemberZone(@Param("zoneId") int zoneId);

    List<MemberAdditional> selectMemberWard(@Param("zoneId") int zoneId, @Param("wardId") int wardId);

    List<MemberAdditional> selectMemberHeadquarter(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("headquarterId") int headquarterId);

    List<MemberAdditional> selectMemberAllById(@Param("memberId") int memberId);

    List<MemberAdditional> selectMemberZoneById(@Param("zoneId") int zoneId, @Param("memberId") int memberId);

    List<MemberAdditional> selectMemberWardById(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("memberId") int memberId);

    List<MemberAdditional> selectMemberHeadquarterById(@Param("zoneId") int zoneId, @Param("wardId") int wardId, @Param("headquarterId") int headquarterId, @Param("memberId") int memberId);


}
