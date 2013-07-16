package sap.project1;

import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;

public class DBInitDAO {
 
	private DataSource dataSource;
 
	public DBInitDAO(DataSource newDataSource) throws SQLException
	{
		this.dataSource = newDataSource;
	}
 
	public void createDB() throws SQLException
	{
		createTableUsers();
		createTableEmployees();
		createTableMovies();
		createTableHalls();
		createTableProjections();
		createTableTickets();
	}
 
 
	public int viewData() throws SQLException
	{
		int value = 0;
		Connection  conn = dataSource.getConnection();
		DatabaseMetaData meta = conn.getMetaData();
		try {
			ResultSet rs = meta.getTables(null, null, "USERS", null);
			while (rs.next()) {
				String name = rs.getString("TABLE_NAME");
				if (name.equals("USERS")) {
					value = 1;
				}
			}
		}
		finally {
			if(!conn.isClosed()) {conn.close();}  
		}
		return value;
	}
 
	private void createTableUsers() throws SQLException {
		Connection connection= dataSource.getConnection();
		try{
			PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE USERS ("
					+ "ID VARCHAR(255) PRIMARY KEY,"
					+ "FIRSTNAME VARCHAR(255),"
					+ "LASTNAME VARCHAR(255),"
					+ "EMAIL VARCHAR(255) NOT NULL,"
					+ "PASSWORD VARCHAR(255) NOT NULL,"
					+ "TELEPHONE VARCHAR(255),"
					+ "CITY VARCHAR(255),"
					+ "SEX INTEGER,"
					+ "SUBSCRIBED INTEGER,"
					+ "POINTS INTEGER DEFAULT 0)");
			pstmt.executeUpdate();
		}
		finally{
			if(!connection.isClosed()) {connection.close();}
		}
	}
   
	private void createTableEmployees() throws SQLException {
		Connection connection= dataSource.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE EMPLOYEES ("
					+ "ID VARCHAR(255) PRIMARY KEY,"
					+ "FIRSTNAME VARCHAR(255) NOT NULL,"
					+ "LASTNAME VARCHAR(255) NOT NULL,"
					+ "EMAIL VARCHAR(255) NOT NULL,"
					+ "PASSWORD VARCHAR(255) NOT NULL,"
					+ "POINTS INTEGER DEFAULT 0)");
			pstmt.executeUpdate();
		}
		finally{
			if(!connection.isClosed()) {connection.close();}
		}
	}
   
	private void createTableMovies() throws SQLException {
		Connection connection= dataSource.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE MOVIES ("
					+ "ID VARCHAR(255) PRIMARY KEY,"
					+ "TITLE VARCHAR(255) NOT NULL,"
					+ "YR VARCHAR(255) NOT NULL,"
					+ "GENRE VARCHAR(255) NOT NULL,"
					+ "RESTRICTION VARCHAR(255) NOT NULL,"
					+ "DESCRIPTION VARCHAR(255) NOT NULL,"
					+ "IMAGEURL VARCHAR(255))");
			pstmt.executeUpdate();
		}
		finally{
			if(!connection.isClosed()) {connection.close();}
		}
	}
   
	private void createTableHalls() throws SQLException {
		Connection connection= dataSource.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE HALLS ("
					+ "NUMBER INTEGER PRIMARY KEY,"
					+ "N_ROWS INTEGER NOT NULL,"
					+ "N_COLUMNS INTEGER NOT NULL)");
			pstmt.executeUpdate();
		}
		finally{
			if(!connection.isClosed()) {connection.close();}
		}
	}

	private void createTableProjections() throws SQLException {
		Connection connection= dataSource.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE PROJECTIONS ("
					+ "ID VARCHAR(255) PRIMARY KEY,"
					+ "MOVIE_ID VARCHAR(255) NOT NULL,"
					+ "HALL_NUM INTEGER NOT NULL,"
					+ "PR_DATE TIMESTAMP)");
			pstmt.executeUpdate();
		} 
		finally {
			if(!connection.isClosed()) {connection.close();}
		}
	}
   
	private void createTableTickets() throws SQLException {
  
		Connection connection= dataSource.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE TICKETS ("
					+ "ID VARCHAR(255) PRIMARY KEY,"
					+ "USER_ID VARCHAR(255) NOT NULL,"
					+ "PROJECTION_ID VARCHAR(255) NOT NULL,"
					+ "SEAT_ROW INTEGER NOT NULL,"
					+ "SEAT_COL INTEGER NOT NULL,"
					+ "RECEIVED INTEGER NOT NULL)");
			pstmt.executeUpdate();
		}
		finally {
			if(!connection.isClosed()) {connection.close();}
		}
	}
}