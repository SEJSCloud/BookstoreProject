package bookstore.crawling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParsing {

	public static void setJsonFile() {

		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();

		try {

			FileWriter file = new FileWriter("C:\\0.encore\\01.java\\BookstoreProject\\bookstoreProject\\test2.json");
			file.write(crawliing.getBookList().toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(crawliing.getBookList());

	}

	public static void  getJsonFile() {
		
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("C:\\0.encore\\01.java\\BookstoreProject\\bookstoreProject\\test2.json"));
			JSONArray jsonArray = (JSONArray) obj;
			//JSONObject jsonObject = (JSONObject)jsonArray.get(0);
			
			for( int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
				System.out.println(jsonObject.get("title"));
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}
}
