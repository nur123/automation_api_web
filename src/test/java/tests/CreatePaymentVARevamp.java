package tests;

import base.BaseTest;
import base.ResponseData;
import helpers.CreatePaymentLinkHelper;
import helpers.InquiryHelper;
import helpers.PaymentHelper;
import io.restassured.internal.common.assertion.Assertion;
import model.helpers.PaymentData;
import model.request.inquiry.InquiryRequest;
import model.response.create_token.CreateTokenResponse;
import model.response.inquiry.InquiryResponse;
import model.response.payment.PaymentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webdriver.WebdriverInit;

public class CreatePaymentVARevamp extends BaseTest {

    @Test
    public void createPaymentVAUntilPaid()  {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("va1");
        paymentSelectionPage.clickVirtualAccountBtn();
        paymentSelectionPage.takeScreenShot("va2");
        paymentSelectionPage.clickBCAVARadioBtn();
        paymentSelectionPage.takeScreenShot("va3");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("va4");
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
        vaPaymentDetailPage.clickSelesaiBtn();
        vaPaymentDetailPage.waitABit(5);
        WebdriverInit.quit();
    }

    @Test
    public void inquiryWithUsedCustomerNumber() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("va5");
        paymentSelectionPage.clickVirtualAccountBtn();
        paymentSelectionPage.takeScreenShot("va6");
        paymentSelectionPage.clickBCAVARadioBtn();
        paymentSelectionPage.takeScreenShot("va7");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("va8");
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

    @Test
    public void PaymentVAInvalidTotalAmount()  {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("va9");
        paymentSelectionPage.clickVirtualAccountBtn();
        paymentSelectionPage.takeScreenShot("va10");
        paymentSelectionPage.clickBCAVARadioBtn();
        paymentSelectionPage.takeScreenShot("va11");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("va12");
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
        Assertions.assertEquals("inquiry TotalAmount and request TotalAmount is not match", paymentResponse.getResponseBody().getPaymentFlagReason().getIndonesian());
        vaPaymentDetailPage.waitABit(5);
        vaPaymentDetailPage.clickSelesaiBtn();
        vaPaymentDetailPage.waitABit(5);
        WebdriverInit.quit();
    }

}
