package com.yedam.product.service;

import java.util.List;

import com.yedam.notice.vo.NoticeVO;
import com.yedam.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> ProductSelectList();
	NoticeVO ProductSelect(ProductVO vo);
	int insertProduct(ProductVO vo);
	int updateProduct(ProductVO vo);
	int deleteProduct(ProductVO vo);
}
