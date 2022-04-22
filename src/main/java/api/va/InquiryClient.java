package api.va;

import base.ResponseData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.request.inquiry.InquiryRequest;
import model.response.inquiry.InquiryResponse;

public class InquiryClient {

    public ResponseData<InquiryResponse> inquiry200(String accessToken, InquiryRequest inquiryRequest) {
        Response response = RestAssured.given().log().all()
                .baseUri("http://13.228.25.85:8387")
                .header("Authorization", "Bearer " + accessToken)
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .body(inquiryRequest)
                .post("/v1.0/va/bills");

        response.then().log().all();
        return new ResponseData<>(response.as(InquiryResponse.class), response);

    }

}
