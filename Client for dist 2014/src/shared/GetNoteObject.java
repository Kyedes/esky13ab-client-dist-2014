package shared;
/**
 * GetNoteObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */
public class GetNoteObject implements java.io.Serializable
{

	private static final long serialVersionUID = 7114909483629186981L;
	private String overallID = "getCalendar";
	private String eventID;
	private String authorID;
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
}

