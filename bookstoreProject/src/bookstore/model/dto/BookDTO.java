package bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDTO {
	
	private int bookId;
	private String title;
	private String publishMonth;
	private int price;
	private int discountRate;
	private int publisherId;

}
