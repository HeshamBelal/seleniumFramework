package data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class JSONDataReader {
	public String firstName, lastName, email, password, company, city, postalCode, mobilePhone, address, addressAlias;
	private String filePath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData";
	public void getDataFromJSONFile() throws IOException, ParseException {
		File srcFile= new File(filePath);//For streaming data included in file and doing IO operations.
		JSONParser parser = new JSONParser();
		JSONArray jarray=(JSONArray)parser.parse(new FileReader(srcFile));//read data and parse it to JSON ARRAY
		for (Object obj: jarray) {
			JSONObject jsonObject=(JSONObject) obj;
			firstName=(String)jsonObject.get("firstName");
			lastName=(String)jsonObject.get("lastName");
			password=(String)jsonObject.get("password");
			company=(String)jsonObject.get("company");
			city=(String)jsonObject.get("city");
			postalCode=(String)jsonObject.get("postalCode");
			mobilePhone=(String)jsonObject.get("mobile");
			address=(String)jsonObject.get("address");
			addressAlias=(String)jsonObject.get("addressAlias");
			email=(String)jsonObject.get("email");
		}
	}
}
