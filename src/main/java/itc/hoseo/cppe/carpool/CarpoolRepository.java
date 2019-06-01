package itc.hoseo.cppe.carpool;

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
public class CarpoolRepository {

	@Autowired
	JdbcTemplate template;
	
    public boolean insertCarpool(Carpool CPPE) {
    	return template.update("insert into carpool(userId, purpose, SPoint, DPoint, WPoint, date,amPm, hour, minute, personNum, price, smoking, content, choice, insurance,userName,regdate) "
    			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate())",
    			CPPE.getUserId() , CPPE.getPurpose() , CPPE.getSPoint() , CPPE.getDPoint(), CPPE.getWPoint()
    			, CPPE.getDate(), CPPE.getAmPm(), CPPE.getHour(), CPPE.getMinute(), CPPE.getPersonNum(), CPPE.getPrice()
    			, CPPE.getSmoking(), CPPE.getContent(), CPPE.getChoice(), CPPE.getInsurance(), CPPE.getUserName()) == 1 
    			? true : false;
    }
    
    
    
    
	public int getCarpoolCount(String category, String keyword) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		int x = 0;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();
			if (keyword == null) {
				sql = "select count(*) from carpool";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				// �쟾泥� 寃뚯떆湲��쓽 媛쒖닔
			} else {
				sql = "select count(*) from carpool where " + category + " like '%" + keyword + "%'";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				// 寃��깋 寃뚯떆湲��쓽 媛쒖닔
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

	public List<Carpool> getCarpoolList(int start, int end, String category, String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Carpool> carpoolList = null;
		String sql = null;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();
			if (keyword == null) {
				sql = "select * from carpool order by regdate desc limit ?,? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start - 1);
				pstmt.setInt(2, end);
			} else {
				sql = "select * from carpool where " + category + " like '%" + keyword + "%'";
				sql = sql + " order by regdate desc";
			}
			rs = pstmt.executeQuery();

			if (rs.next()) {
				carpoolList = new ArrayList<Carpool>(end);
				do {
					Carpool carpool = new Carpool();
					carpool.setCarpoolId(rs.getInt("carpoolId"));
					carpool.setUserId(rs.getString("userId"));
					carpool.setChoice(rs.getString("choice"));
					carpool.setPurpose(rs.getString("purpose"));
					carpool.setSPoint(rs.getString("SPoint"));
					carpool.setDPoint(rs.getString("DPoint"));
					carpool.setWPoint(rs.getString("WPoint"));
					carpool.setDate(rs.getString("date"));
					carpool.setAmPm(rs.getString("amPm"));
					carpool.setHour(rs.getInt("hour"));
					carpool.setMinute(rs.getInt("minute"));
					carpool.setPersonNum(rs.getInt("personNum"));
					carpool.setPrice(rs.getInt("price"));
					carpool.setInsurance(rs.getString("insurance"));
					carpool.setSmoking(rs.getString("smoking"));
					carpool.setContent(rs.getString("content"));
					carpool.setUserName(rs.getString("userName"));
					carpool.setRegdate(rs.getTimestamp("regdate"));
					// list.jsp �엳�뒗 媛믪쓣 �꽕�젙
					carpoolList.add(carpool);
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
		return carpoolList;
	}

	public int getCarpoolCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//            conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from carpool");
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
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

	public List<Carpool> getCarpoolList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Carpool carpool = null;
		String sql = "";
		List<Carpool> lists = null;

		try {
//       	 conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "select * from carpool order by regdate desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Carpool>();

			while (rs.next()) {
				carpool = new Carpool();
				carpool.setCarpoolId(rs.getInt("carpoolId"));
				carpool.setUserId(rs.getString("userId"));
				carpool.setChoice(rs.getString("choice"));
				carpool.setPurpose(rs.getString("purpose"));
				carpool.setSPoint(rs.getString("SPoint"));
				carpool.setDPoint(rs.getString("DPoint"));
				carpool.setWPoint(rs.getString("WPoint"));
				carpool.setDate(rs.getString("date"));
				carpool.setAmPm(rs.getString("amPm"));
				carpool.setHour(rs.getInt("hour"));
				carpool.setMinute(rs.getInt("minute"));
				carpool.setPersonNum(rs.getInt("personNum"));
				carpool.setPrice(rs.getInt("price"));
				carpool.setInsurance(rs.getString("insurance"));
				carpool.setSmoking(rs.getString("smoking"));
				carpool.setContent(rs.getString("content"));
				carpool.setUserName(rs.getString("userName"));
				carpool.setRegdate(rs.getTimestamp("regdate"));
				lists.add(carpool);
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
		return lists;
	}

	public int getListCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//            conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from carpool where userId=?");
			pstmt.setString(1, id);
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

	public List<Carpool> getCarpoolList(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Carpool carpool = null;
		String sql = "";
		List<Carpool> lists = null;

		try {
//       	    conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "select * from carpool where userId = ? order by regdate desc";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Carpool>();

			while (rs.next()) {
				carpool = new Carpool();
				carpool.setCarpoolId(rs.getInt("carpoolId"));
				carpool.setUserId(rs.getString("userId"));
				carpool.setChoice(rs.getString("choice"));
				carpool.setPurpose(rs.getString("purpose"));
				carpool.setSPoint(rs.getString("SPoint"));
				carpool.setDPoint(rs.getString("DPoint"));
				carpool.setWPoint(rs.getString("WPoint"));
				carpool.setDate(rs.getString("date"));
				carpool.setAmPm(rs.getString("amPm"));
				carpool.setHour(rs.getInt("hour"));
				carpool.setMinute(rs.getInt("minute"));
				carpool.setPersonNum(rs.getInt("personNum"));
				carpool.setPrice(rs.getInt("price"));
				carpool.setInsurance(rs.getString("insurance"));
				carpool.setSmoking(rs.getString("smoking"));
				carpool.setContent(rs.getString("content"));
				carpool.setUserName(rs.getString("userName"));
				carpool.setRegdate(rs.getTimestamp("regdate"));
				lists.add(carpool);
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
		return lists;
	}

	public Carpool getCarpool(int carpoolId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Carpool carpool = null;
		try {
//            conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select * from carpool where carpoolId = ?");
			pstmt.setInt(1, carpoolId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				carpool = new Carpool();
				carpool.setCarpoolId(rs.getInt("carpoolId"));
				carpool.setUserId(rs.getString("userId"));
				carpool.setChoice(rs.getString("choice"));
				carpool.setPurpose(rs.getString("purpose"));
				carpool.setSPoint(rs.getString("SPoint"));
				carpool.setDPoint(rs.getString("DPoint"));
				carpool.setWPoint(rs.getString("WPoint"));
				carpool.setDate(rs.getString("date"));
				carpool.setAmPm(rs.getString("amPm"));
				carpool.setHour(rs.getInt("hour"));
				carpool.setMinute(rs.getInt("minute"));
				carpool.setPersonNum(rs.getInt("personNum"));
				carpool.setPrice(rs.getInt("price"));
				carpool.setInsurance(rs.getString("insurance"));
				carpool.setSmoking(rs.getString("smoking"));
				carpool.setContent(rs.getString("content"));
				carpool.setUserName(rs.getString("userName"));
				carpool.setRegdate(rs.getTimestamp("regdate"));
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
		return carpool;
	}

}
