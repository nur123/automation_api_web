package steps;

import base.BaseTest;
import io.cucumber.java.en.When;

public class PaymentSelectionPageSteps extends BaseTest {
    @When("user open payment link")
    public void userOpenPaymentLink() {
        paymentSelectionPage.openPage(
                paymentData.getSecurePagePaymentApiResponse().getResponseBody().getResponseData()
                        .getEndpointUrl());
    }
    @When("user select debit payment method")
    public void userSelectDebitPaymentMethod() {
        paymentSelectionPage.clickKartuDebitBtn();
        paymentSelectionPage.clickLanjutkanBtn();
    }

    @When("user select credit payment method")
    public void userSelectCreditPaymentMethod() {
        paymentSelectionPage.clickKartuKreditBtn();
        paymentSelectionPage.clickPembayaranPenuhBtn();
        paymentSelectionPage.clickLanjutkanBtn();
    }

    @When("user select BCA VA payment method")
    public void userSelectBCAVAPaymentMethod() {
        paymentSelectionPage.clickVirtualAccountBtn();
        paymentSelectionPage.clickBCAVARadioBtn();
        paymentSelectionPage.clickLanjutkanBtn();
    }
}
