package web.cyclops;

import base.BasePageObject;
import org.openqa.selenium.By;

public class AddQuotePage extends BasePageObject {

  public void openQuotePage(){
    openPage("http://bdd.atlasid.tech/");
  }

  public void inputQuote(String quote) {
    type(By.id("inputQuote"), quote);
  }

  public void selectColor(String color){
    selectByVisibleText(By.id("colorSelect"), color);
  }

  public void clickButtonAddQuote(){
    click(By.id("buttonAddQuote"));
  }
}