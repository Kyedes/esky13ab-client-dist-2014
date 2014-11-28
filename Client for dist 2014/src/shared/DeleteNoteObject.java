package shared;
/**
 * DeleteNoteObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */
public class DeleteNoteObject implements java.io.Serializable{
	
	private static final long serialVersionUID = 1026261677650219409L;
	private String overallID = "deleteNote";
	private String eventID;
	private String userID;
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String noteToDelete) {
		this.eventID = noteToDelete;
	}
	public String getAuthNote() {
		return userID;
	}
	public void setAuthNote(String authNote) {
		this.userID = authNote;
	}
	
}
