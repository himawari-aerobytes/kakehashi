package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MemberSessionAdditional {
    private int id;
    private int memberId;
    private String note;
    private LocalDateTime visitedat;
    private String type;
    private String memberName;
    private String memberZoneName;
    private int memberZoneId;
    private String memberWardName;
    private int memberWardId;
    private String memberHeadquarterName;
    private String memberHeadquarternameBystudent;
    private int headquarterId;
    private String memberBranchName;
    private String memberBranchNameBystudent;
    private int memberBranchId;
    private String admMemberName;
    private int admMemberId;
    private LocalDateTime createdat;
    private String createdby;
    private LocalDateTime updatedat;
    private String updatedby;

}
