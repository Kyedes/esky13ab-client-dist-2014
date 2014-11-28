package shared;

public class DeleteNoteReturnObject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -904424362046891818L;
	private boolean deleted;
	private String message;
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
