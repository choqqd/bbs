package com.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DbCommand;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberLogin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//id,pwd -> member테이블에서 체크 -> 결과 return
		//회원이면 이름을 화면에 출력
		HttpSession session = request.getSession();
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);

		MemberServiceImpl service = new MemberServiceImpl();
		MemberVO rvo = service.loginCheck(vo);
		String path="";
		if(rvo == null) {
			//회원이 존재하지 않음 -> memberloginFail.jsp
			path = "member/memberloginFail.tiles";
		}else {
			//로그인 처리 -> memberloginSuccess.jsp
			session.setAttribute("id", rvo.getId());
			session.setAttribute("uname", rvo.getName());
			request.setAttribute("vo", rvo);
			path = "member/memberloginSuccess.tiles";
		}
		
		return path;
	}

}
