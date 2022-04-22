package base;

import api.CheckPaymentStatusClient;
import api.CreateSignatureClient;
import api.SecurePagePaymentClient;
import api.va.CreateTokenClient;
import api.va.InquiryClient;
import api.va.PaymentClient;
import com.github.javafaker.Faker;
import model.helpers.PaymentData;
import web.cyclops.*;

public class BaseTest {

    public static PaymentData paymentData;
    public CreateSignatureClient createSignatureClient = new CreateSignatureClient();
    public SecurePagePaymentClient securePagePaymentClient = new SecurePagePaymentClient();
    public PaymentSelectionPage paymentSelectionPage = new PaymentSelectionPage();
    public InputDebitPaymentPage inputDebitPaymentPage = new InputDebitPaymentPage();
    public CheckPaymentStatusClient checkPaymentStatusClient = new CheckPaymentStatusClient();
    public InputKreditPaymentPage inputKreditPaymentPage = new InputKreditPaymentPage();
    public VAPaymentDetailPage vaPaymentDetailPage = new VAPaymentDetailPage();
    public CreateTokenClient createTokenClient = new CreateTokenClient();
    public InquiryClient inquiryClient = new InquiryClient();
    public PaymentClient paymentClient = new PaymentClient();
    public AddQuotePage addQuotePage = new AddQuotePage();
    public TransactionFailedPage transactionFailedPage = new TransactionFailedPage();
    public Faker faker = new Faker();
}
