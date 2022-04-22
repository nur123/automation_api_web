package model.helpers;

import base.ResponseData;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.request.create_signature.CreateSignatureRequest;
import model.response.secure_page.SecurePagePaymentResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentData {

    private CreateSignatureRequest createSignatureRequest;
    private Response createSignatureApiResponse;
    private ResponseData<SecurePagePaymentResponse> securePagePaymentApiResponse;

}
