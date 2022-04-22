package steps;

import base.BaseTest;
import base.ResponseData;
import helpers.InquiryHelper;
import helpers.PaymentHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.request.inquiry.InquiryRequest;
import model.response.create_token.CreateTokenResponse;
import model.response.inquiry.InquiryResponse;
import model.response.payment.PaymentResponse;
import org.junit.jupiter.api.Assertions;

public class VAPaymentDetailPageSteps extends BaseTest {
    @When("user copy VA number and pay on VA Payment Detail Page")
    public void userCopyVANumberAndPayOnVAPaymentDetailPage() {
        String vaNumber = vaPaymentDetailPage.getVANumberText();
        String companyCode = vaNumber.substring(0, 5);
        String customerNumber = vaNumber.substring(5);

        //get-token
        ResponseData<CreateTokenResponse> createTokenResponse = createTokenClient.createToken200();
        Assertions.assertEquals(200, createTokenResponse.getResponse().getStatusCode());
        String accessToken = createTokenResponse.getResponseBody().getAccessToken();

        //inquiry
        InquiryRequest inquiryRequest = InquiryHelper.generateRequestBody(companyCode, customerNumber);
        ResponseData<InquiryResponse> inquiryResponse = inquiryClient.inquiry200(accessToken, inquiryRequest);
        Assertions.assertEquals(200, inquiryResponse.getResponse().getStatusCode());

        //payment
        ResponseData<PaymentResponse> paymentResponse = paymentClient.payment200(accessToken, PaymentHelper.generateRequestBody(inquiryRequest, inquiryResponse.getResponseBody().getTotalAmount()));
        Assertions.assertEquals(200,paymentResponse.getResponse().getStatusCode());
        vaPaymentDetailPage.waitABit(5);
    }

    @When("user click button selesai on VA Payment Detail Page")
    public void userClickButtonSelesaiOnVAPaymentDetailPage() {
        vaPaymentDetailPage.clickSelesaiBtn();
        vaPaymentDetailPage.waitABit(5);
    }

    @Then("user unable to pay using use customer number")
    public void userUnableToPayUsingUseCustomerNumber() {
        String vaNumber = vaPaymentDetailPage.getVANumberText();
        String companyCode = vaNumber.substring(0, 5);
        String customerNumber = vaNumber.substring(5);

        //get-token
        ResponseData<CreateTokenResponse> createTokenResponse = createTokenClient.createToken200();
        Assertions.assertEquals(200, createTokenResponse.getResponse().getStatusCode());
        String accessToken = createTokenResponse.getResponseBody().getAccessToken();
        //inquiry
        InquiryRequest inquiryRequest = InquiryHelper.generateRequestBody(companyCode, customerNumber);
        inquiryRequest.setRequestID("1000018096");
        ResponseData<InquiryResponse> inquiryResponse = inquiryClient.inquiry200(accessToken, inquiryRequest);
        Assertions.assertEquals(200, inquiryResponse.getResponse().getStatusCode());
        Assertions.assertEquals("Request ID sudah digunakan", inquiryResponse.getResponseBody().getInquiryReason().getIndonesian());
        Assertions.assertEquals("Request ID has been used", inquiryResponse.getResponseBody().getInquiryReason().getEnglish());
    }

    @Then("user unable to pay using invalid total amount")
    public void userUnableToPayUsingInvalidTotalAmount() {
        String vaNumber = vaPaymentDetailPage.getVANumberText();
        String companyCode = vaNumber.substring(0, 5);
        String customerNumber = vaNumber.substring(5);

        //get-token
        ResponseData<CreateTokenResponse> createTokenResponse = createTokenClient.createToken200();
        Assertions.assertEquals(200, createTokenResponse.getResponse().getStatusCode());
        String accessToken = createTokenResponse.getResponseBody().getAccessToken();

        //inquiry
        InquiryRequest inquiryRequest = InquiryHelper.generateRequestBody(companyCode, customerNumber);
        ResponseData<InquiryResponse> inquiryResponse = inquiryClient.inquiry200(accessToken, inquiryRequest);
        Assertions.assertEquals(200, inquiryResponse.getResponse().getStatusCode());

        //payment
        ResponseData<PaymentResponse> paymentResponse = paymentClient.payment200(accessToken, PaymentHelper.generateRequestBody(inquiryRequest, "10000"));
        Assertions.assertEquals(200, paymentResponse.getResponse().getStatusCode());
        Assertions.assertEquals("inquiry TotalAmount dan request TotalAmount tidak sama", paymentResponse.getResponseBody().getPaymentFlagReason().getIndonesian());
        Assertions.assertEquals("inquiry TotalAmount and request TotalAmount is not match", paymentResponse.getResponseBody().getPaymentFlagReason().getEnglish());
    }
}
