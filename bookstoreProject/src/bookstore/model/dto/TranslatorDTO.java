package bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TranslatorDTO {
	
	private int translatorId;
	private String translatorName;

	
	   @Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
	      builder.append("[translatorId : ");
	      builder.append(translatorId);
	      builder.append(", translatorName : ");
	      builder.append(translatorName);
	      builder.append("]\n");
	      return builder.toString();
	   }
}
