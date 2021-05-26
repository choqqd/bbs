package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class bulltein implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		BulletinService service = new BulletinServiceImpl();
		BulletinVO vo = new BulletinVO();
		vo.setId(Integer.parseInt(id));
		service.BulletinSelect(vo);
		
		request.setAttribute("bulletin", vo);
		return "bulletin/bulletin.tiles";
	}

}
