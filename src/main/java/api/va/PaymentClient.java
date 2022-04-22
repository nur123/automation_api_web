package api.va;

import base.ResponseData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.request.payment.PaymentRequest;
import model.response.payment.PaymentResponse;

public class PaymentClient {

    public ResponseData<PaymentResponse> payment200(String accessToken, PaymentRequest paymentRequest) {

        Response response = RestAssured.given().log().all()
                .baseUri("http://13.228.25.85:8387")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .body(paymentRequest)
                .post("/v1.0/va/payments");

        response.then().log().all();
        return new ResponseData<>(response.as(PaymentResponse.class), response);

    }

}
