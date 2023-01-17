package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class LoginUserAdditional {
    private Integer id;
    private String name;
    private String email;
    private String role;
    private Integer isEnabled;
    private Integer memberId;
    private String memberName;
    private Integer districtId;
    private String districtName;
    private Integer branchId;
    private String branchName;
    private Integer headquarterId;
    private String headquarterName;
    private Integer wardId;
    private String wardName;
    private Integer zoneId;
    private String zoneName;

}
