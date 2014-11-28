package shared;
/**
 * DeleteEventObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */
public class DeleteEventObject implements java.io.Serializable{
	
	private static final long serialVersionUID = -4749520182118516370L;
	private String overallID = "deleteEvent";
	private String eventToDelete;
	private String userID;
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getEventToDelete() {
		return eventToDelete;
	}
	public void setEventToDelete(String eventToDelete) {
		this.eventToDelete = eventToDelete;
	}
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}

}
