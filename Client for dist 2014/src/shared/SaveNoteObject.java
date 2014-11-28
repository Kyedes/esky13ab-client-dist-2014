package shared;
/**
 * SaveNoteObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */
public class SaveNoteObject implements java.io.Serializable
{
	
	private static final long serialVersionUID = 1269487144151426011L;
	private String overallID = "saveNote";
	private String userEmail;
	private String noteContent;
	private String eventName;
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String noteAuthor) {
		this.userEmail = noteAuthor;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String noteEvent) {
		this.eventName = noteEvent;
	}
	
	

}
