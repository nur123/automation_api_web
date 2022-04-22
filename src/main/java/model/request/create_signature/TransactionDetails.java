package model.request.create_signature;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails{

	@JsonProperty("valain")
	private String valain;

	@JsonProperty("amount")
	private Integer amount;

	@JsonProperty("orderId")
	private String orderId;

	@JsonProperty("vabca")
	private String vabca;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("promoCode")
	private String promoCode;

	@JsonProperty("vaOrderId")
	private String vaOrderId;

	@JsonProperty("vamandiri")
	private String vamandiri;

	@JsonProperty("merchantName")
	private String merchantName;
}