package shared;
/**
 * QuoteObject is a transfer object class to transfer information to the server.
 * It contains the necessary information to execute the operation.
 * @author Esben
 *
 */

public class QuoteObject {

	private String quote;
	private String author;
	private String subject;
	
	public QuoteObject(){
		
	}
	
	public QuoteObject(String quote, String author, String subject) {
		super();
		this.quote = quote;
		this.author = author;
		this.subject = subject;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}

