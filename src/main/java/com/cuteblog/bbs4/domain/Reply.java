package com.cuteblog.bbs4.domain;

import lombok.Data;
import java.util.Date;

@Data
public class Reply {
    private long rno;
    private String rcontent;
    private String rwriter;
    private Date regDate;
    private int up;
    private int down;
    private int bno;
    private int mno;
}
