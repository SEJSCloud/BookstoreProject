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
	private int publisherId;
	private String translatorName;
	
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
