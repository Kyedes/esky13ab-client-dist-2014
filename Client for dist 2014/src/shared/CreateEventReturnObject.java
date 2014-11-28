package shared;
import java.io.Serializable;


public class CreateEventReturnObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7379864247491380334L;
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
	public CreateEventReturnObject(boolean created, String message) {
		super();
		this.created = created;
		this.message = message;
	}
}
