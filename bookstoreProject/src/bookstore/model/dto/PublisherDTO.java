package bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PublisherDTO {
	
	private int publisherId;
	private String publisherName;
	
	   @Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("[publisherId : ");
	      builder.append(publisherId);
	      builder.append(", publisherName : ");
	      builder.append(publisherName);
	      builder.append("]\n");
	      return builder.toString();
	   }

}
