package sap.project1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import src.com.twmacinta.util.MD5;

public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    UserDAO    userDAO;
   @Override 
    public void init() throws ServletException 
    {
    try {
    	   InitialContext ctx = new InitialContext();
    	   DataSource ds = (DataSource) ctx
    	     .lookup("java:comp/env/jdbc/DefaultDB"); // TODO change data source
    	   userDAO = new UserDAO(ds);
    	  } catch (SQLException e) {
    	   throw new ServletException(e);
    	  } catch (NamingException e) {
    	   throw new ServletException(e);
    	  }

    }

    MD5 md5 = new MD5();
	User user = new User();
	

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void CreateUser(String pass, String email,String firstName, String lastName, String tel, String city, int sex)

	{
		
		user.setCity(city);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setSex(sex);
		user.setTel(tel);
		try {
			md5.Update(pass, null);
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		pass = md5.asHex();
		user.setPassword(pass);
		try {
			userDAO.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean validateUser(String email, String password)
	 {
	  User user = new User();
	  try {
			md5.Update(password, null);
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
	
	  boolean validity = true;
	
	  try {
	   user = userDAO.searchByEmail(email);
	  } catch (SQLException e) {
	   validity = false;
	   // TODO Error message: No such email in DB
	   e.printStackTrace();
	  }
	  
	  password=md5.asHex();
	  if(!password.equals(user.getPassword()))
	  {
		  //TODO Error message:Wrong password
		   validity = false;
	  }
	 
	  
	  return validity;
	 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
