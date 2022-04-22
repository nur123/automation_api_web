package web.cyclops;

import base.BasePageObject;
import org.openqa.selenium.By;

public class PaymentSelectionPage extends BasePageObject {

    public void clickKartuDebitBtn() {
        click(By.xpath("//button[contains(text(),'Kartu Debit')]"));
    }

    public void clickKartuKreditBtn() {
        click(By.xpath("//button[contains(text(),'Kartu Kredit')]"));
    }

    public void clickVirtualAccountBtn() {
        click(By.xpath("//button[contains(text(),'Virtual Account')]"));
    }

    public void clickBCAVARadioBtn() {
        click(By.xpath("//p[text()='BCA']"));
    }

    public void clickPembayaranPenuhBtn() { click(By.xpath("//button[contains(text(),'Pembayaran Penuh')]")); }

    public void clickLanjutkanBtn() {
        click(By.xpath("//button[contains(text(),'Lanjutkan')]"));
    }

    public void open(String url) {
        openPage(url);
    }
}
