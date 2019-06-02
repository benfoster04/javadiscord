package <your package here>;

import <your package here>.Embed;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Ben Foster wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 * Legally, this code is actually licensed under the MIT License.
 */
public class Webhook {
	private String usra = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";
	private URL url = null;
	public Webhook(String param) {
		try {this.url = new URL(param);
		} catch ( MalformedURLException e ) {e.printStackTrace();}
	}
	private HttpURLConnection connect() {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) this.url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", usra);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);
		} catch ( Exception e ) {connection = null;}
		return connection;
	}
	public boolean send(Embed msg) {
		String body = msg.rtrn().toJSONString();
		System.out.println(body);
		HttpURLConnection connection = this.connect();
		if ( connection == null ) {return false;}
		DataOutputStream outStream;
		try {
			outStream = new DataOutputStream(connection.getOutputStream());
			outStream.writeBytes(body);
			outStream.flush();
			outStream.close();
		} catch (IOException e) {
			System.out.println("post ioexc"+e.getStackTrace().toString());
			return false;
		}
		try {
			System.out.println("Response: "+connection.getResponseCode());
			if ( connection.getResponseCode() != 200 ) {return false;}
		} catch ( IOException e ) {return false;}
		return true;
	}
}
