import java.net.Socket;

/**
 * This class makes it possible to communicate with the server
 * @author Esben
 *
 */
public class ServerConnection {
	
//	private String jsonOut;
	private String jsonIn;
	private byte[] bAOut = new byte[500000];
	private byte[] bAIn = new byte[500000];
	private Encryption crypt = new Encryption();
	
	/**
	 * When executing the server connection it takes a Json String and encrypt it before sending it to the server.
	 * The answer from the server is de-crypted and returned as a Json String.
	 * @param jsonOut
	 * @return
	 * @throws Exception
	 */
	
	public String execute(String jsonOut) throws Exception{
		Socket connectionSocket = new Socket("localhost", 8349);
		bAOut = crypt.encrypt(jsonOut);
		connectionSocket.getOutputStream().write(bAOut);
		int i = connectionSocket.getInputStream().read(bAIn);
//		System.out.print(i);//To do somthing with i, not nessesary
		connectionSocket.close();
		jsonIn = crypt.decrypt(bAIn);
		
		return jsonIn;
	}
}
