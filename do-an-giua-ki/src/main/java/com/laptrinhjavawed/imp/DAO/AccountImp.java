package com.laptrinhjavawed.imp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavawed.DAO.IAccount;
import com.laptrinhjavawed.model.Account;

public class AccountImp implements IAccount {
	// @Inject
	// private ConnectionSQL connect;
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

	public List<Account> getOneAccount(String user, String pass) {
		List<Account> list = new ArrayList<>();
		Account account = null;
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT*FROM dbo.Account WHERE [user]=? AND pass=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, user);
				ps.setString(2, pass);
				rs = ps.executeQuery();
				while (rs.next()) {
					account = new Account();
					account.setId(rs.getInt(1));
					account.setUsername(rs.getString(2));
					account.setUser(rs.getString(3));
					account.setPass(rs.getString(4));
					account.setIsSell(rs.getInt(5));
					account.setIsAdmin(rs.getInt(6));
					list.add(account);
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
	public String UsernameExist(String username) {
		String re =null;
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				String sql = "SELECT*FROM dbo.Account WHERE username=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, username);
				rs = ps.executeQuery();
				while (rs.next()) {

					re = rs.getString(2);
				}
				return re;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
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
		AccountImp a = new AccountImp();
		System.out.println(a.UsernameExist("Bùi Thành Tínd"));
	}

	@Override
	public boolean InsertAccount(Account account) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		if (con != null) {
			try {
				String sql = "INSERT INTO dbo.Account(username,[user],pass,isSell,isAdmin)VALUES(?,?,?,0,0)";
				ps = con.prepareStatement(sql);
				ps.setString(1, account.getUsername());
				ps.setString(2, account.getUser());
				ps.setString(3, account.getPass());
				if (ps.executeUpdate() > 0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
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
		return false;

	}
}
