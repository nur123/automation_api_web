package helpers;

import com.github.javafaker.Faker;
import model.request.inquiry.InquiryRequest;

public class InquiryHelper {

    private static Faker faker = new Faker();

    public static InquiryRequest generateRequestBody(String companyCode, String customerNumber) {
        return InquiryRequest.builder()
                .companyCode(companyCode)
                .customerNumber(customerNumber)
                .requestID(faker.numerify("10000#####"))
                .channelType("6017")
                .transactionDate("02/03/2022 11:03:51")
                .build();
    }
}
