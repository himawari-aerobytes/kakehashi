package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: branch
 */
@Getter
@Setter
@Builder
public class Branch {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

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
     * Column: branch_name
     * Type: VARCHAR(123)
     * Remark: branch_name
     */
    private String branchName;

    /**
     * Column: name_bystudent
     * Type: VARCHAR(45)
     * Remark: name_bystudent
     */
    private String nameBystudent;

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
     * Type: DATETIME
     * Remark: createdat
     */
    private Date createdat;

    /**
     * Column: updatedat
     * Type: DATETIME
     * Remark: updatedat
     */
    private Date updatedat;
}