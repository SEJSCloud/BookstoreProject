package jsonfile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import bookstore.crawling.bookstoreCrawling;

public class JsonFile {
	ArrayList<String> Array = new ArrayList<String>();
	ArrayList<String> publishMonthArray = new ArrayList<String>();
	ArrayList<String> priceArray = new ArrayList<String>();
	ArrayList<Integer> discountRateArray = new ArrayList<Integer>();
	
	public static void setJsonFile(String filename, int req) {

		bookstoreCrawling crawling = bookstoreCrawling.getInstance();

		try {
			
			FileWriter file = new FileWriter("C:\\0.encore\\01.java\\BookstoreProject\\bookstoreProject\\BookList.json" + filename);
			if (req == 1) {
				file.write(crawling.getBookList().toString());
			}else if(req == 2) {
				file.write(crawling.getBookList().toString());
			}else if(req == 3) {
				file.write(crawling.getBookList().toString());
			}
			file.flush();
			file.close();

		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public ArrayList<String>  getJsonStringKey(String key, String filename) {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\0.encore\\01.java\\BookstoreProject\\bookstoreProject\\" + filename));
			JSONArray jsonArray = (JSONArray) obj;
			
			for( int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				Array.add((String) jsonObject.get(key));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Array;
	}
}
