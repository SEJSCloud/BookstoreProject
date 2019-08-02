package bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorDTO {
	
	private int authorId;
	private String authorName;
	
	
	   @Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("[authorId : ");
	      builder.append(authorId);
	      builder.append(", authorName : ");
	      builder.append(authorName);
	      builder.append("]\n");
	      return builder.toString();
	   }
	
}
