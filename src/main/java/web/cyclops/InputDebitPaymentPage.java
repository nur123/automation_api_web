package web.cyclops;

import base.BasePageObject;
import org.openqa.selenium.By;

public class InputDebitPaymentPage extends BasePageObject {

    public void inputCardNo(String cardNo) {
        type(By.id("cardNo"), cardNo);
    }

    public boolean checkInvalidCardNo() {
        return find(By.xpath("//div[contains(text(),'Nomor tidak valid.')]")).isDisplayed();
    }

    public boolean checkInvalidCvv() {
        return find(By.id("ccvNo")).isDisplayed();
    }

    public void inputCardHolderName(String name) {
        type(By.id("cardHolderName"), name);
    }

    public void selectCardExpireDate(String month, String year) {
        selectByVisibleText(By.id("expiredDateMonth"), month);
        selectByVisibleText(By.id("expiredDateYear"), year);
    }

    public void inputCvv(String cvv) {
        type(By.id("ccvNo"), cvv);
    }

    public boolean clickButtonBayar() {
        click(By.xpath("//button[@type='button'][contains(text(),'Bayar')]"));
        return false;
    }
}