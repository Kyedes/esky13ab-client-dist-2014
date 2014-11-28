package shared;

/**
 * CreateEventObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */

public class CreateEventObject implements java.io.Serializable

{
	private static final long serialVersionUID = 603624733895783558L;
	private String overallID = "createEvent";
	private String type;
	private String eventName;
	private String description;
	private String location;
	private String createdby;
	private String calendarName;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCalendarName() {
		return calendarName;
	}
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String stratTime) {
		this.startTime = stratTime;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	

	
}
