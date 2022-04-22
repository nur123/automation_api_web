package api;

import base.ResponseData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.request.create_signature.CreateTrxRefRequest;
import model.response.check_payment_status.CheckPaymentStatusResponse;
import model.response.secure_page.SecurePagePaymentResponse;

public class CheckPaymentStatusClient {

    public ResponseData<CheckPaymentStatusResponse> checkPaymentStatus200(CreateTrxRefRequest requestBody, String siganture) {
        Response response = RestAssured.given().log().all()
                .baseUri("http://54.169.81.53:8902/")
                .header("Signature",siganture)
                .header("timestamp","1614070898")
                .header("Authorization", "Basic T1AxRTAwMDAwMDQ3")
                .body(requestBody)
                .post("/sp/service/v2.0.1/api/checkstatus");

        response.then().log().all();
        return new ResponseData<>(response.as(CheckPaymentStatusResponse.class), response);
    }

}
