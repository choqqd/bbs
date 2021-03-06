package com.yedam.notice.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService{
	PreparedStatement psmt;
	ResultSet rs;
	
	public List<NoticeVO> noticeListPaging(int page){
		String sql = "select b.*\r\n"//
				+ "from(select rownum m, a.*\r\n"//
				+ "      from (select * from notice n order by n.id)a) b\r\n"//
				+ "where b.m between ? and ?";//
		List<NoticeVO> list = new ArrayList<>();
		int firstCnt =0, lastCnt = 0;
		firstCnt = (page-1)*10 +1; // 1
		lastCnt = (page * 10); //10
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	
	//전체 리스트
	@Override
	public List<NoticeVO> noticeSelectList() {
		String sql = "select * from notice order by 1";
		List<NoticeVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setHit(rs.getInt("hit"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	
	//한건 조회
	@Override
	public NoticeVO noticeSelect(int id) {
		String sql = "select * from notice where id = ?";
		NoticeVO rvo = null; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				rvo = new NoticeVO();
				rvo.setId(rs.getInt("id"));
				rvo.setTitle(rs.getString("title"));
				rvo.setContent(rs.getString("content"));
				rvo.setRegDate(rs.getDate("reg_date"));
				rvo.setHit(rs.getInt("hit"));
				hitCount(rvo.getId()); // 조회수 증가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return rvo;
	}

	
	//한건입력
	@Override
	public int insertNotice(NoticeVO vo) {
		String sql = "insert into notice(id, title, content, reg_date, hit) values(notice_seq.nextval,?,?,sysdate,0)";
		int r=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}

	
	//한건 수정
	@Override
	public int updateNotice(NoticeVO vo) {
		String sql = "update notice set title = ?, content = ? where id = ?";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	
	//한건 삭제
	@Override
	public int deleteNotice(NoticeVO vo) {
		String sql = "delete from notice where id=?";
		int r=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			
			r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void hitCount(int id) {
		String sql="update notice set hit = hit+1 where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void close() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
