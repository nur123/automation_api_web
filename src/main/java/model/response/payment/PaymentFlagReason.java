package model.response.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentFlagReason{

	@JsonProperty("English")
	private String english;

	@JsonProperty("Indonesian")
	private String indonesian;
}