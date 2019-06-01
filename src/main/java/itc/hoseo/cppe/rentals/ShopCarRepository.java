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
public class ShopCarRepository {
	@Autowired
	JdbcTemplate template;
	
    public boolean insertCar(ShopCar Car) {
    	return template.update("insert into rentals(carId, carKind, carTitle, carOil, carPrice, carCount, carImage, carContent, discountRate1, discountRate2, regDate)"
    			+ " values(?,?,?,?,?,?,?,?,?,?,?)",
    			Car.getCarId() , Car.getCarKind() , Car.getCarTitle() , Car.getCarOil()
    			, Car.getCarPrice(), Car.getCarCount(), Car.getCarImage(), Car.getCarContent()
    			, Car.getDiscountRate1(), Car.getDiscountRate2(), Car.getRegDate()) == 1 
    			? true : false;
    }

    

	public int getCarCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
//			        conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select count(*) from rentals");
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

	public List<ShopCar> getCars(String carKind) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ShopCar> carList = null;

		try {
//			        conn = CPPE_Connection.JDBCConnection.getConnection();

			String sql1 = "select * from rentals";
			String sql2 = "select * from rentals ";
			sql2 += "where carKind = ? order by regDate desc";

			if (carKind.equals("all")) {
				pstmt = conn.prepareStatement(sql1);
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, carKind);
			}
			rs = pstmt.executeQuery();

			if (rs.next()) {
				carList = new ArrayList<ShopCar>();
				do {
					ShopCar car = new ShopCar();

					car.setCarId(rs.getInt("carId"));
					car.setCarKind(rs.getString("carKind"));
					car.setCarTitle(rs.getString("carTitle"));
					car.setCarOil(rs.getString("carOil"));
					car.setCarPrice(rs.getInt("carPrice"));
					car.setCarCount(rs.getShort("carCount"));
					car.setCarImage(rs.getString("carImage"));
					car.setDiscountRate1(rs.getByte("discountRate1"));
					car.setDiscountRate2(rs.getByte("discountRate2"));
					car.setRegDate(rs.getTimestamp("regDate"));

					carList.add(car);
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
		return carList;
	}

	public ShopCar[] getCars(String carKind, int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopCar carList[] = null;
		int i = 0;

		try {
//			        conn = CPPE_Connection.JDBCConnection.getConnection();

			String sql = "select * from rentals where carKind = ? ";
			sql += "order by regDate desc limit ?,?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carKind);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, count);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				carList = new ShopCar[count];
				do {
					ShopCar car = new ShopCar();
					car.setCarId(rs.getInt("carId"));
					car.setCarKind(rs.getString("carKind"));
					car.setCarTitle(rs.getString("carTitle"));
					car.setCarOil(rs.getString("carOil"));
					car.setCarPrice(rs.getInt("carPrice"));
					car.setCarCount(rs.getShort("carCount"));
					car.setCarImage(rs.getString("carImage"));
					car.setDiscountRate1(rs.getByte("discountRate1"));
					car.setDiscountRate2(rs.getByte("discountRate2"));
					car.setRegDate(rs.getTimestamp("regDate"));

					carList[i] = car;

					i++;
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
		return carList;
	}

	public ShopCar getCar(int carId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopCar car = null;

		try {
//			        conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("select * from rentals where carId = ?");
			pstmt.setInt(1, carId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				car = new ShopCar();

				car.setCarKind(rs.getString("carKind"));
				car.setCarTitle(rs.getString("carTitle"));
				car.setCarOil(rs.getString("carOil"));
				car.setCarPrice(rs.getInt("carPrice"));
				car.setCarCount(rs.getShort("carCount"));
				car.setCarImage(rs.getString("carImage"));
				car.setCarContent(rs.getString("carContent"));
				car.setDiscountRate1(rs.getByte("discountRate1"));
				car.setDiscountRate2(rs.getByte("discountRate2"));
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
		return car;
	}

	public void updateCar(ShopCar car, int carId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;

		try {
//			        conn = CPPE_Connection.JDBCConnection.getConnection();

			sql = "update rentals set carKind=?,carTitle=?,carOil=?,carPrice=?";
			sql += ",carCount=?";
			sql += ",carImage=?,carContent=?,discountRate1=?,discountRate2=?";
			sql += " where carId=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, car.getCarKind());
			pstmt.setString(2, car.getCarTitle());
			pstmt.setString(3, car.getCarOil());
			pstmt.setInt(4, car.getCarPrice());
			pstmt.setShort(5, car.getCarCount());
			pstmt.setString(6, car.getCarImage());
			pstmt.setString(7, car.getCarContent());
			pstmt.setByte(8, car.getDiscountRate1());
			pstmt.setByte(9, car.getDiscountRate2());
			pstmt.setInt(10, carId);

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

	public void deleteCar(int carId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//					conn = CPPE_Connection.JDBCConnection.getConnection();

			pstmt = conn.prepareStatement("delete from rentals where carId=?");
			pstmt.setInt(1, carId);

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
}
