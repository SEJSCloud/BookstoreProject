package bookstore.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bookstore.model.dto.BookDTO;

public class Crawling {
	private static Crawling instance = new Crawling();
	private static ArrayList<BookDTO> booksList = new ArrayList<>();

	public ArrayList<BookDTO> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<BookDTO> reviewList) {
		Crawling.booksList = reviewList;
	}

	public static Crawling getInstance() {
		return instance;
	}
	
	public static void result1() {
		Document doc = null;
		Elements newsHeadlines = null;
		for (int i = 1; i <= 5; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			newsHeadlines = doc.select(
					"#Myform > div.ss_book_box > table > tbody > tr > td > table > tbody > tr > td > div:nth-child(1) > ul > li");
			Pattern authorPattern = Pattern.compile("\\Q(지은이)\\E");
			int a;
			for (Element b : newsHeadlines) {
				if (authorPattern.matcher(b.text()).find()) {
					//System.out.println(b.text());
					a = b.text().indexOf("| 2");
					//System.out.println(a);
					System.out.println(b.text().substring(a+1));
				}
			}
		}
	}

	public static void getBooksCrawling() {
		Document doc = null;
		Elements bookTitle;
		Elements reviewNumber;
		Elements author;
		Elements publisher;
		Elements publishMonth;
		int booksListSize = 0;
		int publishMonthSub;

		for (int i = 1; i < 5; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bookTitle = doc.select("li > a > b");
			publishMonth = doc.select("#Myform > div.ss_book_box > table > tbody > tr > td > table > tbody > tr > td > div:nth-child(1) > ul > li");
			if (bookTitle.size() == 0) {
				System.out.print("No more Reviews!\n");
				break;
			} else {
				sleep(0.2, ".");
			}
			booksListSize = booksList.size();
			Pattern MonthPattern = Pattern.compile("\\Q(지은이)\\E");
			
//			for (Element b : publishMonth) {
//				if (authorPattern.matcher(b.text()).find()) {
//					//System.out.println(b.text());
//					a = b.text().indexOf("| 2");
//					//System.out.println(a);
//					System.out.println(b.text().substring(a+1));
//				}
//			}
			for (int j = 0; j < bookTitle.size(); j++) {
				booksList.add(new BookDTO());
				booksList.get(j + booksListSize).setTitle(bookTitle.get(j).text());
				if (MonthPattern.matcher(publishMonth.get(j).text()).find()) {
					publishMonthSub = publishMonth.get(j).text().indexOf("| 2");
					booksList.get(j + booksListSize).setPublishMonth(publishMonth.get(j).text().substring(publishMonthSub+2));
					System.out.println(publishMonth.get(j).text().substring(publishMonthSub+2));
				}
			}
			
		}
		System.out.println(booksList);
	}

	public static void sleep(double second, String message) {
		try {
			Thread.sleep((long) (second * 1000));
			System.out.print(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//result1();
		getBooksCrawling();
	}
}


//for (int i = 1; i <= 10; i++) {
//	try {
//		doc = Jsoup.connect(
//				"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
//						+ i + "&BranchType=1&PublishDay=84")
//				.get();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//
//	for (int j = 2; j <= 26; j++) {
//		int a = 2;
//		int b = 1;
//		int c = 3;
//
//		newsHeadlines = doc.select("#Myform > div:nth-child(" + j
//				+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
//		String ifStringMass = newsHeadlines.text();
//		String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
//		if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
//			a = a + 1;
//			b = b + 1;
//			c = c + 1;
//		}
//
//	}
//}