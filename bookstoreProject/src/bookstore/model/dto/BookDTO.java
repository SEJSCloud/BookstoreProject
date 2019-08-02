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
	private String price;
	private int discountRate;
<<<<<<< HEAD
	private String authorName;
	private String translatorName;
	private String publisherName;
=======
<<<<<<< HEAD
	private int publisherId; 
=======
	private int publisherId;
	private String translatorName;
>>>>>>> 677505e638b72f011ee2c40e06e4093feaca3157
>>>>>>> 395b7a7e539bcdd45a8b0430bf9ac277a09ac7c8
	
	   @Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("[title : ");
	      builder.append(title);
	      builder.append(", publishMonth : ");
	      builder.append(publishMonth);
	      builder.append(", price : ");
	      builder.append(price);
	      builder.append(", discountRate : ");
	      builder.append(discountRate);
	      builder.append(", authorName : ");
	      builder.append(authorName);
	      builder.append(", translatorName : ");
	      builder.append(translatorName);
	      builder.append(", publisherName : ");
	      builder.append(publisherName);
	      builder.append("]\n");
	      return builder.toString();
	   }


}
