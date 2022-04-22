package steps;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class InputCreditPaymentPageSteps extends BaseTest {
    @When("user input card number {string} on credit payment page")
    public void userInputCardNumberOnCreditPaymentPage(String cardNo) {
        inputKreditPaymentPage.inputCardNo(cardNo);
    }

    @When("user input card holder name {string} on credit payment page")
    public void userInputCardHolderNameOnCreditPaymentPage(String cardHolderName) {
        inputKreditPaymentPage.inputCardHolderName(cardHolderName);
    }

    @When("user select expireddate {string} - {string} on credit payment page")
    public void userSelectExpireddateOnCreditPaymentPage(String month, String year) {
        inputKreditPaymentPage.selectCardExpireDate(month, year);
    }

    @When("user input cvv number {string} on credit payment page")
    public void userInputCvvNumberOnCreditPaymentPage(String cvv) {
        inputKreditPaymentPage.inputCvv(cvv);
    }

    @When("user click button bayar on credit payment page")
    public void userClickButtonBayarOnCreditPaymentPage() {
        inputKreditPaymentPage.clickButtonBayar();
    }

    @Then("user see error message card not valid on credit payment page")
    public void userSeeErrorMessageCardNotValidOnCreditPaymentPage() {
        Assertions.assertTrue(inputKreditPaymentPage.checkInvalidCardNo());
    }

    @Then("user see eror message payment will be not success on credit payment page")
    public void userSeeErorMessagePaymentWillBeNotSuccessOnCreditPaymentPage() {
        inputKreditPaymentPage.clickButtonBayar();
    }

    @Then("user see error message cvv not valid on credit payment page")
    public void userSeeErrorMessageCvvNotValidOnCreditPaymentPage() {
        Assertions.assertTrue(inputKreditPaymentPage.checkInvalidCvv());
    }

    @Then("user see error message transaction will be not success on credit payment page")
    public void userSeeErrorMessageTransactionWillBeNotSuccessOnCreditPaymentPage() {
        Assertions.assertTrue(transactionFailedPage.checkLabelTrxFailedDisplayed());
    }
}