package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.request.create_signature.CreateSignatureRequest;
import model.request.create_signature.CreateTrxRefRequest;

public class CreateSignatureClient {

    public Response createSignature200(CreateSignatureRequest requestBody) {

        Response response = RestAssured.given().log().all()
                .baseUri("http://54.169.81.53:8888/")
                .header("Content-Type", "application/json")
                .header("Timestamp","1614070898")
                .header("Apikey", "IIOE0I10I0AP0A00P00PY1EKK00A00KP")
                .body(requestBody)
                .post("/corepg/api/general/createSignature/");

        response.then().log().all();
        return response;

    }

    public Response createSignatureTrxRef200(CreateTrxRefRequest requestBody) {

        Response response = RestAssured.given().log().all()
                .baseUri("http://54.169.81.53:8888/")
                .header("Content-Type", "application/json")
                .header("Timestamp","1614070898")
                .header("Apikey", "IIOE0I10I0AP0A00P00PY1EKK00A00KP")
                .body(requestBody)
                .post("/corepg/api/general/createSignature/");

        response.then().log().all();
        return response;

    }
}
