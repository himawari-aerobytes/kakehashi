package com.himawari.kakehashi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Table: login_user
 */
@Getter
@Setter
@Builder
public class LoginUser {
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
     * Column: role_id
     * Type: INT
     * Remark: role_id
     */
    private Integer roleId;

    /**
     * Column: login_user_name
     * Type: VARCHAR(45)
     * Remark: login_user_name
     */
    private String loginUserName;

    /**
     * Column: email
     * Type: VARCHAR(255)
     * Remark: email
     */
    private String email;

    /**
     * Column: isEnabled
     * Type: INT
     * Remark: isEnabled
     */
    private Integer isenabled;

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
}