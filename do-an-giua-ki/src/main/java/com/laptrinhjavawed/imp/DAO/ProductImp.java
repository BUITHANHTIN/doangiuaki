package com.laptrinhjavawed.imp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavawed.DAO.IProduct;
import com.laptrinhjavawed.model.Product;

public class ProductImp implements IProduct {
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-GKACKIO\\\\THANHTIN:1433;databaseName=doanwedgiay;integratedSecurity=true";
			String user = "sa";
			String password = "123";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
		}
		return null;
	}

	@Override
	public List<Product> getAllCateID() {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT TOP(4)cname,title,cateID,image FROM dbo.product JOIN dbo.Category ON cid=cateID";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Product pr = new Product();
					pr.setCateID(rs.getInt("cateID"));
					pr.setName(rs.getString("cname"));
					pr.setTitle(rs.getString("title"));
					pr.setImage(rs.getString("image"));

					list.add(pr);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Product> getAllByCateID(String cateID) {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT*FROM dbo.product WHERE cateID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, cateID);
				rs = ps.executeQuery();
				while (rs.next()) {
					Product pr = new Product();
					pr.setId(rs.getInt("id"));
					pr.setCateID(rs.getInt("cateID"));
					pr.setName(rs.getString("name"));
					pr.setTitle(rs.getString("title"));
					pr.setImage(rs.getString("image"));
					pr.setPrice(rs.getDouble("price"));
					pr.setDescription(rs.getString("description"));
					list.add(pr);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		ProductImp p = new ProductImp();
		System.out.println(p.getOneOrMoreSpecialDeals(4, "2"));
	}

	@Override
	public List<Product> getOneOrMoreSpecialDeals(int top, String cateID) {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT TOP(?)* FROM dbo.product WHERE cateID=? ORDER BY price ASC  ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, top);
				ps.setString(2, cateID);
				rs = ps.executeQuery();
				while (rs.next()) {
					Product pr = new Product();
					pr.setId(rs.getInt("id"));
					pr.setCateID(rs.getInt("cateID"));
					pr.setName(rs.getString("name"));
					pr.setTitle(rs.getString("title"));
					pr.setImage(rs.getString("image"));
					pr.setPrice(rs.getDouble("price"));
					pr.setDescription(rs.getString("description"));
					list.add(pr);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Product> getAllBySearch(String searchTitle) {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT * FROM dbo.product WHERE title LIKE ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, "%" + searchTitle + "%");
				rs = ps.executeQuery();
				while (rs.next()) {
					Product pr = new Product();
					pr.setId(rs.getInt("id"));
					pr.setCateID(rs.getInt("cateID"));
					pr.setName(rs.getString("name"));
					pr.setTitle(rs.getString("title"));
					pr.setImage(rs.getString("image"));
					pr.setPrice(rs.getDouble("price"));
					pr.setDescription(rs.getString("description"));
					list.add(pr);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Product getOneById(String id) {
		Product pr = new Product();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT*FROM dbo.product WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					pr = new Product();
					pr.setCateID(rs.getInt("cateID"));
					pr.setName(rs.getString("name"));
					pr.setTitle(rs.getString("title"));
					pr.setImage(rs.getString("image"));
					pr.setPrice(rs.getDouble("price"));
					pr.setDescription(rs.getString("description"));
					pr.setId(rs.getInt("id"));
					pr.setSellID(rs.getInt("sell_ID"));
				}
				return pr;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} // TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT *FROM dbo.product ";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Product pr = new Product();
					pr.setCateID(rs.getInt("cateID"));
					pr.setName(rs.getString("name"));
					pr.setTitle(rs.getString("title"));
					pr.setImage(rs.getString("image"));
					pr.setPrice(rs.getDouble("price"));
					pr.setDescription(rs.getString("description"));
					pr.setId(rs.getInt("id"));
					list.add(pr);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return null;
	}

}
