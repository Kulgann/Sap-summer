package sap.project1;

import java.util.Date;
import java.util.List;

public class TicketControl {
	
	final static long toleranceForPaymentInMs = 600000; // 10 min
	
	public static void Purge(List<ReservedTicket> resTickets, Date timeOfPurge)
	{
		for(int i = 0; i < resTickets.size(); i++)
		{
			if((resTickets.get(i).getTimeOfCreation().getTime() + toleranceForPaymentInMs) < timeOfPurge.getTime() )
			{
				resTickets.remove(i);
				i--; // To compensate for the indices of the elements after the removed one being reduced by 1
			}
		}
	}

	public static class ReservedTicket
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
