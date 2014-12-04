package serverconection;
//import javax.xml.bind.ParseConversionEvent;

//import config.Configurations;


public class Encryption {
//	Decryption path
	public String decrypt(byte[] b)
	{
		
		//kode til Configurations fil
//		Configurations CF = new Configurations();
//		Defines the decryption value of the byte
		//The 4 lines below needs to work later on, but for now, it will be hardcode
//		System.out.println(CF.getFfcryptkey());
//		System.out.println(CF.getFfcryptkey());
//		String crypKey = CF.getFfcryptkey();
//		System.out.println(crypKey);
		
		
		
		byte cryptationKeyPlaceholder = (byte) 3.1470;
//		Generates for loop containing decryption value
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^cryptationKeyPlaceholder);
		}
//		Generates new String without any white spaces following or leading
		String decrypted = new String(b).trim();
//		Returns decrypted String
		return decrypted;
	}
	
	public byte[] encrypt(String message){
		byte[] returnByteArray = new byte[500000];
		
		returnByteArray = message.getBytes();
		byte cryptationKeyPlaceholder = (byte) 3.1470;
//		Generates for loop containing decryption value
		for(int i = 0 ; i<returnByteArray.length ; i++)
		{
			returnByteArray[i] = (byte)(returnByteArray[i]^cryptationKeyPlaceholder);
		}
		
		return returnByteArray;
	}
}
