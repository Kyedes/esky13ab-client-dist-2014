package shared;
import java.util.ArrayList;

/**
 * CreateCalendarObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */

public class CreateCalendarObject implements java.io.Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -580896570793664110L;
	private String overallID = "deleteEvent";
	private String calendarName;
	private String privatePublic;
	private ArrayList<String> users;
	private ArrayList<String> authors;
//	private boolean imported;
	
	public ArrayList<String> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
			
	public String getPrivatePublic() {
		return privatePublic;
	}
	public void setPrivatePublic(String privatePublic) {
		this.privatePublic = privatePublic;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
//	public boolean isImported() {
//		return imported;
//	}
//	public void setImported(boolean imported) {
//		this.imported = imported;
//	}
	public CreateCalendarObject(String calendarName, String privatePublic,
			ArrayList<String> users, ArrayList<String> authors) {
		super();
		this.calendarName = calendarName;
		this.privatePublic = privatePublic;
		this.users = users;
		this.authors = authors;
	}
	
}
