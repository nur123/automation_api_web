package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import webdriver.WebdriverInit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;

public class BasePageObject {

    public WebDriver getDriver() {
        return WebdriverInit.driver;
    }

    public WebElement find(By locator) {
        waitABit(1);
        return getDriver().findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, CharSequence... text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public void selectByVisibleText(By locator, String text) {
        WebElement element = find(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void openPage(String url) {
        getDriver().get(url);
    }

    public void waitABit(Integer seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        byte[] imageBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Paths.get("screenshots/" +name + ".jpeg"),imageBytes, StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

}
