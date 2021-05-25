package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.Impl.NoticeServiceImpl;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.vo.NoticeVO;

public class NoticeDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("did");
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		NoticeService service = new NoticeServiceImpl();
		
		int r = service.deleteNotice(vo);
		String path = "";
		
		if(r>0) {
			path = "/noticeListPaging.do";
		}else {
			path = "/notice.do";
		}
		
		return path;
	}

}
