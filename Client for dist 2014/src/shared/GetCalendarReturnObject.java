package shared;
import java.io.Serializable;
import java.util.ArrayList;


public class GetCalendarReturnObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7247432067102109583L;
	
	private ArrayList<ArrayList<Event>> calendars;

	public ArrayList<ArrayList<Event>> getCalendars() {
		return calendars;
	}

	public void setCalendars(ArrayList<ArrayList<Event>> calendars) {
		this.calendars = calendars;
	}
	
}
