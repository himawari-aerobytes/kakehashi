package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: role
 */
@Getter
@Setter
@Builder
public class Role {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

    /**
     * Column: role_name
     * Type: VARCHAR(45)
     * Remark: role_name
     */
    private String roleName;

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