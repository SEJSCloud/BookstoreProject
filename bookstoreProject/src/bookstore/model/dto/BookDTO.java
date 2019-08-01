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
	private int publisherId; 
=======
	private int publisherId;
	private String translatorName;
>>>>>>> 677505e638b72f011ee2c40e06e4093feaca3157
	
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
	      builder.append("]\n");
	      return builder.toString();
	   }

}
