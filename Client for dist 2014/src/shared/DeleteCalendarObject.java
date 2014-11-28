package shared;
/**
 * DeleteCalendarObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */
public class DeleteCalendarObject implements java.io.Serializable
{
	private static final long serialVersionUID = 4429483023071064697L;
	private String overallID = "getCalendar";
	private String calendarToDelete;
	private String userID;
	
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getCalendarToDelete() {
		return calendarToDelete;
	}
	public void setCalendarToDelete(String calendarToDelete) {
		this.calendarToDelete = calendarToDelete;
	}
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}

}
