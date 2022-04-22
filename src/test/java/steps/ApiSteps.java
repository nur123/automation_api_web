package steps;

import base.BaseTest;
import base.ResponseData;
import helpers.CreatePaymentLinkHelper;
import helpers.CreateSignatureHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.helpers.PaymentData;
import model.request.create_signature.CreateTrxRefRequest;
import model.response.check_payment_status.CheckPaymentStatusResponse;
import org.junit.jupiter.api.Assertions;

public class ApiSteps extends BaseTest {
    @Given("user generate payment link")
    public void userGeneratePaymentLink() {
         int amount = Integer.parseInt(faker.numerify("1#####"));
         paymentData = CreatePaymentLinkHelper.generatePaymentLink(amount);
    }

    @Given("user generate payment link with more limit")
    public void userGeneratePaymentLinkWithMoreLimit() {
        int amount = Integer.parseInt(faker.numerify("1######"));
        paymentData = CreatePaymentLinkHelper.generatePaymentLink(amount);
    }

    @Then("the payment status will be success")
    public void thePaymentStatusWillBeSuccess() {
        inputDebitPaymentPage.waitABit(30);
//      inputKreditPaymentPage.waitABit(30);
        CreateTrxRefRequest requestBody2 = CreateSignatureHelper.generateTrxRefRequest(paymentData.getCreateSignatureRequest().getTransactionDetails().getOrderId());
        Response createSignatureApi2 = createSignatureClient.createSignatureTrxRef200(requestBody2);

        Assertions.assertEquals(200, createSignatureApi2.getStatusCode());
        String signature2 = createSignatureApi2.getBody().asString()
                .replaceAll("\"", "");

        ResponseData<CheckPaymentStatusResponse> checkPaymentStatusApi = checkPaymentStatusClient.checkPaymentStatus200(requestBody2, signature2);
        Assertions.assertEquals(200, checkPaymentStatusApi.getResponse().getStatusCode());
        Assertions.assertEquals("00", checkPaymentStatusApi.getResponseBody().getResponseCode());
        Assertions.assertEquals("Success", checkPaymentStatusApi.getResponseBody().getResponseDesc());
    }

    @Then("the payment status will be not success")
    public void thePaymentStatusWillBeNotSuccess() {
        inputDebitPaymentPage.waitABit(30);
//      inputKreditPaymentPage.waitABit(30);
        CreateTrxRefRequest requestBody2 = CreateSignatureHelper.generateTrxRefRequest(paymentData.getCreateSignatureRequest().getTransactionDetails().getOrderId());
        Response createSignatureApi2 = createSignatureClient.createSignatureTrxRef200(requestBody2);

        Assertions.assertEquals(200, createSignatureApi2.getStatusCode());
        String signature2 = createSignatureApi2.getBody().asString()
                .replaceAll("\"", "");

        ResponseData<CheckPaymentStatusResponse> checkPaymentStatusApi = checkPaymentStatusClient.checkPaymentStatus200(requestBody2, signature2);
        Assertions.assertEquals(200, checkPaymentStatusApi.getResponse().getStatusCode());
        Assertions.assertEquals("00", checkPaymentStatusApi.getResponseBody().getResponseCode());
        Assertions.assertEquals("Success", checkPaymentStatusApi.getResponseBody().getResponseDesc());
    }
}