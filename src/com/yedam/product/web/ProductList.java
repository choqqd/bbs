package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.yedam.common.DbCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.ProductSelectList();
		
		ProductServiceImpl service1 = new ProductServiceImpl();
		int cartCnt = service1.getCount(id);
		
		request.setAttribute("cartCnt", cartCnt);
		request.setAttribute("list", list);
		
		
		return "product/productList.tiles";
	}

}
