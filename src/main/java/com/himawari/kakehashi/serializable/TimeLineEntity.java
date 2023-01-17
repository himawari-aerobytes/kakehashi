package com.himawari.kakehashi.serializable;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TimeLineEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String userName;
    private String comment;
    private String imgSrc;


}
