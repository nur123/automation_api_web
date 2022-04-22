package web.cyclops;

import base.BasePageObject;
import org.openqa.selenium.By;

public class TransactionFailedPage extends BasePageObject {
    public boolean checkLabelTrxFailedDisplayed() {
        waitABit(5);
        return isDisplayed(By.xpath("//h1[text()='Pemesanan Kamu Belum Berhasil']"));
    }
}
