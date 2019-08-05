package bookstore.json;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;

public class JsonFileRead {
	ArrayList<BookDTO> bookArray = new ArrayList<BookDTO>();
	ArrayList<AuthorDTO> authorArray = new ArrayList<AuthorDTO>();
	ArrayList<PublisherDTO> publisherArray = new ArrayList<PublisherDTO>();
	ArrayList<TranslatorDTO> translatorArray = new ArrayList<TranslatorDTO>();

	public JsonFileRead() {
	}
	public ArrayList<BookDTO> getJsonBookList() {
		try {
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(
					new FileReader("C:\\0.encore\\01.java\\bookstoreProject\\jsonBookList.json"));
			JSONArray jsonArray = (JSONArray) obj;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayGet = ((JSONObject) jsonArray.get(i));
				BookDTO a = new BookDTO(
						0, 
						jsonArrayGet.get("title").toString(),
						jsonArrayGet.get("publishMonth").toString(), 
						jsonArrayGet.get("price").toString(),
						Integer.parseInt(jsonArrayGet.get("discountRate").toString()), 
						jsonArrayGet.get("authorId").toString(),
						jsonArrayGet.get("translatorId").toString(), 
						jsonArrayGet.get("publisherId").toString());
				bookArray.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookArray;
	}
	
	public ArrayList<AuthorDTO> getJsonAuthorList() {
		try {
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(
					new FileReader("C:\\0.encore\\01.java\\bookstoreProject\\jsonAuthorList.json"));
			JSONArray jsonArray = (JSONArray) obj;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayGet = ((JSONObject) jsonArray.get(i));
				AuthorDTO a = new AuthorDTO(0, jsonArrayGet.get("authorName").toString());
				authorArray.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return authorArray;
	}
	
	public ArrayList<PublisherDTO> getJsonPublisherList() {
		try {
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(
					new FileReader("C:\\0.encore\\01.java\\bookstoreProject\\jsonPublisherList.json"));
			JSONArray jsonArray = (JSONArray) obj;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayGet = ((JSONObject) jsonArray.get(i));
				PublisherDTO a = new PublisherDTO(0, jsonArrayGet.get("publisherName").toString());
				publisherArray.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return publisherArray;
	}
	
	public ArrayList<TranslatorDTO> getJsonTranslatorList() {
		try {
			JSONParser parser = new JSONParser();

			Object obj = parser.parse(
					new FileReader("C:\\0.encore\\01.java\\bookstoreProject\\jsonTranslatorList.json"));
			JSONArray jsonArray = (JSONArray) obj;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonArrayGet = ((JSONObject) jsonArray.get(i));
				TranslatorDTO a = new TranslatorDTO(0, jsonArrayGet.get("translatorName").toString());
				translatorArray.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return translatorArray;
	}

}
