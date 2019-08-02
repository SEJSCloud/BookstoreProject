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

//		for (TranslatorDTO a : crawliing.getTransLatorNameList()) {
//			controller.addTranslatorName(a);
//		}
//		for (AuthorDTO a : crawliing.getAuthorList()) {
//			controller.addAuthorName(a);
//		}
//		for (PublisherDTO a : crawliing.getPublisherList()) {
//			controller.addPublisherName(a);
//		}

		// 모든 book테이블 정보 출력
//		controller.getAllBook();
//
//		// 모든 author테이블 정보 출력
//		controller.getAllAuthor();
//
//		// 모든 publisher테이블 정보 출력
//		controller.getAllPublisher();
//
//		// 모든 translator테이블 정보 출력
//		controller.getAllTranslator();

		controller.getBook(3);
		controller.deleteBook(3);
		controller.getBook(3);

		controller.getAuthor(4);
		
		System.out.println();
		System.out.println();
		
		controller.deleteAuthor(4);
		controller.getAuthor(4);
		
		System.out.println();
		System.out.println();
		
		controller.authorDeleteBook(4);
		controller.deleteAuthor(4);
		controller.getAuthor(4);
		
		System.out.println();
		System.out.println();
		
		controller.getPublisher(5);
		
		System.out.println();
		System.out.println();
		
		controller.deletePublisher(5);
		controller.getPublisher(5);
		
		System.out.println();
		System.out.println();
		
		controller.publisherDeleteBook(5);
		controller.deletePublisher(5);
		controller.getPublisher(5);
		
		System.out.println();
		System.out.println();
		
		controller.getTranslator(6);
		
		System.out.println();
		System.out.println();
		
		controller.deleteTranslator(6);
		controller.getTranslator(6);
		
		System.out.println();
		System.out.println();
		
		controller.translatorDeleteBook(6);
		controller.deleteTranslator(6);
		controller.getTranslator(6);
	}

}
