package qa.testcases.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;

public class DataReader {

	
	public  List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//readjson to string
	String jsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir"),"\\src\\test\\java\\qa\\testcases\\data\\PurchageOrder.json"),
			StandardCharsets.UTF_8);
		//String to HashMap
	//Jackson Datanind
	ObjectMapper mapper=new ObjectMapper();
	
	
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>> () {
	});
		//{map,map1}	
		
		return data;
	}
	
	
	
	
	
	
	
}
