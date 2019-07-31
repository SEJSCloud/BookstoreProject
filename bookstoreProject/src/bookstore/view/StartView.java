package bookstore.view;

import bookstore.crawling.bookstoreCrawling;
import bookstore.model.dto.BookDTO;
import bookstore.service.BookstoreController;

public class StartView {
	

	
	
	public static void main(String[] args) {
		
		BookstoreController controller = BookstoreController.getInstance();
		
		
		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();
//		for(Integer a : crawliing.getBookListDiscountRate()){
//			System.out.println(a.intValue());
//		}
		for(BookDTO a : crawliing.getBookList()) {
			controller.addBook(a);
		}
		
		
				

	}

}
