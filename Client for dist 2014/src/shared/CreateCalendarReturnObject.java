package shared;

public class CreateCalendarReturnObject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5395651291709879818L;
	private boolean created;
	private String message;
	public boolean isCreated() {
		return created;
	}
	public void setCreated(boolean created) {
		this.created = created;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
