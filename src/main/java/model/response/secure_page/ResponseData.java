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
public class ResponseData{

	@JsonProperty("orderId")
	private String orderId;

	@JsonProperty("endpointUrl")
	private String endpointUrl;

	@JsonProperty("statusMessage")
	private String statusMessage;

	@JsonProperty("statusCode")
	private String statusCode;
}