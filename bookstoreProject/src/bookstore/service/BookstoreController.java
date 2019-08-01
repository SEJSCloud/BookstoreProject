package bookstore.service;

import java.sql.SQLException;

import bookstore.model.bookstoreService;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
import bookstore.view.EndView;
import bookstore.view.SuccessView;
import net.sf.json.JSONArray;

public class BookstoreController {

	private bookstoreService service = bookstoreService.getInstance();

	private static BookstoreController instance = new BookstoreController();

	public static BookstoreController getInstance() {
		return instance;
	}

	// ��� å �˻� ����
	public void getAllBook() {
		try {
			EndView.bookListView(service.getAllbooks());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� å ����Ʈ �˻��� ���� �߻�");
		}
	}

	// ���� å �˻� ����
	public void getBook(int bookId) {
		try {
			EndView.bookView(service.getBook(bookId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("å �˻��� ���� �߻�");
		}
	}

	// ���ο� å ���� ����
	public void  addBook(JSONArray book) {
		try {
			if(service.addBook(book) == true) {
				SuccessView.showSuccess("���ο� å ���� ����");
			}else {
				EndView.showError("���ο� å ���� ����");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("���ο� å ����� ���� �߻�");
		}
	}

	// å ���� ����
	public void updateBook(int bookId, String bookName) {
		try {
			service.updateBook(bookId, bookName);
			SuccessView.showSuccess("å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("å ���� ������ ���� �߻�");
		}
	}

	// å ���� ����
	public void deleteBook(int bookId) {
		try {
			service.deleteBook(bookId);
			SuccessView.showSuccess("å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("å ������ ���� �߻�");
		}
	}
	
	
//**************************************************************

	// ��� ���� ���� �˻�
	public void getAllAuthor() {
		try {
			EndView.authorListView(service.getAllAuthors());
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("��� ���� �˻��� �����߻� ");
		}
	}

	// ���� ���� �˻�
	public void getAuthor(int authorId) {
		try {
			EndView.authorView(service.getAuthor(authorId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("�ش� ���� �˻� ���� ");
		}
	}

	// ���� ���̵�� ���� ���� ����
	public void updateAuthor(int authorId, String authorName) {
		try {
			service.updateAuthor(authorId, authorName);
			SuccessView.showSuccess("���� �̸� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� �̸� ���� ����");
		}
	}

	// ���� ���� ����
	public void addAuthor(AuthorDTO author) {
		try {
			service.addAuthor(author);
			SuccessView.showSuccess("���ο� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� ����� ���� �߻�");
		}
	}

	// ���� ���� ����
	public void deleteAuthor(int authorId) {
		try {
			service.deleteAuthor(authorId);
			SuccessView.showSuccess("���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� ������ ���� �߻�");
		}
	}
	
	
//**************************************************************

	// ��� ������ �˻� ����
	public void getAllTranslator() {
		try {
			EndView.translatorListView(service.getAllTranslators());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ��� ������ �˻��� ���� �߻�");
		}
	}

	// ��� ������ �˻� ����
	public void getTranslator(int translatorId) {
		try {
			EndView.translatorView(service.getTranslator(translatorId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("��� ������ �˻��� ���� �߻�");
		}
	}

	// ���ο� ��� ������ ���� ����
	public void addTranslator(TranslatorDTO translator) {
		try {
			service.addTranslator(translator);
			SuccessView.showSuccess("���ο� ������ ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ο� ������ ����� ���� �߻�");
		}
	}

	// ������ ���� ���� ����
	public void updateTranslator(int translatorId, String translatorName) {
		try {
			service.updateTranslator(translatorId, translatorName);
			SuccessView.showSuccess("������ ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("������ ���� ������ ���� �߻�");
		}
	}

	// ������ ���� ���� ����
	public void deleteTranslator(int translatorId) {
		try {
			service.deleteTranslator(translatorId);
			SuccessView.showSuccess("������ ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("������ ���� ������ ���� �߻�");
		}
	}

//**************************************************************	
	
	// ��� ���ǻ� �˻� ����
	public void getAllPublisher() {
		try {
			EndView.publisherListView(service.getAllPublishers());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ���ǻ� �˻��� ���� �߻�");
		}
	}

	// ���ǻ� �˻� ����
	public void getPublisher(int publisherId) {
		try {
			EndView.publisherView(service.getPublisher(publisherId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� �˻��� ���� �߻�");
		}
	}

	// ���ο� ���ǻ� ���� ����
	public void addPublisher(PublisherDTO publisher) {
		try {
			service.addPublisher(publisher);
			SuccessView.showSuccess("���ο� ���ǻ� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ο� ���ǻ� ���� ����� ���� �߻�");
		}
	}

	// ���ǻ� ���� ���� ����
	public void updatePublisher(int publisherId, String publisherName) {
		try {
			service.updatePublisher(publisherId, publisherName);
			SuccessView.showSuccess("���ǻ� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� ���� ������ ���� �߻�");
		}
	}

	// ���ǻ� ���� ���� ����
	public void deletePublisher(int publisherId) {
		try {
			service.deletePublisher(publisherId);
			SuccessView.showSuccess("���ǻ� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� ���� ������ ���� �߻�");
		}
	}
	
//**************************************************************
	
	public void getAuthorWriteInfo (int bookId) {
		try {
			EndView.authorWriteListView(service.getAuthorWriteInfo(bookId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("å�� ���� �˻��� �����߻� ");
		}
		
	}
	
	public void getBookWriteInfo (int authorId) {
		try {
			EndView.bookWriteListView(service.getBookWriteInfo(authorId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("������ å �˻��� �����߻� ");
		}
		
	}
	
	
//**************************************************************
	
	public void getAuthoTranslatingInfo (int bookId) {
		try {
			EndView.authorTranslatingListView(service.getAuthoTranslatingInfo(bookId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("å�� ������ �˻��� �����߻� ");
		}
		
	}
	
	public void getBookTranslatingInfo (int translatorId) {
		try {
			EndView.bookTranslatingListView(service.getBookTranslatingInfo(translatorId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("�������� å �˻��� �����߻� ");
		}
		
	}

}
