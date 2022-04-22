package web.cyclops;

import base.BasePageObject;
import org.openqa.selenium.By;

public class VAPaymentDetailPage extends BasePageObject {

    public String getVANumberText() {
        return getText(By.cssSelector(".va-number"));
    }

    public void clickSelesaiBtn() {
        click(By.xpath("//button[contains(text(), 'Selesai')]"));
    }
}