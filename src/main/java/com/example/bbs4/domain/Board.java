package com.example.bbs4.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private long bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int count;
    private int reco;
    private long mno;
}
