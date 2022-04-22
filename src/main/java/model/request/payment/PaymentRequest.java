package model.request.payment;

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
public class PaymentRequest{

	@JsonProperty("AdditionalData")
	private String additionalData;

	@JsonProperty("DetailBills")
	private List<Object> detailBills;

	@JsonProperty("RequestID")
	private String requestID;

	@JsonProperty("Reference")
	private String reference;

	@JsonProperty("TotalAmount")
	private String totalAmount;

	@JsonProperty("PaidAmount")
	private String paidAmount;

	@JsonProperty("FlagAdvice")
	private String flagAdvice;

	@JsonProperty("CurrencyCode")
	private String currencyCode;

	@JsonProperty("SubCompany")
	private String subCompany;

	@JsonProperty("CustomerNumber")
	private String customerNumber;

	@JsonProperty("CustomerName")
	private String customerName;

	@JsonProperty("ChannelType")
	private String channelType;

	@JsonProperty("CompanyCode")
	private String companyCode;

	@JsonProperty("TransactionDate")
	private String transactionDate;
}