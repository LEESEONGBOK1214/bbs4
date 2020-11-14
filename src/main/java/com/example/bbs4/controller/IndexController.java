package com.example.bbs4.controller;

import com.example.bbs4.domain.Member;
import com.example.bbs4.service.BoardService;
import com.example.bbs4.service.Criteria;
import com.example.bbs4.service.MemberService;
import com.example.bbs4.service.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;

@Controller
public class IndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;


    @GetMapping("/")
    public String index(Model model, Criteria criteria, @RequestParam(defaultValue = "1") int page){
        Pagination pagination = new Pagination(boardService.boradListCnt(), page, 10);
        criteria.setPage(pagination.getPage());
        model.addAttribute("pagination", pagination);
        model.addAttribute("boardList", boardService.boardList(criteria));

        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/memberList")
    public String MemberList(Model model){
        model.addAttribute("memberList", memberService.memberList());
        return "memberList";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }


    @GetMapping("/select/{bno}")
    public String select(Model model, @PathVariable long bno, Criteria criteria, @RequestParam(defaultValue = "1") int page){
        System.out.println("select bno : " + bno);
        Pagination pagination = new Pagination(boardService.replyListCnt(bno), page, 5);
        criteria.setBno(bno);
        criteria.setPage(pagination.getPage());
        criteria.setPerPageNum(pagination.getPageSize());
        boardService.count(bno);
        model.addAttribute("pagination", pagination);
        model.addAttribute("select", boardService.select(bno));
        model.addAttribute("replyList", boardService.replyList(criteria));
        return "select";
    }

    @GetMapping("/update/{bno}")
    public String update(Model model, @PathVariable long bno) {
        model.addAttribute("select", boardService.select(bno));
        return "update";
    }

}
