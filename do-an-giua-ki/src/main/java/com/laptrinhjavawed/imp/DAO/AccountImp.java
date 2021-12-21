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
			String url = "jdbc:sqlserver://DESKTOP-GKACKIO\\\\THANHTIN:1433;databaseName=doanwedgiay;integratedSecurity=true";
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
		Connection con =getConnection();
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
					account.setUser(rs.getString(2));
					account.setPass(rs.getString(3));
					account.setIsSell(rs.getInt(4));
					account.setIsAdmin(rs.getInt(5));
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
}
