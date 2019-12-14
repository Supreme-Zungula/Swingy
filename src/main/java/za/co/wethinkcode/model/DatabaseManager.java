package za.co.wethinkcode.model;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	public Connection connect() {
		return getConnect();
	}

	@Nullable
	private Connection getConnect() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:Swingy.db";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}