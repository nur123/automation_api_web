package steps;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import web.cyclops.AddQuotePage;

public class AddQuotePageSteps extends BaseTest {
    @Given("user open add quote page")
    public void userOpenAddQuotePage() {
        addQuotePage.openQuotePage();
    }

    @When("user input quote {string}")
    public void userInputQuote(String quote) {

    }

    @When("user select color {string}")
    public void userSelectColor(String arg0) {

    }

    @When("user click button add quote")
    public void userClickButtonAddQuote() {

    }
}
