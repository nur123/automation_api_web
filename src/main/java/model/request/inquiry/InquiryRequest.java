package model.request.inquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquiryRequest{

	@JsonProperty("RequestID")
	private String requestID;

	@JsonProperty("CustomerNumber")
	private String customerNumber;

	@JsonProperty("ChannelType")
	private String channelType;

	@JsonProperty("CompanyCode")
	private String companyCode;

	@JsonProperty("TransactionDate")
	private String transactionDate;
}