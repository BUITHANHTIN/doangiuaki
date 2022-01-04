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
			String url = "jdbc:sqlserver://DESKTOP-GKACKIO\\\\THANHTIN:1433;databaseName=doanwedgiay1;integratedSecurity=true";
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
				String sql = "SELECT TOP(4) cname,title,cateID,image FROM  dbo.product JOIN dbo.Category ON cid=cateID ";
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
				String sql = "SELECT*FROM dbo.product WHERE cateID=? and  [SLHangTon]>0";
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
		System.out.println(p.getProducByPaging(3, 4));
	}

	@Override
	public List<Product> getOneOrMoreSpecialDeals(int top, String cateID) {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT TOP(?)* FROM dbo.product WHERE cateID=? and  [SLHangTon]>0 ORDER BY price ASC  ";
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
				String sql = "SELECT * FROM dbo.product WHERE  [SLHangTon]>0 and title LIKE ?";
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
				String sql = "SELECT*FROM dbo.product WHERE id=? and  [SLHangTon]>0";
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
					pr.setSLHangTon(rs.getInt("SLHangTon"));
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
				String sql = "SELECT *FROM dbo.product WHERE [SLHangTon]>0 ";
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

	@Override
	public int countgetAllProduct() {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		if (con != null) {
			try {
				String sql = "SELECT COUNT(*) FROM dbo.product WHERE [SLHangTon]>0";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
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
		return 0;
	}

	@Override
	public int countgetAllProduct(String cateID) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		if (con != null) {
			try {
				String sql = " SELECT COUNT(*) FROM dbo.product WHERE cateID=? and  [SLHangTon]>0";
				ps = con.prepareStatement(sql);
				ps.setString(1, cateID);
				rs = ps.executeQuery();
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
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
		return 0;
	}

	@Override
	public List<Product> getProducByPaging(int input, int param) {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT*FROM dbo.product WHERE [SLHangTon]>0  ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROW ONLY ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, (input - 1) * param);
				ps.setInt(2, param);
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
