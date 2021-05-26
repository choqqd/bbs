package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class bulletinInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("uname");
		
		BulletinVO vo = new BulletinVO();
		vo.setWriter(writer);
		vo.setContent(content);
		vo.setTitle(title);
		
		BulletinService service = new BulletinServiceImpl();
		int r = service.insertBulletin(vo);
		String path = "";
		if(r>0) {
			path = "/bulletinListPaging.do";
		}else {
			path = "/bulletinForm.do";
		}
		
		return path;
	}

}
