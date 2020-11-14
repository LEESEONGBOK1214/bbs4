package com.example.bbs4.service;

import com.example.bbs4.domain.Board;
import com.example.bbs4.domain.Member;
import com.example.bbs4.domain.Reply;
import com.example.bbs4.mapper.BoardMapper;
import com.example.bbs4.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired(required = false)
    BoardMapper boardMapper;
    
    // 글작성
    public void write(Board board){
        boardMapper.write(board);
    }

    // 글목록
    public ArrayList<Board> boardList(Criteria criteria){
        return boardMapper.boardList(criteria);
    }

    // 글열람
    public Board select(long bno){
        return boardMapper.select(bno);
    }

    // 조회수
    public void count(long bno){
        boardMapper.count(bno);
    }

    // 추천수
    public void reco(long bno){
        boardMapper.reco(bno);
    }

    // 글삭제
    public void delete(long bno){
        boardMapper.delete(bno);
    }

    // 글 수정
    public void update(Board board){
        boardMapper.update(board);
    }

    // 댓글
    public void reply(Reply reply){
        boardMapper.reply(reply);
    }

    // 댓글 목록
    public ArrayList<Reply> replyList(Criteria criteria){
        return boardMapper.replyList(criteria);
    }

    // 댓글 추천
    public void up(Reply reply){
        boardMapper.up(reply);
    }

    // 댓글 비추
    public void down(Reply reply){
        boardMapper.down(reply);
    }

    // 총 게시글 수
    public int boradListCnt(){
        return boardMapper.boardListCnt();
    }

    public int replyListCnt(long bno) { return boardMapper.replyListCnt(bno); }
}
