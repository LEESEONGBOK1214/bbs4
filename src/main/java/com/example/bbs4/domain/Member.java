package com.example.bbs4.domain;

import lombok.Data;
import java.util.Date;

@Data
public class Member {
    private long mno;
    private String id;
    private String password;
    private String name;
    private String type;
    private Date regDate;
}
