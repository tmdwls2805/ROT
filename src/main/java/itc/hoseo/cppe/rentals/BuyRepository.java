package itc.hoseo.cppe.rentals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class BuyRepository {
	public List<String> getAccount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> accountList = null;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select * from bank");
			rs = pstmt.executeQuery();

			accountList = new ArrayList<String>();

			while (rs.next()) {
				String account = new String(
						rs.getString("account") + " " + rs.getString("bank") + " " + rs.getString("name"));
				accountList.add(account);
			}
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
		return accountList;
	}

	public void insertBuy(List<Cart> lists, String id, String deliveryName, String deliveryTel,
			String deliveryZipcode, String deliveryAddr1, String deliveryAddr2, String hour, String minute, String amPm,
			String date, String payment) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Timestamp reg_date = null;
		String sql = "";
		String maxDate = " ";
		String number = "";
		String todayDate = "";
		String compareDate = "";
		long buyId = 0;
		short nowCount;
		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();
			reg_date = new Timestamp(System.currentTimeMillis());
			todayDate = reg_date.toString();
			compareDate = todayDate.substring(0, 4) + todayDate.substring(5, 7) + todayDate.substring(8, 10);

			pstmt = conn.prepareStatement("select max(buy_id) from buy");

			rs = pstmt.executeQuery();
			rs.next();
			if (rs.getLong(1) > 0) {
				Long val = new Long(rs.getLong(1));
				maxDate = val.toString().substring(0, 8);
				number = val.toString().substring(8);
				if (compareDate.equals(maxDate)) {
					if ((Integer.parseInt(number) + 1) < 10000)
						buyId = Long.parseLong(maxDate + (Integer.parseInt(number) + 1 + 10000));
					else
						buyId = Long.parseLong(maxDate + (Integer.parseInt(number) + 1));
				} else {
					compareDate += "00001";
					buyId = Long.parseLong(compareDate);
				}
			} else {
				compareDate += "00001";
				buyId = Long.parseLong(compareDate);
			}
			conn.setAutoCommit(false);
			for (int i = 0; i < lists.size(); i++) {
				Cart cart = lists.get(i);

				sql = "insert into buy (buy_id,buyer,carId,carTitle,buyPrice,buyCount,";
				sql += "carImage,buyDate,deliveryName,deliveryTel,deliveryZipcode,deliveryAddr1,deliveryAddr2,"
						+ "hour,minute,amPm,date,payment)";
				sql += " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setLong(1, buyId);
				pstmt.setString(2, id);
				pstmt.setInt(3, cart.getCarId());
				pstmt.setString(4, cart.getCarTitle());
				pstmt.setInt(5, cart.getBuyPrice());
				pstmt.setByte(6, cart.getBuyCount());
				pstmt.setString(7, cart.getCarImage());
				pstmt.setTimestamp(8, reg_date);
				pstmt.setString(9, deliveryName);
				pstmt.setString(10, deliveryTel);
				pstmt.setString(11, deliveryZipcode);
				pstmt.setString(12, deliveryAddr1);
				pstmt.setString(13, deliveryAddr2);
				pstmt.setString(14, hour);
				pstmt.setString(15, minute);
				pstmt.setString(16, amPm);
				pstmt.setString(17, date);
				pstmt.setString(18, payment);

				pstmt.executeUpdate();

				pstmt = conn.prepareStatement("select carCount from rentals where carId=?");
				pstmt.setInt(1, cart.getCarId());
				rs = pstmt.executeQuery();
				rs.next();

				nowCount = (short) (rs.getShort(1) - cart.getBuyCount());

				sql = "update rentals set carCount=? where carId=?";
				pstmt = conn.prepareStatement(sql);

				pstmt.setShort(1, nowCount);
				pstmt.setInt(2, cart.getCarId());

				pstmt.executeUpdate();
			}

			pstmt = conn.prepareStatement("delete from cart where buyer=?");
			pstmt.setString(1, id);

			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
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

	public int getListCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from buy where buyer=?");
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

	public int getListCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from buy");
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

	public List<Buy> getBuyList(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Buy buy = null;
		String sql = "";
		List<Buy> lists = null;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "select * from buy where buyer = ? order by buyDate desc";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Buy>();

			while (rs.next()) {
				buy = new Buy();

				buy.setBuyId(rs.getLong("buyId"));
				buy.setBuyer(rs.getString("buyer"));
				buy.setCarId(rs.getInt("carId"));
				buy.setCarTitle(rs.getString("carTitle"));
				buy.setBuyPrice(rs.getInt("buyPrice"));
				buy.setBuyCount(rs.getByte("buyCount"));
				buy.setCarImage(rs.getString("carImage"));
				buy.setBuyDate(rs.getTimestamp("buyDate"));
				buy.setDeliveryName(rs.getString("deliveryName"));
				buy.setDeliveryTel(rs.getString("deliveryTel"));
				buy.setDeliveryZipcode(rs.getInt("deliveryZipcode"));
				buy.setDeliveryAddr1(rs.getString("deliveryAddr1"));
				buy.setDeliveryAddr2(rs.getString("deliveryAddr2"));
				buy.setSanction(rs.getString("sanction"));
				buy.setHour(rs.getString("hour"));
				buy.setMinute(rs.getString("minute"));
				buy.setAmPm(rs.getString("amPm"));
				buy.setDate(rs.getString("date"));
				buy.setPayment(rs.getString("payment"));

				lists.add(buy);
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

	public List<Buy> getBuyProfileList(String id, Long buyId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Buy buy = null;
		String sql = "";
		List<Buy> lists = null;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "select * from buy where buyer=? and buyId=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setLong(2, buyId);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Buy>();

			while (rs.next()) {
				buy = new Buy();

				buy.setBuyId(rs.getLong("buyId"));
				buy.setBuyer(rs.getString("buyer"));
				buy.setCarId(rs.getInt("carId"));
				buy.setCarTitle(rs.getString("carTitle"));
				buy.setBuyPrice(rs.getInt("buyPrice"));
				buy.setBuyCount(rs.getByte("buyCount"));
				buy.setCarImage(rs.getString("carImage"));
				buy.setBuyDate(rs.getTimestamp("buyDate"));
				buy.setDeliveryName(rs.getString("deliveryName"));
				buy.setDeliveryTel(rs.getString("deliveryTel"));
				buy.setDeliveryZipcode(rs.getInt("deliveryZipcode"));
				buy.setDeliveryAddr1(rs.getString("deliveryAddr1"));
				buy.setDeliveryAddr2(rs.getString("deliveryAddr2"));
				buy.setSanction(rs.getString("sanction"));
				buy.setHour(rs.getString("hour"));
				buy.setMinute(rs.getString("minute"));
				buy.setAmPm(rs.getString("amPm"));
				buy.setDate(rs.getString("date"));
				buy.setPayment(rs.getString("payment"));

				lists.add(buy);
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

	public int getListProfileCount(String id, Long buyId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from buy where buyer=? and buy_id=?");
			pstmt.setString(1, id);
			pstmt.setLong(2, buyId);
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

	public List<Buy> getBuyList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Buy buy = null;
		String sql = "";
		List<Buy> lists = null;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "select * from buy order by buyDate desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Buy>();

			while (rs.next()) {
				buy = new Buy();

				buy.setBuyId(rs.getLong("buyId"));
				buy.setBuyer(rs.getString("buyer"));
				buy.setCarId(rs.getInt("carId"));
				buy.setCarTitle(rs.getString("carTitle"));
				buy.setBuyPrice(rs.getInt("buyPrice"));
				buy.setBuyCount(rs.getByte("buyCount"));
				buy.setCarImage(rs.getString("carImage"));
				buy.setBuyDate(rs.getTimestamp("buyDate"));
				buy.setDeliveryName(rs.getString("deliveryName"));
				buy.setDeliveryTel(rs.getString("deliveryTel"));
				buy.setDeliveryZipcode(rs.getInt("deliveryZipcode"));
				buy.setDeliveryAddr1(rs.getString("deliveryAddr1"));
				buy.setDeliveryAddr2(rs.getString("deliveryAddr2"));
				buy.setSanction(rs.getString("sanction"));
				buy.setHour(rs.getString("hour"));
				buy.setMinute(rs.getString("minute"));
				buy.setAmPm(rs.getString("amPm"));
				buy.setDate(rs.getString("date"));
				buy.setPayment(rs.getString("payment"));

				lists.add(buy);
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

	public void updateCount(String sanction, Long buyId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("update buy set sanction=? where buyId=?");
			pstmt.setString(1, sanction);
			pstmt.setLong(2, buyId);

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
