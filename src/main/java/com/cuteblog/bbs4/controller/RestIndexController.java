package com.cuteblog.bbs4.controller;

import com.cuteblog.bbs4.domain.Board;
import com.cuteblog.bbs4.domain.Email;
import com.cuteblog.bbs4.domain.Member;
import com.cuteblog.bbs4.service.*;
import com.cuteblog.bbs4.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class RestIndexController {
    // 데이터 처리할 때만 불려짐

    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;
    @Autowired
    EmailService emailService;

    // 회원가입
    @PostMapping("/rest/join")
    public void join(Member member){
        memberService.join(member);
//        System.out.println("restController join() : " + );
    }

    // 로그인
    @PostMapping("/rest/login")
    public Member login(Member member, HttpSession httpSession){
        System.out.println("restController login() : " + member.toString());
        System.out.println("restController login() return : " + memberService.login(member));
        httpSession.setAttribute("user", memberService.login(member));
        return memberService.login(member);
    }

    // 글작성
    @PostMapping("/rest/write")
    public void write(Board board){
        System.out.println("restController write() : " + board.toString());
        boardService.write(board);
    }


    // 추천눌름
    @PutMapping("/rest/reco")
    public void write(long bno){
//        System.out.println("???");
        boardService.reco(bno);
    }

    // 글삭제
    @DeleteMapping("/rest/boardDelete")
    public void boardDelete(long bno){
        boardService.boardDelete(bno);
    }

    // 글 수정
    @PutMapping("/rest/update")
    public void update(Board board){
        boardService.update(board);
    }

    // 댓글
    @PostMapping("/rest/reply")
    public void reply(Reply reply){
        boardService.reply(reply);
    }

    // 댓글 추천
    @PutMapping("/rest/up")
    public void up(Reply reply){
        boardService.up(reply);
    }

    // 댓글 비추
    @PutMapping("/rest/down")
    public void down(Reply reply){
        boardService.down(reply);
    }

    //메일 전송
    @PostMapping("/rest/email")
    public void sendEmail(Email email) throws Exception{
        emailService.sendSimpleMessage(email.getUserEmail());
    }

    // 인증 코드 확인
    @PostMapping("/rest/confirm")
    public int confirm(Email email) {
        if(EmailService.ePw.equals(email.getConfirm())){
            return EmailService.CONFIRM;
        }else{
            return EmailService.REJECT;
        }

    }

    // 유저삭제
    @GetMapping("/rest/memberDelete/{mno}")
    public String memberDelete(@PathVariable long mno){
        System.out.println(mno);
        memberService.memberDelete(mno);
        return "redirect:/memberList";
    }

}
