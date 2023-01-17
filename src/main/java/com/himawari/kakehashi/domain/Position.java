package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: position
 */
@Getter
@Setter
@Builder
public class Position {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

    /**
     * Column: position_name
     * Type: VARCHAR(123)
     * Remark: position_name
     */
    private String positionName;

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