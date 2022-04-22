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
public class CreateSignatureRequest{

	@JsonProperty("transactionDetails")
	private TransactionDetails transactionDetails;

	@JsonProperty("customerDetails")
	private CustomerDetails customerDetails;
}