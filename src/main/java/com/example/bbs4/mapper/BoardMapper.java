package com.example.bbs4.mapper;

import com.example.bbs4.domain.Board;
import com.example.bbs4.domain.Member;
import com.example.bbs4.domain.Reply;
import com.example.bbs4.service.Criteria;

import java.util.ArrayList;

public interface BoardMapper {
    void write(Board board); // 글작성
    ArrayList<Board> boardList(Criteria criteria); // 글리스트
    Board  select(long bno); // 글 정보 ( 열람 )
    void count(long bno); // 조회수
    void reco(long bno); // 추천수
    void delete(long bno); // 글 삭제
    void update(Board board); // 글 수정
    void reply(Reply reply); // 댓글
    ArrayList<Reply> replyList(Criteria criteria); // 댓글목록
    void up(Reply reply); // 추천
    void down(Reply reply); // 비추천
    int boardListCnt(); // 총 게시글 개수
    int replyListCnt(long bno); // 게시글에 있는 총 댓글 수
}
