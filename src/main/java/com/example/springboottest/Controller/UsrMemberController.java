package com.example.springboottest.Controller;

import com.example.springboottest.Service.MemberService;
import com.example.springboottest.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UsrMemberController {
    private MemberService memberService;

    public UsrMemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/usr/member/doJoin")
    @ResponseBody
    public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphone, String email) {
        if( loginId == null || loginId.trim().length() == 0) {
            return "로그인 아이디를 입력해주세요.";
        }

        if( loginPw == null || loginPw.trim().length() == 0) {
            return "로그인 비밀번호를 입력해주세요.";
        }

        if( name == null || name.trim().length() == 0) {
            return "이름을 입력해주세요.";
        }

        if( nickname == null || nickname.trim().length() == 0) {
            return "닉네임을 입력해주세요.";
        }

        if( cellphone == null || cellphone.trim().length() == 0) {
            return "휴대전화번호를 입력해주세요.";
        }

        if( email == null || email.trim().length() == 0) {
            return "이메일을 입력해주세요.";
        }

        int id = memberService.join(loginId, loginPw, name, nickname, cellphone, email);

        if (id == -1) {
            return "이미 사용중인 로그인 아이디(" + loginId + ")입니다.";
        }

        if (id == -2) {
            return "이미 사용중인 이름(" + name + ")과 이메일(" + email + ")입니다.";
        }

        Member member = memberService.getMemberById(id);

        return member;
    }

    @RequestMapping("/usr/member/doLogout")
    @ResponseBody
    public Object doLogout(HttpSession httpSession) {
        boolean isLogined = false;

        if (httpSession.getAttribute("loginedMemberId") == null ) {
            isLogined = true;
        }

        if (isLogined) {
            return "이미 로그아웃 상태입니다.";
        }
        httpSession.removeAttribute("loginedMemberId");

        return "로그아웃 되었습니다.";
    }

    @RequestMapping("/usr/member/doLogin")
    @ResponseBody
    public Object doLogin(HttpSession httpSession, String loginId, String loginPw) {
        boolean isLogined = false;

        if (httpSession.getAttribute("loginedMemberId") != null ) {
            isLogined = true;
        }

        if (isLogined) {
            return "이미 로그인 되었습니다.";
        }

        if( loginId == null || loginId.trim().length() == 0) {
            return "로그인 아이디를 입력해주세요.";
        }

        if( loginPw == null || loginPw.trim().length() == 0) {
            return "로그인 비밀번호를 입력해주세요.";
        }

        Member member = memberService.getMemberByLoginId(loginId);

        if (member == null) {
            return "존재하지 않는 로그인 아이디입니다.";
        }

        if (member.getLoginPw().equals(loginPw) == false) {
            return "비밀번호가 일치하지 않습니다.";
        }
        httpSession.setAttribute("loginedMemberId", member.getId());

        return "("+ member.getNickname() +")님 환영합니다";
    }
}
