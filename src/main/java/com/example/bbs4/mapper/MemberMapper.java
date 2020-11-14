package com.example.bbs4.mapper;

import com.example.bbs4.domain.Member;

import java.util.ArrayList;

public interface MemberMapper {
    void join(Member member); // 회원가입
    Member login(Member member); // 로그인
    ArrayList<Member> memberList(); // 회원리스트

}
