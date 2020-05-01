package data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class LoadProperties {
	public static Properties userData = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userData.properties");//converts the properties file to properties variable for direct use by the test methods
	public static Properties SauceLabData = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\SauceLabsData.properties");

	public static Properties loadProperties(String filePath) {
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(filePath); //create a new fileStream for the properties testData.
			pro.load(stream);//load the data from stream variable to properties variable
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
}