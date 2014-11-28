package shared;
import java.io.Serializable;


public class SaveNoteReturnObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2620690780592970553L;
	private boolean updated;
	private String message;
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
