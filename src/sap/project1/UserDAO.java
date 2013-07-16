package sap.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public class UserDAO {

	private DataSource dataSource;
	
	public UserDAO(DataSource newDataSource) throws SQLException {
        setDataSource(newDataSource);
    }
	
	public DataSource getDataSource() {
        return dataSource;
    }
	public void setDataSource(DataSource newDataSource) throws SQLException {
        this.dataSource = newDataSource;
    }
	
	public void addUser(User user) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("INSERT INTO USERS (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, TELEPHONE, CITY, SEX, SUBSCRIBED) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getTel());
            pstmt.setString(7, user.getCity());
            pstmt.setInt(8, user.getSex());
            if(user.isSubscribed()) flag=1;
            pstmt.setInt(9, flag);
            pstmt.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<User> viewAllUsers() throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, TELEPHONE, CITY, SEX, SUBSCRIBED, POINTS FROM USERS");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getString(1));
                u.setFirstName(rs.getString(2));
                u.setLastName(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setTel(rs.getString(6));
                u.setCity(rs.getString(7));
                u.setSex(rs.getInt(8));
                flag=rs.getInt(9);
                if(flag==1) u.setSubscribed(true);
                else u.setSubscribed(false);
                u.setPoints(rs.getInt(10));
                list.add(u);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public String checkEmail(String mail) throws SQLException {
		Connection connection = dataSource.getConnection();
		String id=null;
		try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID FROM USERS WHERE EMAIL=?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id=rs.getString(1);
            }
            return id;
        } finally {
            if (connection != null) {
                connection.close();
                return null;
            }
        }
	}
	
	public String checkPassword(String pass) throws SQLException {
		Connection connection = dataSource.getConnection();
		String id=null;
		try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID FROM USERS WHERE PASSWORD=?");
            pstmt.setString(1, pass);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id=rs.getString(1);
            }
            return id;
        } finally {
            if (connection != null) {
                connection.close();
                return null;
            }
        }
	}
	
	public User searchByEmail(String mail) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, TELEPHONE, CITY, SEX, SUBSCRIBED, POINTS FROM USERS WHERE EMAIL=?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            User u = new User();
            while (rs.next()) {     
                u.setId(rs.getString(1));
                u.setFirstName(rs.getString(2));
                u.setLastName(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setTel(rs.getString(6));
                u.setCity(rs.getString(7));
                u.setSex(rs.getInt(8));
                flag=rs.getInt(9);
                if(flag==1) u.setSubscribed(true);
                else u.setSubscribed(false);
                u.setPoints(rs.getInt(10));
            }
            return u;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<User> searchByName(String firstName, String lastName) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, TELEPHONE, CITY, SEX, SUBSCRIBED, POINTS FROM USERS WHERE FIRSTNAME=? AND LASTNAME=?");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next()) {   
            	User u = new User();
            	u.setId(rs.getString(1));
                u.setFirstName(rs.getString(2));
                u.setLastName(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setTel(rs.getString(6));
                u.setCity(rs.getString(7));
                u.setSex(rs.getInt(8));
                flag=rs.getInt(9);
                if(flag==1) u.setSubscribed(true);
                else u.setSubscribed(false);
                u.setPoints(rs.getInt(10));
                list.add(u);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
}
