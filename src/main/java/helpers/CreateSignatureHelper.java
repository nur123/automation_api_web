package helpers;

import com.github.javafaker.Faker;
import model.request.create_signature.CreateSignatureRequest;
import model.request.create_signature.CreateTrxRefRequest;
import model.request.create_signature.CustomerDetails;
import model.request.create_signature.TransactionDetails;

public class CreateSignatureHelper {

    private static Faker faker = new Faker();

    public static CreateSignatureRequest generateValidRequest(int amount) {
        CustomerDetails customerDetails = CustomerDetails.builder()
                .email("jihan.nabilah@ottodigital.id")
                .firstName("jihan")
                .lastName("jihan")
                .phone("6283833507372").build();

        TransactionDetails transactionDetails = TransactionDetails.builder()
//                .amount(Integer.parseInt(faker.numerify("1####")))
                .amount(amount)
                .currency("IDR")
                .merchantName("BUMAME")
                .orderId(faker.numerify("082021-######"))
                .vaOrderId("")
                .promoCode("")
                .vabca("")
                .valain("")
                .vamandiri("").build();

        CreateSignatureRequest createSignatureRequest = CreateSignatureRequest.builder()
                .customerDetails(customerDetails)
                .transactionDetails(transactionDetails)
                .build();

        return createSignatureRequest;
    }

    public static CreateTrxRefRequest generateTrxRefRequest(String orderId) {
        return CreateTrxRefRequest.builder()
                .trxRef(orderId)
                .build();
    }
}