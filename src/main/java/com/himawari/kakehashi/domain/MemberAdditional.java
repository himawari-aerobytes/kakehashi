package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MemberAdditional {
    private int id;
    private int citizenId;
    private String municipality;
    private String prefecture;
    private int positionId;
    private String positionName;
    private int examinationId;
    private String examinationName;
    private int schoolId;
    private String schoolName;
    private int districtId;
    private String districtName;
    private int branchId;
    private String branchName;
    private String branchNameBystudent;
    private int headquarterId;
    private String headquarterName;
    private String headquarterNameBystudent;
    private int wardId;
    private String wardName;
    private int zoneId;
    private String zoneName;
    private String updatedby;
    private LocalDateTime updatedat;
    private String createdby;
    private LocalDateTime createdat;

}
