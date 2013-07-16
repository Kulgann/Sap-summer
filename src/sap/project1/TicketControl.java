package sap.project1;

import java.util.Date;

public class TicketControl {
	

	public class ReservedTicket
	{
		String user_id;
		String projection_id;
		int row;
		int col;
		Date timeOfCreation;
		
		public ReservedTicket(String u_id, String p_id, int ro, int co, Date date)
		{
			user_id = u_id;
			projection_id = p_id;
			row = ro;
			col = co;
			timeOfCreation = date;
		}
		public String getUserId()
		{
			return user_id;
		}
		public String getProjectionId()
		{
			return projection_id;
		}
		public int getRow()
		{
			return row;
		}
		public int getColumn()
		{
			return col;
		}
		public Date getTimeOfCreation()
		{
			return timeOfCreation;
		}
	}
}
