package com.yedam.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DbCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;

public class AddCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// cart table에 1건 추가(화원 id, 상품 정보, 수량->1)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String itemCode = request.getParameter("itemCode");
		int qty = 1; // 수량

		ProductServiceImpl service = new ProductServiceImpl();
		service.addCart(id, itemCode, qty);

		ProductServiceImpl service1 = new ProductServiceImpl();
		service1.getCount(id);

		
	      return "/productList.do";
	}

}
