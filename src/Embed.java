package <your package here>;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
public class Embed {
	private String _title;
	private String _description;
	private int _colour;
	private String _time = now();
	private String now() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:s.S'Z'");
		df.setTimeZone(tz);
		return df.format(new Date());
	}
	private static int toDec(String hex) {
		String digits = "0123456789ABCDEF";
		hex.toUpperCase();
		int val = 0;
		for ( int i = 0; i < hex.length(); i++ ) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			val = 16*val+d;
		}
		return val;
	}
	public Embed() {
		
		this._title = null;
		this._description = null;
		this._colour = 2752554;
	}
	
	public Embed( String title ) {
		this._title = title;
		this._description = null;
		this._colour = 2752554;
	}
	public Embed( String title, String description ) {
		this._title = title;
		this._description = description;
		this._colour = 2752554;
	}
	public Embed( String title, String description, String colour ) {
		this._title = title;
		this._description = description;
		if ( colour.length() != 6 ) {this._colour = 2752554;}
		else {this._colour = toDec(colour);}
	}
	public void setTitle( String title ) {this._title = title;}
	public void setDesc( String description ) {this._description = description;}
	public void setColour( String hex ) {
		if ( hex.length() != 6 ) {this._colour = 2752554;}
		else {this._colour = toDec(hex);}
	}
	@SuppressWarnings("unchecked")
	public JSONObject rtrn() {
		JSONObject j = new JSONObject();
		JSONArray embeds = new JSONArray();
		j.put("embeds",embeds);
		JSONObject embedChild = new JSONObject();
		if ( _title == null && _description == null ) {
			embedChild.put("title", "Error in code!");
			embedChild.put("description", "Uhoh, it looks like someone didn't read the documentation properly.\nWhat's happened is that you've not defined the title or description of the embed before sending it.\nPlease in future, read the fucking manual: github.com/benfoster04/javadiscord");
			embedChild.put("color","FF0000");
		} else {
			if ( _title != null ) {embedChild.put("title", _title);}
			else {
				if ( _description != null ) {embedChild.put("description", _description);}
			}
		}
		embedChild.put("color", _colour);
		embedChild.put("timestamp", _time);
		embeds.add(embedChild);
		return j;
	}
}
