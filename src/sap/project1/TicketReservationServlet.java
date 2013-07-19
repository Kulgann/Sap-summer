package sap.project1;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sap.project1.TicketControl.ReservedTicket;

/**
 * Servlet implementation class TicketReservationServlet
 */
public class TicketReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<TicketControl.ReservedTicket> reservedTickets;
    String selectedButton;
    int tempRow;
    int tempCol;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketReservationServlet() {
        super();
        
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
		selectedButton = request.getParameter("buttonNum");
		if(selectedButton.equals("1"))
		{
			tempRow = 3;
			tempCol = 1;
		}
		else if(selectedButton.equals("2"))
		{
			tempRow = 3;
			tempCol = 2;
		}
		else if(selectedButton.equals("3"))
		{
			tempRow = 3;
			tempCol = 3;
		}
		else if(selectedButton.equals("4"))
		{
			tempRow = 3;
			tempCol = 4;
		}
		else if(selectedButton.equals("5"))
		{
			tempRow = 2;
			tempCol = 1;
		}
		else if(selectedButton.equals("6"))
		{
			tempRow = 2;
			tempCol = 2;
		}
		else if(selectedButton.equals("7"))
		{
			tempRow = 2;
			tempCol = 3;
		}
		else if(selectedButton.equals("8"))
		{
			tempRow = 2;
			tempCol = 4;
		}
		else if(selectedButton.equals("9"))
		{
			tempRow = 1;
			tempCol = 1;
		}
		else if(selectedButton.equals("10"))
		{
			tempRow = 1;
			tempCol = 2;
		}
		else if(selectedButton.equals("11"))
		{
			tempRow = 1;
			tempCol = 3;
		}
		else if(selectedButton.equals("12"))
		{
			tempRow = 1;
			tempCol = 4;
		}
		HttpSession session = request.getSession(true);
		reservedTickets.add(new ReservedTicket((String)session.getAttribute("userId"),
																(String)session.getAttribute("projectionId"),
																	tempRow,
																		tempCol,
																			new Date()));
	}

}
