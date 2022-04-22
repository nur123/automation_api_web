package api.va;

import base.ResponseData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.response.check_payment_status.CheckPaymentStatusResponse;
import model.response.create_token.CreateTokenResponse;

public class CreateTokenClient {

    public ResponseData<CreateTokenResponse> createToken200() {
        Response response = RestAssured.given().log().all()
                .baseUri("http://13.228.25.85:8387/")
                .basePath("/v1.0/api")
                .header("Authorization", "Basic YmNhOmJjYTEyMw==")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("Accept","application/json")
                .formParam("grant_type","client_credentials")
                .post("/oauth/token");

        response.then().log().all();
        return new ResponseData<>(response.as(CreateTokenResponse.class), response);
    }
}
