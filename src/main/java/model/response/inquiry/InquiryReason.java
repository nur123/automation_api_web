package model.response.inquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquiryReason{

	@JsonProperty("English")
	private String english;

	@JsonProperty("Indonesian")
	private String indonesian;
}