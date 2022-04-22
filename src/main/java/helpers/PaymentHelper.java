package helpers;

import model.request.inquiry.InquiryRequest;
import model.request.payment.PaymentRequest;

import java.util.Collections;

public class PaymentHelper {

    public static PaymentRequest generateRequestBody(InquiryRequest inquiryRequest, String amount) {

        return PaymentRequest.builder()
                .companyCode(inquiryRequest.getCompanyCode())
                .customerNumber(inquiryRequest.getCustomerNumber())
                .requestID(inquiryRequest.getRequestID())
                .channelType(inquiryRequest.getChannelType())
                .customerName("Test from SP")
                .currencyCode("IDR")
                .paidAmount(amount)
                .totalAmount(amount)
                .transactionDate("02/03/2022 11:05:17")
                .subCompany("00000")
                .reference("2020")
                .detailBills(Collections.emptyList())
                .flagAdvice("N")
                .additionalData("agus").build();

    }


}
