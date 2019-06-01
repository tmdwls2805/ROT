package itc.hoseo.cppe.rentals;

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
public class CartRepository {
	@Autowired
	JdbcTemplate template;
    public boolean insertCart(Cart cart) {
    	return template.update("insert into cart(carId, buyer," + "carTitle,buyPrice,buyCount,carImage) values(?,?,?,?,?,?)",
    			cart.getCarId() , cart.getBuyer() , cart.getCarTitle() , cart.getBuyPrice()
    			, cart.getBuyCount(), cart.getCarImage()) == 1 
    			? true : false;
    }
    
    

	public int getListCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//            conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from cart where buyer=?");
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

	public List<Cart> getCart(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cart cart = null;
		String sql = "";
		List<Cart> lists = null;

		try {
//        	 conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "select * from cart where buyer = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			lists = new ArrayList<Cart>();

			while (rs.next()) {
				cart = new Cart();

				cart.setCartId(rs.getInt("cartId"));
				cart.setCarId(rs.getInt("carId"));
				cart.setCarTitle(rs.getString("carTitle"));
				cart.setBuyPrice(rs.getInt("buyPrice"));
				cart.setBuyCount(rs.getByte("buyCount"));
				cart.setCarImage(rs.getString("carImage"));

				lists.add(cart);
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

	public void updateCount(int cartId, byte count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//        	 conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("update cart set buyCount=? where cartId=?");
			pstmt.setByte(1, count);
			pstmt.setInt(2, cartId);

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

	public void deleteList(int cartId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			 conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("delete from  cart where cartId=?");
			pstmt.setInt(1, cartId);

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

	public void deleteAll(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			 conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("delete from cart where buyer=?");
			pstmt.setString(1, id);

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
