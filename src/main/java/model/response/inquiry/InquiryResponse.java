package model.response.inquiry;

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
public class InquiryResponse{

	@JsonProperty("CurrencyCode")
	private String currencyCode;

	@JsonProperty("FreeTexts")
	private List<Object> freeTexts;

	@JsonProperty("AdditionalData")
	private String additionalData;

	@JsonProperty("DetailBills")
	private List<Object> detailBills;

	@JsonProperty("InquiryReason")
	private InquiryReason inquiryReason;

	@JsonProperty("RequestID")
	private String requestID;

	@JsonProperty("SubCompany")
	private String subCompany;

	@JsonProperty("CustomerNumber")
	private String customerNumber;

	@JsonProperty("InquiryStatus")
	private String inquiryStatus;

	@JsonProperty("CustomerName")
	private String customerName;

	@JsonProperty("TotalAmount")
	private String totalAmount;

	@JsonProperty("CompanyCode")
	private String companyCode;
}