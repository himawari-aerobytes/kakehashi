package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: district
 */
@Getter
@Setter
@Builder
public class District {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

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
     * Column: district_name
     * Type: VARCHAR(123)
     * Remark: district_name
     */
    private String districtName;

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
     * Column: updatedat
     * Type: DATETIME
     * Remark: updatedat
     */
    private Date updatedat;

    /**
     * Column: createdat
     * Type: DATETIME
     * Remark: createdat
     */
    private Date createdat;
}