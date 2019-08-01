package bookstore.view;

import bookstore.crawling.bookstoreCrawling;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
import bookstore.service.BookstoreController;
import net.sf.json.JSONArray;

public class StartView {

	public static void main(String[] args) {
<<<<<<< HEAD
		BookstoreController controller = BookstoreController.getInstance();
		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();
//		for (JSONArray a : crawliing.getBookList()) {
//			controller.addBook(a);
//		}
		System.out.println(crawliing.getBookList() );
=======

		BookstoreController controller = BookstoreController.getInstance();
		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();

//		for(AuthorDTO a : crawliing.getAuthorList()){
//			System.out.println(a);
//		}

		for (BookDTO a : crawliing.getBookList()) {
			controller.addBook(a);
		}
		for (AuthorDTO a : crawliing.getAuthorList()) {
//			System.out.println(a);
			controller.addAuthor(a);
		}
		for (PublisherDTO a : crawliing.getPublisherList()) {
			controller.addPublisher(a);
		}
//		for (TranslatorDTO a : crawliing.getTranslatorList()) {
//			controller.addTranslator(a);
//		}

>>>>>>> 677505e638b72f011ee2c40e06e4093feaca3157
	}

}
