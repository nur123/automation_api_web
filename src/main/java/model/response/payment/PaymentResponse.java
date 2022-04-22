package model.response.payment;

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
public class PaymentResponse{

	@JsonProperty("FreeTexts")
	private List<Object> freeTexts;

	@JsonProperty("AdditionalData")
	private String additionalData;

	@JsonProperty("DetailBills")
	private List<Object> detailBills;

	@JsonProperty("RequestID")
	private String requestID;

	@JsonProperty("PaymentFlagStatus")
	private String paymentFlagStatus;

	@JsonProperty("TotalAmount")
	private String totalAmount;

	@JsonProperty("PaymentFlagReason")
	private PaymentFlagReason paymentFlagReason;

	@JsonProperty("PaidAmount")
	private String paidAmount;

	@JsonProperty("CurrencyCode")
	private String currencyCode;

	@JsonProperty("CustomerNumber")
	private String customerNumber;

	@JsonProperty("CustomerName")
	private String customerName;

	@JsonProperty("CompanyCode")
	private String companyCode;

	@JsonProperty("TransactionDate")
	private String transactionDate;
}