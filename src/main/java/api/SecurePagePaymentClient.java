package api;

import base.ResponseData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.request.create_signature.CreateSignatureRequest;
import model.response.secure_page.SecurePagePaymentResponse;

public class SecurePagePaymentClient {

    public ResponseData<SecurePagePaymentResponse> securePagePayment200(CreateSignatureRequest requestBody, String signature) {
        Response response = RestAssured.given().log().all()
                .baseUri("http://54.169.81.53:8956/")
                .header("Signature",signature)
                .header("timestamp","1614070898")
                .header("Content-Type","application/json")
                .header("Authorization", "Basic T1AxRTAwMDAwMDQ3")
                .body(requestBody)
                .post("/payment-services/v2.1.0/api/token");
        response.then().log().all();
        return new ResponseData<>(response.as(SecurePagePaymentResponse.class), response);
    }
}