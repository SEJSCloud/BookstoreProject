package bookstore.view;

import bookstore.crawling.bookstoreCrawling;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
import bookstore.service.BookstoreController;

public class StartView {

	public static void main(String[] args) {

		BookstoreController controller = BookstoreController.getInstance();
		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();

//		for (BookDTO a : crawliing.getBookList()) {
//			controller.addBook(a);
//		}

		for (TranslatorDTO a : crawliing.getTransLatorNameList()) {
			controller.addTranslatorName(a);
		}
		
		for (AuthorDTO a : crawliing.getAuthorList()) {
			controller.addAuthorName(a);
		}
		
		for (PublisherDTO a : crawliing.getPublisherList()) {
			controller.addPublisherName(a);
		}

	}

}
