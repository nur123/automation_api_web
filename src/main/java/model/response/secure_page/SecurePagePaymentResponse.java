package model.response.secure_page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurePagePaymentResponse{

	@JsonProperty("responseAuth")
	private ResponseAuth responseAuth;

	@JsonProperty("responseData")
	private ResponseData responseData;
}