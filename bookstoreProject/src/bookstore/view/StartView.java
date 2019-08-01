package bookstore.view;

import bookstore.crawling.bookstoreCrawling;
import bookstore.model.dto.BookDTO;
import bookstore.service.BookstoreController;
import net.sf.json.JSONArray;

public class StartView {

	public static void main(String[] args) {
		BookstoreController controller = BookstoreController.getInstance();
		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();
//		for (JSONArray a : crawliing.getBookList()) {
//			controller.addBook(a);
//		}
		System.out.println(crawliing.getBookList() );
	}

}
