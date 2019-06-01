package itc.hoseo.cppe.reboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReBoardRepository {
	
	@Autowired
	JdbcTemplate template;
	
    public boolean insertArticle(ReBoard article) {
    	return template.update("insert into reBoard(boardNum, reName, " + "reDate, reContent) values(?,?,now(),?)",
    			article.getBoardNum() , article.getReName() , article.getReContent()) == 1 
    			? true : false;
    }
    
    
    
    
    
    
	public int getArticleCount(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from re_board where board_num = ?");
			pstmt.setInt(1, board_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	public List<ReBoard> getArticles(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReBoard> articleList = null;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement(
					"select re_num, board_num, re_name, re_date, re_content from re_board where board_num = ? order by re_date");
			pstmt.setInt(1, board_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<ReBoard>();
				do {
					ReBoard article = new ReBoard();
					article.setReNum(rs.getInt("re_num"));
					article.setBoardNum(rs.getInt("board_num"));
					article.setReName(rs.getString("re_name"));
					article.setReDate(rs.getTimestamp("re_date"));
					article.setReContent(rs.getString("re_content"));

					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return articleList;
	}

	public void deleteList(int re_num, int board_num) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			 conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("delete from  re_board where re_num=? and board_num=?");
			pstmt.setInt(1, re_num);
			pstmt.setInt(2, board_num);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
}
