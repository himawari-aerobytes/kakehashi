package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: member_session
 */
@Getter
@Setter
@Builder
public class MemberSession {
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
     * Column: adm_member_id
     * Type: INT
     * Remark: adm_member_id
     */
    private Integer admMemberId;

    /**
     * Column: visitedat
     * Type: DATETIME
     * Remark: visitedat
     */
    private Date visitedat;

    /**
     * Column: type
     * Type: VARCHAR(45)
     * Remark: type
     */
    private String type;

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

    /**
     * Column: note
     * Type: LONGTEXT
     * Remark: note
     */
    private String note;
}