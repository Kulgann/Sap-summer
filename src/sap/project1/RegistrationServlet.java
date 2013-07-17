package sap.project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String FristName = request.getParameter("FirstName");
	String LastName = request.getParameter("LastName");
	String Email = request.getParameter("email");
	String Password = request.getParameter("password");
	String City = request.getParameter("country");
	StringBuilder Tel = null ;
	Tel.append(request.getParameter("code")).append(request.getParameter("area")).append(request.getParameter("num"));
	String tel=Tel.toString();
	String  gender = request.getParameter("gender");
	int sex= Integer.parseInt(gender);
	UserControl uc= new UserControl();
	uc.CreateUser(Password, Email, FristName, LastName, tel, City, sex);
	}

}
