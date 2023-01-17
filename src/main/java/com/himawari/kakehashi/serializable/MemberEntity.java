package com.himawari.kakehashi.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MemberEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String uuid;
    private String memberName;
    private String address;
    private String grade;
    private String birthday;
    private String note;
    private String mobilePhone;
    private String phone;
    private Integer canVisit;
    private Integer citizenId;
    private Integer positionId;
    private Integer examinationId;
    private Integer schoolId;
    private Integer districtId;
    private Integer branchId;
    private Integer headquarterId;
    private Integer wardId;
    private Integer zoneId;
    private String level;
    private String email;
    private String isMakeLoginUser;

}
