package tests;

import api.CheckPaymentStatusClient;
import api.CreateSignatureClient;
import api.SecurePagePaymentClient;
import base.BaseTest;
import base.ResponseData;
import helpers.CreatePaymentLinkHelper;
import helpers.CreateSignatureHelper;
import io.restassured.response.Response;
import model.helpers.PaymentData;
import model.request.create_signature.CreateSignatureRequest;
import model.request.create_signature.CreateTrxRefRequest;
import model.response.check_payment_status.CheckPaymentStatusResponse;
import model.response.secure_page.SecurePagePaymentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web.cyclops.InputDebitPaymentPage;
import web.cyclops.PaymentSelectionPage;
import webdriver.WebdriverInit;

public class CreatePaymentDebitRevamp extends BaseTest {

    @Test
    public void createPaymentDebitUntilPaid() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("debit1");
        paymentSelectionPage.clickKartuDebitBtn();
        paymentSelectionPage.takeScreenShot("debit2");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("debit3");
        inputDebitPaymentPage.inputCardNo("41111111111111111");
        inputDebitPaymentPage.takeScreenShot("debit4");
        inputDebitPaymentPage.inputCardHolderName("testing 16");
        inputDebitPaymentPage.takeScreenShot("debit5");
        inputDebitPaymentPage.selectCardExpireDate("12", "2023");
        inputDebitPaymentPage.takeScreenShot("debit6");
        inputDebitPaymentPage.inputCvv("123");
        inputDebitPaymentPage.takeScreenShot("debit7");
        inputDebitPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("debit8");
        inputDebitPaymentPage.waitABit(30);
        WebdriverInit.quit();


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

    @Test
    public void createPaymentDebitInvalidCardNo() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData().getEndpointUrl());
        paymentSelectionPage.takeScreenShot("debit9");
        paymentSelectionPage.clickKartuDebitBtn();
        paymentSelectionPage.takeScreenShot("debit10");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("debit11");
        inputDebitPaymentPage.inputCardNo("42222222222222222");
        inputDebitPaymentPage.takeScreenShot("debit12");
        inputDebitPaymentPage.inputCardHolderName("testing 15");
        inputDebitPaymentPage.takeScreenShot("debit13");
        inputDebitPaymentPage.selectCardExpireDate("12", "2023");
        inputDebitPaymentPage.takeScreenShot("debit14");
        inputDebitPaymentPage.inputCvv("123");
        inputDebitPaymentPage.takeScreenShot("debit15");
        inputDebitPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("debit16");
        inputDebitPaymentPage.waitABit(30);
        WebdriverInit.quit();


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

    @Test
    public void createPaymentDebitTransactionOverLimit() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("debit17");
        paymentSelectionPage.clickKartuDebitBtn();
        paymentSelectionPage.takeScreenShot("debit18");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("debit19");
        inputDebitPaymentPage.inputCardNo("41111111111111111");
        inputDebitPaymentPage.takeScreenShot("debit20");
        inputDebitPaymentPage.inputCardHolderName("testing 15");
        inputDebitPaymentPage.takeScreenShot("debit21");
        inputDebitPaymentPage.selectCardExpireDate("12", "2023");
        inputDebitPaymentPage.takeScreenShot("debit22");
        inputDebitPaymentPage.inputCvv("123");
        inputDebitPaymentPage.takeScreenShot("debit23");
        inputDebitPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("debit24");
        inputDebitPaymentPage.waitABit(30);
        WebdriverInit.quit();


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

    @Test
    public void createPaymentDebitTransactionTimeout() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("debit25");
        paymentSelectionPage.clickKartuDebitBtn();
        paymentSelectionPage.takeScreenShot("debit26");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("debit27");
        inputDebitPaymentPage.inputCardNo("41111111111111111");
        inputDebitPaymentPage.takeScreenShot("debit28");
        inputDebitPaymentPage.inputCardHolderName("testing 15");
        inputDebitPaymentPage.takeScreenShot("debit29");
        inputDebitPaymentPage.selectCardExpireDate("12", "2023");
        inputDebitPaymentPage.takeScreenShot("debit30");
        inputDebitPaymentPage.inputCvv("123");
        inputDebitPaymentPage.takeScreenShot("debit30");
        inputDebitPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("debit31");
        inputDebitPaymentPage.waitABit(30);
        WebdriverInit.quit();


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

    @Test
    public void createPaymentDebitCVVInvalid() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
        paymentSelectionPage.takeScreenShot("debit32");
        paymentSelectionPage.clickKartuDebitBtn();
        paymentSelectionPage.takeScreenShot("debit33");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("debit34");
        inputDebitPaymentPage.inputCardNo("41111111111111111");
        inputDebitPaymentPage.takeScreenShot("debit35");
        inputDebitPaymentPage.inputCardHolderName("testing 15");
        inputDebitPaymentPage.takeScreenShot("debit36");
        inputDebitPaymentPage.selectCardExpireDate("12", "2023");
        inputDebitPaymentPage.takeScreenShot("debit37");
        inputDebitPaymentPage.inputCvv("#@$1");
        inputDebitPaymentPage.takeScreenShot("debit38");
        inputDebitPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("debit39");
        inputDebitPaymentPage.waitABit(30);
        WebdriverInit.quit();


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
