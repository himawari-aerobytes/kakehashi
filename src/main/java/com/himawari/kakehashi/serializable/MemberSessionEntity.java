package com.himawari.kakehashi.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberSessionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int memberId;
    private int admMemberId;
    private String note;
    private LocalDateTime vistedat;
    private String type;
}
