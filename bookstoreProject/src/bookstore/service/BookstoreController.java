package bookstore.service;

import java.sql.SQLException;

import bookstore.model.bookstoreService;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
import bookstore.view.EndView;
import bookstore.view.FailView;
import bookstore.view.SuccessView;

public class BookstoreController {

	private bookstoreService service = bookstoreService.getInstance();

	private static BookstoreController instance = new BookstoreController();

	public static BookstoreController getInstance() {
		return instance;
	}

	// 모든 책 검색 로직
	public void getAllBook() {
		try {
			EndView.bookListView(service.getAllbooks());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 책 리스트 검색시 에러 발생");
		}
	}

	// 개별 책 검색 로직
	public void getBook(int bookId) {
		try {
			EndView.bookView(service.getBook(bookId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("책 검색시 에러 발생");
		}
	}

	// 새로운 책 저장 로직
	public void addBook(BookDTO book) {
		try {
			if(service.addBook(book) == true) {
				SuccessView.showSuccess("새로운 책 저장 성공");
			}else {
				FailView.showFail("새로운 책 저장 실패");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("새로운 책 저장시 에러 발생");
		}
	}
	

	// 책 수정 로직
	public void updateBook(int bookId, String bookName) {
		try {
			service.updateBook(bookId, bookName);
			SuccessView.showSuccess("책 수정 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("책 정보 수정시 에러 발생");
		}
	}

	// 책 삭제 로직
	public void deleteBook(int bookId) {
		try {
			service.deleteBook(bookId);
			SuccessView.showSuccess("책 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("책 삭제시 에러 발생");
		}
	}
	
	public void authorDeleteBook(int authorId) {
		try {
			service.authorDeleteBook(authorId);
			SuccessView.showSuccess("저자 ID로 책 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("저자 ID로 책 삭제시 에러 발생");
		}
	}
	
	public void publisherDeleteBook(int publisherId) {
		try {
			service.publisherDeleteBook(publisherId);
			SuccessView.showSuccess("출판사 ID로 책 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("출판사 ID로 책 삭제시 에러 발생");
		}
	}
	
	public void translatorDeleteBook(int translatorId) {
		try {
			service.translatorDeleteBook(translatorId);
			SuccessView.showSuccess("번역가 ID로 책 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("번역가 ID로 책 삭제시 에러 발생");
		}
	}
	
//**************************************************************

	// 모든 저자 정보 검색
	public void getAllAuthor() {
		try {
			EndView.authorListView(service.getAllAuthors());
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("모든 저자 검색시 오류발생 ");
		}
	}

	// 저자 정보 검색
	public void getAuthor(int authorId) {
		try {
			EndView.authorView(service.getAuthor(authorId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("해당 저자 검색 오류 ");
		}
	}

	// 저자 아이디로 저자 목적 수정
	public void updateAuthor(int authorId, String authorName) {
		try {
			service.updateAuthor(authorId, authorName);
			SuccessView.showSuccess("저자 이름 변경 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("저자 이름 변경 오류");
		}
	}

	// 저자 저장 로직
	public void addAuthor(AuthorDTO author) {
		try {
			service.addAuthor(author);
			SuccessView.showSuccess("새로운 저자 저장 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("저자 저장시 에러 발생");
		}
	}
	
	public void addAuthor2() {
		try {
			service.addAuthor2();
			SuccessView.showSuccess("저자 이름 중복제거 후 insert 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("저자 이름 중복제거 후 insert시 에러 발생");
		}
	}
	
	public void addAuthorName(AuthorDTO Author) {
		try {
			if(service.addAuthorName(Author) == true) {
				SuccessView.showSuccess("새로운 저자 이름 저장 성공");
			}else {
				FailView.showFail("새로운 저자 이름 저장 실패");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("새로운 저자 이름 저장시 에러 발생");
		}
	}

	// 저자 삭제 로직
	public void deleteAuthor(int authorId) {
		try {
			service.deleteAuthor(authorId);
			SuccessView.showSuccess("저자 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("저자 삭제시 에러 발생");
		}
	}
	
	
//**************************************************************

	// 모든 번역가 검색 로직
	public void getAllTranslator() {
		try {
			EndView.translatorListView(service.getAllTranslators());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 재능 번역가 검색시 에러 발생");
		}
	}

	// 재능 번역가 검색 로직
	public void getTranslator(int translatorId) {
		try {
			EndView.translatorView(service.getTranslator(translatorId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("재능 번역가 검색시 에러 발생");
		}
	}

	// 새로운 재능 번역가 저장 로직
	public void addTranslator2() {
		try {
			service.addTranslator2();
			SuccessView.showSuccess("번역가 이름 중복제거 후 insert 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("번역가 이름 중복제거 후 insert시 에러 발생");
		}
	}
	
	public void addTranslator(TranslatorDTO translator) {
		try {
			service.addTranslator(translator);
			SuccessView.showSuccess("새로운 번역가 저장 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("새로운 번역가 저장시 에러 발생");
		}
	}
	
	public void addTranslatorName(TranslatorDTO translator) {
		try {
			if(service.addTranslatorName(translator) == true) {
				SuccessView.showSuccess("새로운 번역가이름 저장 성공");
			}else {
				FailView.showFail("새로운 번역가이름 저장 실패");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("새로운 번역가이름 저장시 에러 발생");
		}
	}

	// 번역가 정보 수정 로직
	public void updateTranslator(int translatorId, String translatorName) {
		try {
			service.updateTranslator(translatorId, translatorName);
			SuccessView.showSuccess("번역가 정보 수정 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("번역가 정보 수정시 에러 발생");
		}
	}

	// 번역가 정보 삭제 로직
	public void deleteTranslator(int translatorId) {
		try {
			service.deleteTranslator(translatorId);
			SuccessView.showSuccess("번역가 정보 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("번역가 정보 삭제시 에러 발생");
		}
	}

//**************************************************************	
	
	// 모든 출판사 검색 로직
	public void getAllPublisher() {
		try {
			EndView.publisherListView(service.getAllPublishers());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 출판사 검색시 에러 발생");
		}
	}

	// 출판사 검색 로직
	public void getPublisher(int publisherId) {
		try {
			EndView.publisherView(service.getPublisher(publisherId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("출판사 검색시 에러 발생");
		}
	}

	// 새로운 출판사 저장 로직
	public void addPublisher(PublisherDTO publisher) {
		try {
			service.addPublisher(publisher);
			SuccessView.showSuccess("새로운 출판사 정보 저장 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("새로운 출판사 정보 저장시 에러 발생");
		}
	}
	
	public void addPublisher2() {
		try {
			service.addPublisher2();
			SuccessView.showSuccess("출판사 이름 중복제거 후 insert 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("출판사 이름 중복제거 후 insert시 에러 발생");
		}
	}
	
	public void addPublisherName(PublisherDTO Publisher) {
		try {
			if(service.addPublisherName(Publisher) == true) {
				SuccessView.showSuccess("새로운 출판사 이름 저장 성공");
			}else {
				FailView.showFail("새로운 출판사 이름 저장 실패");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("새로운 출판사 이름 저장시 에러 발생");
		}
	}

	// 출판사 정보 수정 로직
	public void updatePublisher(int publisherId, String publisherName) {
		try {
			service.updatePublisher(publisherId, publisherName);
			SuccessView.showSuccess("출판사 정보 수정 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("출판사 정보 수정시 에러 발생");
		}
	}

	// 출판사 정보 삭제 로직
	public void deletePublisher(int publisherId) {
		try {
			service.deletePublisher(publisherId);
			SuccessView.showSuccess("출판사 정보 삭제 성공");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("출판사 정보 삭제시 에러 발생");
		}
	}

}
