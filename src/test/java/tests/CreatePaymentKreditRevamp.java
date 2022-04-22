package tests;

import base.BaseTest;
import base.ResponseData;
import helpers.CreatePaymentLinkHelper;
import helpers.CreateSignatureHelper;
import io.restassured.response.Response;
import model.helpers.PaymentData;
import model.request.create_signature.CreateTrxRefRequest;
import model.response.check_payment_status.CheckPaymentStatusResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import webdriver.WebdriverInit;

public class CreatePaymentKreditRevamp extends BaseTest {

    @Test
    public void createPaymentKreditUntilPaid() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData().getEndpointUrl());
        paymentSelectionPage.takeScreenShot("kredit1");
        paymentSelectionPage.clickKartuKreditBtn();
        paymentSelectionPage.takeScreenShot("kredit2");
        paymentSelectionPage.clickPembayaranPenuhBtn();
        paymentSelectionPage.takeScreenShot("kredit3");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("kredit4");
        inputKreditPaymentPage.inputCardNo("4137198118415892");
        inputKreditPaymentPage.takeScreenShot("kredit5");
        inputKreditPaymentPage.inputCardHolderName("testing 15");
        inputKreditPaymentPage.takeScreenShot("kredit6");
        inputKreditPaymentPage.selectCardExpireDate("12", "2023");
        inputKreditPaymentPage.takeScreenShot("kredit7");
        inputKreditPaymentPage.inputCvv("222");
        inputDebitPaymentPage.takeScreenShot("kredit8");
        inputKreditPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("kredit9");
        inputKreditPaymentPage.waitABit(30);
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
    public void createPaymentKreditInvalidCardNumber() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData().getEndpointUrl());
        paymentSelectionPage.takeScreenShot("kredit10");
        paymentSelectionPage.clickKartuKreditBtn();
        paymentSelectionPage.takeScreenShot("kredit11");
        paymentSelectionPage.clickPembayaranPenuhBtn();
        paymentSelectionPage.takeScreenShot("kredit12");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("kredit13");
        inputKreditPaymentPage.inputCardNo("4137191891765413");
        inputDebitPaymentPage.takeScreenShot("kredit14");
        inputKreditPaymentPage.inputCardHolderName("testing 15");
        inputDebitPaymentPage.takeScreenShot("kredit15");
        inputKreditPaymentPage.selectCardExpireDate("12", "2023");
        inputDebitPaymentPage.takeScreenShot("kredit16");
        inputKreditPaymentPage.inputCvv("222");
        inputDebitPaymentPage.takeScreenShot("kredit17");
        inputKreditPaymentPage.clickButtonBayar();
        inputDebitPaymentPage.takeScreenShot("kredit18");
        inputKreditPaymentPage.waitABit(30);
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
    public void createPaymentKreditTransactionOverLimit() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData().getEndpointUrl());
        paymentSelectionPage.takeScreenShot("kredit19");
        paymentSelectionPage.clickKartuKreditBtn();
        paymentSelectionPage.takeScreenShot("kredit20");
        paymentSelectionPage.clickPembayaranPenuhBtn();
        paymentSelectionPage.takeScreenShot("kredit21");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("kredit22");
        inputKreditPaymentPage.inputCardNo("4137198118415892");
        inputKreditPaymentPage.takeScreenShot("kredit23");
        inputKreditPaymentPage.inputCardHolderName("testing 15");
        inputKreditPaymentPage.takeScreenShot("kredit24");
        inputKreditPaymentPage.selectCardExpireDate("12", "2023");
        inputKreditPaymentPage.takeScreenShot("kredit25");
        inputKreditPaymentPage.inputCvv("222");
        inputKreditPaymentPage.takeScreenShot("kredit26");
        inputKreditPaymentPage.clickButtonBayar();
        inputKreditPaymentPage.takeScreenShot("kredit27");
        inputKreditPaymentPage.waitABit(30);
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
    public void createPaymentKreditTransactionTimeout() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData().getEndpointUrl());
        paymentSelectionPage.takeScreenShot("kredit27");
        paymentSelectionPage.clickKartuKreditBtn();
        paymentSelectionPage.takeScreenShot("kredit28");
        paymentSelectionPage.clickPembayaranPenuhBtn();
        paymentSelectionPage.takeScreenShot("kredit29");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("kredit30");
        inputKreditPaymentPage.inputCardNo("4137198118415892");
        inputKreditPaymentPage.takeScreenShot("kredit31");
        inputKreditPaymentPage.inputCardHolderName("testing 15");
        inputKreditPaymentPage.takeScreenShot("kredit32");
        inputKreditPaymentPage.selectCardExpireDate("12", "2023");
        inputKreditPaymentPage.takeScreenShot("kredit33");
        inputKreditPaymentPage.inputCvv("222");
        inputKreditPaymentPage.takeScreenShot("kredit34");
        inputKreditPaymentPage.clickButtonBayar();
        inputKreditPaymentPage.takeScreenShot("kredit35");
        inputKreditPaymentPage.waitABit(30);
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
    public void createPaymentKreditInvalidCVV() {
        PaymentData paymentData = CreatePaymentLinkHelper.generatePaymentLink(100000);
        //web
        WebdriverInit.initialize();
        paymentSelectionPage.openPage(paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData().getEndpointUrl());
        paymentSelectionPage.takeScreenShot("kredit36");
        paymentSelectionPage.clickKartuKreditBtn();
        paymentSelectionPage.takeScreenShot("kredit37");
        paymentSelectionPage.clickPembayaranPenuhBtn();
        paymentSelectionPage.takeScreenShot("kredit38");
        paymentSelectionPage.clickLanjutkanBtn();
        paymentSelectionPage.takeScreenShot("kredit39");
        inputKreditPaymentPage.inputCardNo("4137198118415892");
        inputKreditPaymentPage.takeScreenShot("kredit40");
        inputKreditPaymentPage.inputCardHolderName("testing 15");
        inputKreditPaymentPage.takeScreenShot("kredit41");
        inputKreditPaymentPage.selectCardExpireDate("12", "2023");
        inputKreditPaymentPage.takeScreenShot("kredit42");
        inputKreditPaymentPage.inputCvv("$%$aq");
        inputKreditPaymentPage.takeScreenShot("kredit43");
        inputKreditPaymentPage.clickButtonBayar();
        inputKreditPaymentPage.takeScreenShot("kredit44");
        inputKreditPaymentPage.waitABit(30);
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
