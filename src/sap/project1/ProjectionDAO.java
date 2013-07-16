package sap.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public class ProjectionDAO {

	private DataSource dataSource;
	
	public ProjectionDAO(DataSource newDataSource) throws SQLException {
        setDataSource(newDataSource);
    }
	
	public DataSource getDataSource() {
        return dataSource;
    }
	public void setDataSource(DataSource newDataSource) throws SQLException {
        this.dataSource = newDataSource;
    }
	
	public void addProjection(Projection projection) throws SQLException {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("INSERT INTO PROJECTIONS (ID, MOVIE_ID, HALL_NUM, PR_DATE) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, projection.getMovie_id());
            pstmt.setInt(3, projection.getHall_num());
            pstmt.setString(4, projection.getDate());
            pstmt.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<Projection> viewAllProjections() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, MOVIE_ID, HALL_NUM, PR_DATE FROM PROJECTIONS");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Projection> list = new ArrayList<Projection>();
            while (rs.next()) {
                Projection pr = new Projection();
                pr.setId(rs.getString(1));
                pr.setMovie_id(rs.getString(2));
                pr.setHall_num(rs.getInt(3));
                pr.setDate(rs.getString(4));
                list.add(pr);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	
	public Projection searchById(String id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, MOVIE_ID, HALL_NUM, PR_DATE FROM PROJECTIONS WHERE ID = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            Projection pr = new Projection();
            while (rs.next()) {
                pr.setId(rs.getString(1));
                pr.setMovie_id(rs.getString(2));
                pr.setHall_num(rs.getInt(3));
                pr.setDate(rs.getString(4));
            }
            return pr;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Projection> searchByMovie_id(String m_id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, MOVIE_ID, HALL_NUM, PR_DATE FROM PROJECTIONS WHERE MOVIE_ID = ?");
            pstmt.setString(1, m_id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Projection> list = new ArrayList<Projection>();
            while (rs.next()) {   
            	Projection pr = new Projection();
                pr.setId(rs.getString(1));
                pr.setMovie_id(rs.getString(2));
                pr.setHall_num(rs.getInt(3));
                pr.setDate(rs.getString(4));
                list.add(pr);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Projection> searchByHall_num(String h_num) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, MOVIE_ID, HALL_NUM, PR_DATE FROM PROJECTIONS WHERE HALL_NUM = ?");
            pstmt.setString(1, h_num);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Projection> list = new ArrayList<Projection>();
            while (rs.next()) {   
            	Projection pr = new Projection();
                pr.setId(rs.getString(1));
                pr.setMovie_id(rs.getString(2));
                pr.setHall_num(rs.getInt(3));
                pr.setDate(rs.getString(4));
                list.add(pr);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<Projection> searchByDate(String pr_date) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, MOVIE_ID, HALL_NUM, PR_DATE FROM PROJECTIONS WHERE PR_DATE = ?");
            pstmt.setString(1, pr_date);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Projection> list = new ArrayList<Projection>();
            while (rs.next()) {   
            	Projection pr = new Projection();
                pr.setId(rs.getString(1));
                pr.setMovie_id(rs.getString(2));
                pr.setHall_num(rs.getInt(3));
                pr.setDate(rs.getString(4));
                list.add(pr);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public void deleteProjection(Projection projection) throws SQLException {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM PROJECTIONS WHERE ID = ?");
            pstmt.setString(1, projection.getId());
            pstmt.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
}