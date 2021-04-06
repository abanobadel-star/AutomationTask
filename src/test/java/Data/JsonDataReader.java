package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

	public String username, password;


	public void JsonReader() throws IOException, ParseException {

		String filePath = System.getProperty("user.dir")+"/src/test/java/Data/data.json"; //to get path for json data
		File srcFile = new File(filePath);   //get object from file
		JSONParser parser = new JSONParser();  //get object from jsonreader
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile));

		for(Object jsonObj : jarray)
		{
			JSONObject usersObj = (JSONObject) jsonObj ;
			username = (String) usersObj.get("username");
			password = (String) usersObj.get("password");

		}
	}
}