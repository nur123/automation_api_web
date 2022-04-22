package helpers;

import api.CreateSignatureClient;
import api.SecurePagePaymentClient;
import base.ResponseData;
import io.restassured.response.Response;
import model.helpers.PaymentData;
import model.request.create_signature.CreateSignatureRequest;
import model.response.secure_page.SecurePagePaymentResponse;
import org.junit.jupiter.api.Assertions;

public class CreatePaymentLinkHelper {

    private static CreateSignatureClient createSignatureClient = new CreateSignatureClient();
    private static SecurePagePaymentClient securePagePaymentClient = new SecurePagePaymentClient();

    public static PaymentData generatePaymentLink(int amount) {
        CreateSignatureRequest requestBody = CreateSignatureHelper.generateValidRequest(amount);
        Response createSignatureApi = createSignatureClient.createSignature200(requestBody);

        Assertions.assertEquals(200, createSignatureApi.getStatusCode());
        String signature = createSignatureApi.getBody().asString()
                .replaceAll("\"", "");

        ResponseData<SecurePagePaymentResponse> securePagePaymentApi = securePagePaymentClient.securePagePayment200(requestBody, signature);

        Assertions.assertEquals(200, securePagePaymentApi.getResponse().getStatusCode());
        Assertions.assertEquals("00", securePagePaymentApi.getResponseBody().getResponseData().getStatusCode());
        Assertions.assertEquals("SUCCESS", securePagePaymentApi.getResponseBody().getResponseData().getStatusMessage());
        return PaymentData.builder().createSignatureApiResponse(createSignatureApi)
                .createSignatureRequest(requestBody)
                .securePagePaymentApiResponse(securePagePaymentApi).build();
    }
}
