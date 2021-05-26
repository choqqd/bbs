package com.yedam.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;
import com.yedam.common.Paging;

public class BulletinListPageing implements DbCommand {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page"); //사용자가 보고싶은 페이지 번화
		if(page == null)
			page ="1";
		int pageCnt = Integer.parseInt(page);
		
		//전체건수를 위해 실행
		BulletinServiceImpl service = new BulletinServiceImpl();
		List<BulletinVO> total = service.BulletinSelectList(); //전체 카운트

		//현재 페이지 리스트를 위해 실행
		service = new BulletinServiceImpl();
		List<BulletinVO>list = service.BulletinListPaging(pageCnt);
		
        Paging paging = new Paging();
        paging.setPageNo(pageCnt);
        paging.setPageSize(10);
        paging.setTotalCount(total.size());

        request.setAttribute("bulletinList", list);
        request.setAttribute("paging", paging);
        
		return "bulletin/bulletinListPaging.tiles";
	}
}
