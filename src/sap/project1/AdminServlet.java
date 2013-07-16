package sap.project1;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminServlet.class);
 
	private static DBInitDAO initDAO;
    
	public void init() throws ServletException {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/DefaultDB");
			initDAO = new DBInitDAO(ds);
		} 
		catch (SQLException e) {
			throw new ServletException(e);
		} 
		catch (NamingException e) {
			throw new ServletException(e);
		}
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		String strAnswer = "";
		if(request.getParameter("action").equals("1")) {
			int check = 1;
			try {
				check = initDAO.viewData();
				if(check==0){
					strAnswer = "DatabaseSuccessfullyCreated!";
					initDAO.createDB();
				}
				else{
					strAnswer = "DatabaseAlreadyExists!";
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
  
		if(request.getParameter("action").equals("0")) {
			strAnswer = "GLUPOST";
		}
  
		response.sendRedirect("admin.jsp?answer="+strAnswer);
  
	}

}