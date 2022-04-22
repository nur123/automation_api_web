package steps;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class InputDebitPaymentPageSteps extends BaseTest {
    @When("user input card number {string} on debit payment page")
    public void userInputCardNumberOnDebitPaymentPage(String cardNo) {
        inputDebitPaymentPage.inputCardNo(cardNo);
    }

    @When("user input card holder name {string} on debit payment page")
    public void userInputCardHolderNameOnDebitPaymentPage(String cardHolderName) {
        inputDebitPaymentPage.inputCardHolderName(cardHolderName);
    }

    @When("user select expireddate {string} - {string} on debit payment page")
    public void userSelectExpireddateOnDebitPaymentPage(String month, String year) {
        inputDebitPaymentPage.selectCardExpireDate(month, year);
    }

    @When("user input cvv number {string} on debit payment page")
    public void userInputCvvNumberOnDebitPaymentPage(String cvv) {
        inputDebitPaymentPage.inputCvv(cvv);
    }

    @When("user click button bayar on debit payment page")
    public void userClickButtonBayarOnDebitPaymentPage() {
        inputDebitPaymentPage.clickButtonBayar();
    }

    @Then("user see error message card not valid on debit payment page")
    public void userSeeErrorMessageCardNotValidOnDebitPaymentPage() {
        Assertions.assertTrue(inputDebitPaymentPage.checkInvalidCardNo());
    }

    @Then("user see error message cvv not valid on debit payment page")
    public void userSeeErrorMessageCvvNotValidOnDebitPaymentPage() {
        Assertions.assertTrue(inputDebitPaymentPage.checkInvalidCvv());
    }

    @Then("user see eror message transaction will be not success on debit payment page")
    public void userSeeErrorMessageTransactionWillBeNotSuccessOnDebitPaymentPage() {
        Assertions.assertTrue(transactionFailedPage.checkLabelTrxFailedDisplayed());
    }
}