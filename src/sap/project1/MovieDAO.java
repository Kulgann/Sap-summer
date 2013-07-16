package sap.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public class MovieDAO {

	private DataSource dataSource;
	
	public MovieDAO(DataSource newDataSource) throws SQLException {
        setDataSource(newDataSource);
    }
	
	public DataSource getDataSource() {
        return dataSource;
    }
	public void setDataSource(DataSource newDataSource) throws SQLException {
        this.dataSource = newDataSource;
    }
	
	public void addMovie(Movie movie) throws SQLException {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("INSERT INTO MOVIES (ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, movie.getTitle());
            pstmt.setString(3, movie.getYear());
            pstmt.setString(4, movie.getGenre());
            pstmt.setString(5, movie.getRestriction());
            pstmt.setString(6, movie.getDescription());
            pstmt.setString(7, movie.getImageURL());
            pstmt.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	public List<Movie> viewAllMovies() throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL FROM MOVIES");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Movie> list = new ArrayList<Movie>();
            while (rs.next()) {
                Movie m = new Movie();
                m.setId(rs.getString(1));
                m.setTitle(rs.getString(2));
                m.setYear(rs.getString(3));
                m.setGenre(rs.getString(4));
                m.setRestriction(rs.getString(5));
                m.setDescription(rs.getString(6));
                m.setImageURL(rs.getString(7));
                
                list.add(m);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
	
	public List<Movie> searchByTitle(String title) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL FROM MOVIES WHERE TITLE LIKE ?");
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Movie> list = new ArrayList<Movie>();
            while (rs.next()) {
            	Movie m = new Movie();
                m.setId(rs.getString(1));
                m.setTitle(rs.getString(2));
                m.setYear(rs.getString(3));
                m.setGenre(rs.getString(4));
                m.setRestriction(rs.getString(5));
                m.setDescription(rs.getString(6));
                m.setImageURL(rs.getString(7));
                list.add(m);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Movie> searchByYear(String year) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL FROM MOVIES WHERE YR=?");
            pstmt.setString(1, year);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Movie> list = new ArrayList<Movie>();
            while (rs.next()) {   
            	Movie m = new Movie();
                m.setId(rs.getString(1));
                m.setTitle(rs.getString(2));
                m.setYear(rs.getString(3));
                m.setGenre(rs.getString(4));
                m.setRestriction(rs.getString(5));
                m.setDescription(rs.getString(6));
                m.setImageURL(rs.getString(7));
                list.add(m);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Movie> searchByGenre(String genre) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL FROM MOVIES WHERE GENRE=?");
            pstmt.setString(1, genre);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Movie> list = new ArrayList<Movie>();
            while (rs.next()) {
            	Movie m = new Movie();
                m.setId(rs.getString(1));
                m.setTitle(rs.getString(2));
                m.setYear(rs.getString(3));
                m.setGenre(rs.getString(4));
                m.setRestriction(rs.getString(5));
                m.setDescription(rs.getString(6));
                m.setImageURL(rs.getString(7));
                list.add(m);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public List<Movie> searchByRestriction(String restriction) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL FROM MOVIES WHERE RESTRICTION=?");
            pstmt.setString(1, restriction);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Movie> list = new ArrayList<Movie>();
            while (rs.next()) {
            	Movie m = new Movie();
                m.setId(rs.getString(1));
                m.setTitle(rs.getString(2));
                m.setYear(rs.getString(3));
                m.setGenre(rs.getString(4));
                m.setRestriction(rs.getString(5));
                m.setDescription(rs.getString(6));
                m.setImageURL(rs.getString(7));
                list.add(m);
            }
            return list;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	public Movie searchById(String id) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement("SELECT ID, TITLE, YR, GENRE, RESTRICTION, DESCRIPTION, IMAGEURL FROM MOVIES WHERE ID=?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            Movie m = new Movie();
            while (rs.next()) {
            	
                m.setId(rs.getString(1));
                m.setTitle(rs.getString(2));
                m.setYear(rs.getString(3));
                m.setGenre(rs.getString(4));
                m.setRestriction(rs.getString(5));
                m.setDescription(rs.getString(6));
                m.setImageURL(rs.getString(7));
            }
            return m;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
	
}
