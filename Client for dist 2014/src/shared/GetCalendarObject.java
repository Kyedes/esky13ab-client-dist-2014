package shared;
/**
 * GetCalendarObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */
public class GetCalendarObject implements java.io.Serializable {
	
	private static final long serialVersionUID = 1067887168456410585L;
	private String overallID = "getCalendar";
	private String userName;
	
	public String getOverallID() {
		return overallID;
	}
	
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserID(String userName) {
		this.userName = userName;
	}
}
