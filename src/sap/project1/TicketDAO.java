package sap.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public class TicketDAO {

private DataSource dataSource;
	
	public TicketDAO(DataSource newDataSource) throws SQLException {
        setDataSource(newDataSource);
    }
	
	public DataSource getDataSource() {
        return dataSource;
    }
	public void setDataSource(DataSource newDataSource) throws SQLException {
        this.dataSource = newDataSource;
    }
	
	public void addTicket(Ticket ticket) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("INSERT INTO TICKETS (ID, USER_ID, PROJECTION_ID, SEAT_ROW, SEAT_COL, RECEIVED) VALUES (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, ticket.getUser_id());
            pstmt.setString(3, ticket.getProjection_id());
            pstmt.setInt(4, ticket.getSeat_row());
            pstmt.setInt(5, ticket.getSeat_col());
            if(ticket.isReceived()) flag=1;
            pstmt.setInt(6, flag);
            pstmt.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<Ticket> viewAllTickets() throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, USER_ID, PROJECTION_ID, SEAT_ROW, SEAT_COL, RECEIVED FROM TICKETS");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Ticket> list = new ArrayList<Ticket>();
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setId(rs.getString(1));
                t.setUser_id(rs.getString(2));
                t.setProjection_id(rs.getString(3));
                t.setSeat_row(rs.getInt(4));
                t.setSeat_col(rs.getInt(5));
                flag=rs.getInt(6);
                if(flag==1) t.setReceived(true);
                else t.setReceived(false);
                list.add(t);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	
	public Ticket searchById(String id) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, USER_ID, PROJECTION_ID, SEAT_ROW, SEAT_COL, RECEIVED FROM TICKETS WHERE ID = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            Ticket t = new Ticket();
            while (rs.next()) {
                t.setId(rs.getString(1));
                t.setUser_id(rs.getString(2));
                t.setProjection_id(rs.getString(3));
                t.setSeat_row(rs.getInt(4));
                t.setSeat_col(rs.getInt(5));
                flag=rs.getInt(6);
                if(flag==1) t.setReceived(true);
                else t.setReceived(false);
            }
            return t;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Ticket> searchByProjection_id(String pr_id) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, USER_ID, PROJECTION_ID, SEAT_ROW, SEAT_COL, RECEIVED FROM TICKETS WHERE PROJECTION_ID = ?");
            pstmt.setString(1, pr_id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Ticket> list = new ArrayList<Ticket>();
            while (rs.next()) {   
            	Ticket t = new Ticket();
            	t.setId(rs.getString(1));
                t.setUser_id(rs.getString(2));
                t.setProjection_id(rs.getString(3));
                t.setSeat_row(rs.getInt(4));
                t.setSeat_col(rs.getInt(5));
                flag=rs.getInt(6);
                if(flag==1) t.setReceived(true);
                else t.setReceived(false);
                list.add(t);         
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Ticket> searchByUser_id(String u_id) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, USER_ID, PROJECTION_ID, SEAT_ROW, SEAT_COL, RECEIVED FROM TICKETS WHERE USER_ID = ?");
            pstmt.setString(1, u_id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Ticket> list = new ArrayList<Ticket>();
            while (rs.next()) {   
            	Ticket t = new Ticket();
            	t.setId(rs.getString(1));
                t.setUser_id(rs.getString(2));
                t.setProjection_id(rs.getString(3));
                t.setSeat_row(rs.getInt(4));
                t.setSeat_col(rs.getInt(5));
                flag=rs.getInt(6);
                if(flag==1) t.setReceived(true);
                else t.setReceived(false);
                list.add(t);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public Ticket searchBySeat(String pr_id, int r, int c) throws SQLException {
		int flag=0;
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, USER_ID, PROJECTION_ID, SEAT_ROW, SEAT_COL, RECEIVED FROM TICKETS WHERE PROJECTION_ID = ? AND SEAT_ROW = ? AND SEAT_COL = ?");
            pstmt.setString(1, pr_id);
            pstmt.setInt(2, r);
            pstmt.setInt(3, c);
            ResultSet rs = pstmt.executeQuery();
            Ticket t = new Ticket();
            while (rs.next()) {   
            	t.setId(rs.getString(1));
                t.setUser_id(rs.getString(2));
                t.setProjection_id(rs.getString(3));
                t.setSeat_row(rs.getInt(4));
                t.setSeat_col(rs.getInt(5));
                flag=rs.getInt(6);
                if(flag==1) t.setReceived(true);
                else t.setReceived(false);
            }
            return t;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	
}
