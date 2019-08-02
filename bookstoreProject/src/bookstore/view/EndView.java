package bookstore.view;

import java.util.ArrayList;

import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;

public class EndView {

	// 모든 프로젝트 출력
//	public static void allListView(ArrayList allProbonoProject) {
//		int length = allProbonoProject.size();
//		if (length != 0) {
//			for (int index = 0; index < length; index++) {
//				System.out.println("검색정보 " + (index + 1) + " - " + allProbonoProject.get(index));
//			}
//		}
//	}
	
	
	public static void bookListView(ArrayList<BookDTO> allBook) {
		int length = allBook.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allBook.get(index));
			}
		}
		SuccessView.showSuccess("모든 책리스트 검색 성공");
	}
	
	public static void translatorListView(ArrayList<TranslatorDTO> allTranslator) {
		int length = allTranslator.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allTranslator.get(index));
			}
		}
		SuccessView.showSuccess("모든 번역가 검색 성공");
	}
	
	public static void publisherListView(ArrayList<PublisherDTO> allPublisher) {
		int length = allPublisher.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allPublisher.get(index));
			}
		}
		SuccessView.showSuccess("모든 출판사 검색 성공");
	}
	
	public static void authorListView(ArrayList<AuthorDTO> allAuthor) {
		int length = allAuthor.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allAuthor.get(index));
			}
		}
		SuccessView.showSuccess("모든 작가 검색 성공");
	}
	
	public static void authorWriteListView(ArrayList<String> allAuthorName) {
		int length = allAuthorName.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allAuthorName.get(index));
			}
		}
		SuccessView.showSuccess("책의 저자 검색 성공");
	}
	
	public static void bookWriteListView(ArrayList<String> allBookName) {
		int length = allBookName.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allBookName.get(index));
			}
		}
		SuccessView.showSuccess("저자의 책 검색 성공");
	}
	
	public static void authorTranslatingListView(ArrayList<String> allTranslatorName) {
		int length = allTranslatorName.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allTranslatorName.get(index));
			}
		}
		SuccessView.showSuccess("책의 번역가 검색 성공");
	}
	
	public static void bookTranslatingListView(ArrayList<String> allBookName) {
		int length = allBookName.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allBookName.get(index));
			}
		}
		SuccessView.showSuccess("번역가의 책 검색 성공");
	}
	
	
	

	// DTO 정보 출력하는 메소드
//	public static void allView(Object project) {
//		System.out.println(project);
//	}
	
	public static void bookView(BookDTO book) {
		System.out.println(book);
		SuccessView.showSuccess("책 검색 성공");
	}

	public static void translatorView(TranslatorDTO translator) {
		System.out.println(translator);
		SuccessView.showSuccess("번역가 검색 성공");
	}

	public static void publisherView(PublisherDTO publisher) {
		System.out.println(publisher);
		SuccessView.showSuccess("출판사 검색 성공");
	}

	public static void authorView(AuthorDTO author) {
		System.out.println(author);
		SuccessView.showSuccess("저자 검색 성공");
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}
}
