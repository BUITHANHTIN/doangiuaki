package com.laptrinhjavawed.imp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavawed.DAO.ICT_Bill;
import com.laptrinhjavawed.model.Account;
import com.laptrinhjavawed.model.CT_Bill;

public class CT_BillImp implements ICT_Bill {
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

	@Override
	public boolean insert_CT_Bill(CT_Bill ctBill) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		if (con != null) {
			try {
				String sql = "INSERT INTO dbo.CT_Bill VALUES(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, ctBill.getIdBill());
				ps.setInt(2, ctBill.getIdProduct());
				ps.setString(3, ctBill.getName());
				ps.setString(4, ctBill.getImage());
				ps.setString(5, ctBill.getPrice());
				ps.setInt(6, ctBill.getCount());
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
