package bookstore.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import bookstore.model.dto.AuthorDTO;
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

	Document doc = null;
	Elements newsHeadlines = null;
	Elements newsHeadlines1 = null;
	Elements newsHeadlines2 = null;
	Elements newsHeadlines3 = null;
	Elements newsHeadlines4 = null;
	ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
	ArrayList<String> titleArray = new ArrayList<String>();
	ArrayList<String> publishMonthArray = new ArrayList<String>();
	ArrayList<String> priceArray = new ArrayList<String>();
	ArrayList<Integer> discountRateArray = new ArrayList<Integer>();
	BookDTO book = new BookDTO();

	public ArrayList<String> getBookListTitle() {

		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int b = 1;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					b = b + 1;
				}
				newsHeadlines1 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ b + ") > a > b");

				String stringTitle = newsHeadlines1.text();

				titleArray.add(stringTitle);
			}
		}
		return titleArray;
	}

	public ArrayList<String> getBookListPublishMonth() {
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int a = 2;
				int b = 1;
				int c = 3;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					a = a + 1;
					b = b + 1;
					c = c + 1;
				}

				newsHeadlines2 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ a + ")");

				String stringMass = newsHeadlines2.text();
				int idx1 = stringMass.indexOf("|");
				String secondStringMass = stringMass.substring(idx1 + 1);
				int idx2 = secondStringMass.indexOf("|");
				String thirdStringMass = secondStringMass.substring(idx2 + 2);

				publishMonthArray.add(thirdStringMass);

			}
		}
		return publishMonthArray;
	}

	public ArrayList<String> getBookListPrice() {
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int a = 2;
				int b = 1;
				int c = 3;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					a = a + 1;
					b = b + 1;
					c = c + 1;
				}

				newsHeadlines3 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ c + ") > span:nth-child(1)");

				String stringPrice = newsHeadlines3.text();

				priceArray.add(stringPrice);
			}
		}
		return priceArray;
	}

	public ArrayList<Integer> getBookListDiscountRate() {
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int a = 2;
				int b = 1;
				int c = 3;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					a = a + 1;
					b = b + 1;
					c = c + 1;
				}

				newsHeadlines4 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ c + ") > span:nth-child(3)");

				String stringDiscountF = newsHeadlines4.text();
				if (!newsHeadlines4.text().contains("%")) {
					stringDiscountF = "0%";
				}
				String stringDiscount = stringDiscountF.replace("%", "");

				int intDiscount = Integer.parseInt(stringDiscount);
				Integer intObj = new Integer(intDiscount);

				discountRateArray.add(intObj);
			}
		}
		return discountRateArray;
	}

	public static void main(String[] args) {

		Document doc = null;
		Elements newsHeadlines = null;
		Elements newsHeadlines1 = null;
		Elements newsHeadlines2 = null;
		Elements newsHeadlines3 = null;
		Elements newsHeadlines4 = null;
		Elements newsHeadlines5 = null;
		Elements newsHeadlines6 = null;
		ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
		ArrayList<AuthorDTO> authorList = new ArrayList<AuthorDTO>();

		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int d = 2;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					d = d + 1;
				}
				newsHeadlines5 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ d + ")");
				

				String stringMass = newsHeadlines5.text();
				String translatorName = null;
				if(stringMass.contains("(옮")) {
					int idx = stringMass.indexOf("(옮");
					if(stringMass.contains("지은이)")) {
						int idx1 = stringMass.indexOf("지은이)");
						translatorName = stringMass.substring(idx1+6, idx);
						if(stringMass.contains("엮은이)")) {
							int idx2 = stringMass.indexOf("엮은이)");
							translatorName = stringMass.substring(idx2+6, idx);
							if(stringMass.contains("그림)")) {
								int idx3 = stringMass.indexOf("그림)");
								translatorName = stringMass.substring(idx3+5, idx);
							}
						}
						if(stringMass.contains("그림)")) {
							int idx4 = stringMass.indexOf("그림)");
							translatorName = stringMass.substring(idx4+5, idx);
						}
					}
				}else if(!stringMass.contains("(옮")){
					translatorName = null;
				}



				System.out.println(translatorName);
//				AuthorDTO author = new AuthorDTO(0, array1);
//				authorList.add(author);
			}

		}
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