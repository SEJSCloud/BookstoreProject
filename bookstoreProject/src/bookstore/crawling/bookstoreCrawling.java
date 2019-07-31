package bookstore.crawling;
	
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import bookstore.model.dto.BookDTO;
	
public class bookstoreCrawling {
	
	private static bookstoreCrawling instance = new bookstoreCrawling();
	
	public static bookstoreCrawling getInstance() {
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
	
	public ArrayList<BookDTO> getBookList() {
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
				newsHeadlines1 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ b + ") > a > b");

				newsHeadlines2 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ a + ")");

				newsHeadlines3 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ c + ") > span:nth-child(1)");

				newsHeadlines4 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ c + ") > span:nth-child(3)");

				String stringTitle = newsHeadlines1.text();

				String stringMass = newsHeadlines2.text();
				int idx1 = stringMass.indexOf("|");
				String secondStringMass = stringMass.substring(idx1 + 1);
				int idx2 = secondStringMass.indexOf("|");
				String thirdStringMass = secondStringMass.substring(idx2 + 2);

				String stringPrice = newsHeadlines3.text();

				String stringDiscountF = newsHeadlines4.text();

				if (!newsHeadlines4.text().contains("%")) {
					stringDiscountF = "0%";
				}
				String stringDiscount = stringDiscountF.replace("%", "");
				int intDiscount = Integer.parseInt(stringDiscount);
				BookDTO book = new BookDTO(0, stringTitle, thirdStringMass, stringPrice + "¿ø", intDiscount, 0);
				bookList.add(book);

			}
		}
		return bookList;
	}

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

}
