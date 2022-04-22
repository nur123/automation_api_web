package model.response.check_payment_status;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckPaymentStatusResponse{

	@JsonProperty("ottoRefNo")
	private String ottoRefNo;

	@JsonProperty("amount")
	private Integer amount;

	@JsonProperty("responseDesc")
	private String responseDesc;

	@JsonProperty("issuerRefNo")
	private String issuerRefNo;

	@JsonProperty("customerId")
	private String customerId;

	@JsonProperty("refundHistory")
	private List<Object> refundHistory;

	@JsonProperty("trxRef")
	private String trxRef;

	@JsonProperty("transactionStatusDesc")
	private String transactionStatusDesc;

	@JsonProperty("transactionStatusCode")
	private String transactionStatusCode;

	@JsonProperty("transactionTime")
	private String transactionTime;

	@JsonProperty("issuer")
	private String issuer;

	@JsonProperty("responseCode")
	private String responseCode;

	@JsonProperty("vaNumber")
	private String vaNumber;
}