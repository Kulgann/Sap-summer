package sap.project1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class MovieControl
 */
public class MovieControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    MovieDAO md ;
    ProjectionDAO pd;
    @Override 
    public void init() throws ServletException 
    {
    try {
    	   InitialContext ctx = new InitialContext();
    	   DataSource ds = (DataSource) ctx
    	     .lookup("java:comp/env/jdbc/DefaultDB"); // TODO change data source
    	   md  = new MovieDAO(ds);
    	   pd  = new ProjectionDAO(ds);
    } catch (SQLException e) {
    	   throw new ServletException(e);
    	  } catch (NamingException e) {
    	   throw new ServletException(e);
    	  }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<String> titlelist = null;
    	List<Projection> projectionlist = null;
    	try {
		 projectionlist =pd.viewAllProjections();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		for(int i=0;i<projectionlist.size();i++)
		{
			try {
				titlelist.add(new String(md.searchById(projectionlist.get(i).getId()).getTitle())+projectionlist.get(i).getDate());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		request.setAttribute("titlelist", titlelist);
	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Sap-Summer/WebContent/programa.jsp");
	    rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
