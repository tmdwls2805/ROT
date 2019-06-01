package itc.hoseo.cppe.free;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FreeRepository {
	public void insertArticle(Free article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getReStep();
		int re_level = article.getReLevel();
		int number = 0;
		String sql = "";

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select max(num) from freeBoard");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			if (num != 0) {
				sql = "update freeBoard set reStep = reStep+1 ";
				sql += "where ref= ? and reStep> ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			sql = "insert into freeBoard(writer,email,subject,passwd,regDate,";
			sql += "ref,reStep,reLevel,content,ip,file) values(?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getRegDate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			pstmt.setString(11, article.getFile());
			pstmt.executeUpdate();
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
	}

	public int getArticleCount(String category, String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int x = 0;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();
			if (keyword == null) {
				sql = "select count(*) from freeBoard";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			} else {
				sql = "select count(*) from freeBoard where " + category + " like '%" + keyword + "%'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}

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

	public List<Free> getArticles(int start, int end, String category, String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Free> articleList = null;
		String sql = null;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();
			if (keyword == null) {

				sql = "select * from freeBoard order by ref desc, reStep asc limit ?,? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start - 1);
				pstmt.setInt(2, end);

			} else {

				sql = "select * from freeBoard where " + category + " like '%" + keyword + "%'";
				sql = sql + " order by num desc";

				pstmt = conn.prepareStatement(sql);

			}
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList<Free>(end);
				do {
					Free article = new Free();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPasswd(rs.getString("passwd"));
					article.setRegDate(rs.getTimestamp("regDate"));
					article.setReadCount(rs.getInt("readCount"));
					article.setRef(rs.getInt("ref"));
					article.setReStep(rs.getInt("reStep"));
					article.setReLevel(rs.getInt("reLevel"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));

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

	public Free getArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Free article = null;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("update freeBoard set readCount=readCount+1 where num = ?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from freeBoard where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new Free();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setRegDate(rs.getTimestamp("regDate"));
				article.setReadCount(rs.getInt("readCount"));
				article.setRef(rs.getInt("ref"));
				article.setReStep(rs.getInt("reStep"));
				article.setReLevel(rs.getInt("reLevel"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
				article.setFile(rs.getString("file"));
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
		return article;
	}

	public Free updateGetArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Free article = null;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select * from freeBoard where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new Free();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setRegDate(rs.getTimestamp("regDate"));
				article.setReadCount(rs.getInt("readCount"));
				article.setRef(rs.getInt("ref"));
				article.setReStep(rs.getInt("reStep"));
				article.setReLevel(rs.getInt("reLevel"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
				article.setFile(rs.getString("file"));
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
		return article;
	}

	public int updateArticle(Free article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpasswd = "";
		String sql = "";
		int x = -1;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select passwd from freeBoard where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("passwd");
				if (dbpasswd.equals(article.getPasswd())) {
					sql = "update freeBoard set writer=?,email=?,subject=?,passwd=?";
					sql += ",content=?, file=? where num=?";
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getPasswd());
					pstmt.setString(5, article.getContent());
					pstmt.setString(6, article.getFile());
					pstmt.setInt(7, article.getNum());
					pstmt.executeUpdate();
					x = 1;
				} else {
					x = 0;
				}
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

	@SuppressWarnings("resource")
	public int deleteArticle(int num, String passwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select passwd from freeBoard where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("passwd");
				if (dbpasswd.equals(passwd)) {
					pstmt = conn.prepareStatement("delete from freeBoard where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x = 1;
				} else
					x = 0;
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

	public Free deleteGetArticle(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Free article = null;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select * from freeBoard where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new Free();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setRegDate(rs.getTimestamp("regDate"));
				article.setReadCount(rs.getInt("readCount"));
				article.setRef(rs.getInt("ref"));
				article.setReStep(rs.getInt("reStep"));
				article.setReLevel(rs.getInt("reLevel"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
				article.setFile(rs.getString("file"));
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
		return article;
	}

}
