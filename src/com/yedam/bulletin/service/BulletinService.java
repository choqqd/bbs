package com.yedam.bulletin.service;

import java.util.List;

import com.yedam.bulletin.vo.BulletinVO;

public interface BulletinService {
	List<BulletinVO> BulletinSelectList();
	BulletinVO BulletinSelect(BulletinVO vo);
	public int insertBulletin(BulletinVO vo);
	public int updateBulletin(BulletinVO vo);
	public int deleteBulletin(BulletinVO vo);
}
