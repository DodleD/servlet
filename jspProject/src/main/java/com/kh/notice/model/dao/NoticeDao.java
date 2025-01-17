package com.kh.notice.model.dao;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.model.vo.Notice;
import static com.kh.common.JDBCTemplate.*;
public class NoticeDao {
	private Properties prop = new Properties();
	
	public NoticeDao() {
		//이 경로 가서 실제 물리적 경로 가져와라
		String filePath = NoticeDao.class.getResource("/db/sql/notice-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn){
		//select -> ResultSete(여러행) -> ArrayList<Notice>
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			// rset.next() 다음객체에 값이 있는지 없는지 알 수 있음
			while(rset.next()) {
				list.add(new Notice(
					rset.getInt("notice_no"),
					rset.getString("notice_title"),
					rset.getString("user_id"),
					rset.getInt("count"),
					rset.getDate("create_date")
				));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertNotice(Connection conn, Notice n) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice"); //미완성
		
		try {
			pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, n.getNoticeTitle());
				pstmt.setString(2, n.getNoticeContent());
				pstmt.setInt(3, Integer.parseInt(n.getNoticeWriter()));
				
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int increaseCount(Connection conn, int noticeNo) {
		//수정은 업데이트문 날리기 update -> 처리된 행의 수
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Notice selectNotice(Connection conn, int noticeNo){
		//select -> ResultSete(여러행) -> ArrayList<Notice>
		Notice n = null;		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				n = new Notice(
						rset.getInt("notice_no"),
						rset.getString("notice_title"),
						rset.getString("notice_content"),
						rset.getString("user_id"),
						rset.getDate("create_date")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}
	
	//insert, update, delete는 트랜젝션 처리 해줘야함
	public int updateNotice(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {	
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	
	}
	

}
