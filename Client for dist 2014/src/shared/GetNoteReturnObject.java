package shared;

public class GetNoteReturnObject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2753301492062531168L;
	private String message;
	
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
