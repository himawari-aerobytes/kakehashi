package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: timeline
 */
@Getter
@Setter
@Builder
public class Timeline {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

    /**
     * Column: member_id
     * Type: INT
     * Remark: member_id
     */
    private Integer memberId;

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
     * Column: comment
     * Type: VARCHAR(4000)
     * Remark: comment
     */
    private String comment;

    /**
     * Column: updatedby
     * Type: VARCHAR(123)
     * Remark: updatedby
     */
    private String updatedby;

    /**
     * Column: createdby
     * Type: VARCHAR(123)
     * Remark: createdby
     */
    private String createdby;

    /**
     * Column: createdat
     * Type: TIMESTAMP
     * Remark: createdat
     */
    private Date createdat;

    /**
     * Column: updatedat
     * Type: TIMESTAMP
     * Remark: updatedat
     */
    private Date updatedat;

    /**
     * Column: img
     * Type: VARCHAR(2083)
     * Remark: img
     */
    private String img;
}