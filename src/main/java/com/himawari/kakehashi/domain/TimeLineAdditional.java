package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TimeLineAdditional {
    private int id;
    private String zoneName;
    private String wardName;
    private String headquarterName;
    private String memberName;
    private int zoneId;
    private int wardId;
    private int headquarterId;
    private int memberId;
    private String comment;
    private String img;
    private String updatedby;
    private LocalDateTime updatedat;
    private String createdby;
    private LocalDateTime createdat;


}
