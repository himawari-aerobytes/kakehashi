package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: headquarter
 */
@Setter
@Getter
@Builder
public class Headquarter {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

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
     * Column: headquarter_name
     * Type: VARCHAR(123)
     * Remark: headquarter_name
     */
    private String headquarterName;

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