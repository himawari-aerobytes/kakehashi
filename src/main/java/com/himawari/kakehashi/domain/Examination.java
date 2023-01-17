package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: examination
 */
@Getter
@Setter
@Builder
public class Examination {
    /**
     * Column: id
     * Type: INT
     * Remark: id
     */
    private Integer id;

    /**
     * Column: examination_name
     * Type: VARCHAR(123)
     * Remark: examination_name
     */
    private String examinationName;

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