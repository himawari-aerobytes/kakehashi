package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    private int id;
    private String name;
    private String email;
    private String role;
    // enabled:1, disabled:0
    private int memberId;
    private int districtId;
    private int branchId;
    private int headquarterId;
    private int wardId;
    private int zoneId;
    private int isEnabled;

}
