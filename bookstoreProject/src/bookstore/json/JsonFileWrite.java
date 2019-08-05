package bookstore.json;

import java.io.FileWriter;
import java.io.IOException;

import bookstore.crawling.bookstoreCrawling;
import net.sf.json.JSONArray;

public class JsonFileWrite {
	
	public static void setJsonFile(int req) {
		bookstoreCrawling crawling = bookstoreCrawling.getInstance();
		JSONArray jsonBookList = JSONArray.fromObject(crawling.getBookList());
		JSONArray jsonAuthorList = JSONArray.fromObject(crawling.getAuthorList());
		JSONArray jsonPublisherList = JSONArray.fromObject(crawling.getPublisherList());
		JSONArray jsonTranslatorList = JSONArray.fromObject(crawling.getTranslatorList());
		try {
			if (req == 1) {
				FileWriter file = new FileWriter(
						"C:\\0.encore\\01.java\\bookstoreProject\\jsonBookList.json");
				file.write(jsonBookList.toString());
				file.flush();
				file.close();
				System.out.println("jsonBookList.json 积己肯丰");
			} else if (req == 2) {
				FileWriter file = new FileWriter(
						"C:\\0.encore\\01.java\\bookstoreProject\\jsonAuthorList.json");
				file.write(jsonAuthorList.toString());
				file.flush();
				file.close();
				System.out.println("jsonAuthorList.json 积己肯丰");
			} else if (req == 3) {
				FileWriter file = new FileWriter(
						"C:\\0.encore\\01.java\\bookstoreProject\\jsonPublisherList.json");
				file.write(jsonPublisherList.toString());
				file.flush();
				file.close();
				System.out.println("jsonPublisherList.json 积己肯丰");
			} else if (req == 4) {
				FileWriter file = new FileWriter(
						"C:\\0.encore\\01.java\\bookstoreProject\\jsonTranslatorList.json");
				file.write(jsonTranslatorList.toString());
				file.flush();
				file.close();
				System.out.println("jsonTranslatorList.json 积己肯丰");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
