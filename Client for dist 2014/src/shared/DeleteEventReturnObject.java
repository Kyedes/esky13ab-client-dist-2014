package shared;

public class DeleteEventReturnObject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6929787423780799387L;
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
