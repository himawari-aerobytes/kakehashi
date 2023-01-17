package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: member
 */
@Getter
@Setter
@Builder
public class Member {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

    /**
     * Column: district_id
     * Type: INT
     * Remark: district_id
     */
    private Integer districtId;

    /**
     * Column: branch_id
     * Type: INT
     * Remark: branch_id
     */
    private Integer branchId;

    /**
     * Column: headquarter_id
     * Type: INT
     * Remark: headquarter_id
     */
    private Integer headquarterId;

    /**
     * Column: ward_id
     * Type: INT
     * Remark: ward_id
     */
    private Integer wardId;

    /**
     * Column: zone_id
     * Type: INT
     * Remark: zone_id
     */
    private Integer zoneId;

    /**
     * Column: uuid
     * Type: VARCHAR(32)
     * Remark: uuid
     */
    private String uuid;

    /**
     * Column: member_name
     * Type: VARCHAR(45)
     * Remark: member_name
     */
    private String memberName;

    /**
     * Column: address
     * Type: VARCHAR(45)
     * Remark: address
     */
    private String address;

    /**
     * Column: grade
     * Type: VARCHAR(45)
     * Remark: grade
     */
    private String grade;

    /**
     * Column: birthday
     * Type: VARCHAR(8)
     * Remark: birthday
     */
    private String birthday;

    /**
     * Column: note
     * Type: VARCHAR(1024)
     * Remark: note
     */
    private String note;

    /**
     * Column: mobile_phone
     * Type: VARCHAR(13)
     * Remark: mobile_phone
     */
    private String mobilePhone;

    /**
     * Column: phone
     * Type: VARCHAR(13)
     * Remark: phone
     */
    private String phone;

    /**
     * Column: can_visit
     * Type: TINYINT(3)
     * Remark: can_visit
     */
    private Byte canVisit;

    /**
     * Column: citizen_id
     * Type: INT
     * Remark: citizen_id
     */
    private Integer citizenId;

    /**
     * Column: position_id
     * Type: INT
     * Remark: position_id
     */
    private Integer positionId;

    /**
     * Column: examination_id
     * Type: INT
     * Remark: examination_id
     */
    private Integer examinationId;

    /**
     * Column: school_id
     * Type: INT
     * Remark: school_id
     */
    private Integer schoolId;

    /**
     * Column: createdat
     * Type: DATETIME
     * Remark: createdat
     */
    private Date createdat;

    /**
     * Column: createdby
     * Type: VARCHAR(123)
     * Remark: createdby
     */
    private String createdby;

    /**
     * Column: updatedat
     * Type: DATETIME
     * Remark: updatedat
     */
    private Date updatedat;

    /**
     * Column: updatedby
     * Type: VARCHAR(123)
     * Remark: updatedby
     */
    private String updatedby;
}