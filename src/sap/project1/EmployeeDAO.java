package sap.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public class EmployeeDAO {

	private DataSource dataSource;
	
	public EmployeeDAO(DataSource newDataSource) throws SQLException {
        setDataSource(newDataSource);
    }
	
	public DataSource getDataSource() {
        return dataSource;
    }
	public void setDataSource(DataSource newDataSource) throws SQLException {
        this.dataSource = newDataSource;
    }
	
	public void addEmployee(Employee employee) throws SQLException {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("INSERT INTO EMPLOYEES (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, POINTS) VALUES (?, ?, ?, ?, ?, 0)");
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getPassword());
            pstmt.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<Employee> viewAllEmployees() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, POINTS FROM EMPLOYEES");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Employee> list = new ArrayList<Employee>();
            while (rs.next()) {
                Employee em = new Employee();
                em.setId(rs.getString(1));
                em.setFirstName(rs.getString(2));
                em.setLastName(rs.getString(3));
                em.setEmail(rs.getString(4));
                em.setPassword(rs.getString(5));
                em.setPoints(rs.getInt(6));
                
                list.add(em);
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
                    .prepareStatement("SELECT ID FROM EMPLOYEES WHERE EMAIL=?");
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
                    .prepareStatement("SELECT ID FROM EMPLOYEES WHERE PASSWORD=?");
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
	
	public Employee searchByEmail(String mail) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, POINTS FROM EMPLOYEES WHERE EMAIL=?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            Employee em = new Employee();
            while (rs.next()) {     
                em.setId(rs.getString(1));
                em.setFirstName(rs.getString(2));
                em.setLastName(rs.getString(3));
                em.setEmail(rs.getString(4));
                em.setPassword(rs.getString(5));
                em.setPoints(rs.getInt(6));
                
            }
            return em;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<Employee> searchByName(String name) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, POINTS FROM EMPLOYEES WHERE FIRSTNAME=? OR LASTNAME=?");
            pstmt.setString(1, name);
            pstmt.setString(2, name);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Employee> list = new ArrayList<Employee>();
            while (rs.next()) {     
            	Employee em = new Employee();
                em.setId(rs.getString(1));
                em.setFirstName(rs.getString(2));
                em.setLastName(rs.getString(3));
                em.setEmail(rs.getString(4));
                em.setPassword(rs.getString(5));
                em.setPoints(rs.getInt(6));
                list.add(em);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}