package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testrail.Status;
import testrail.TestrailHelper;
import webdriver.WebdriverInit;

public class WebdriverHook {

  @Before
  public void initialize() {
    WebdriverInit.initialize();
  }

  @After
  public void quit(Scenario scenario) {
    updateTestrailResult(scenario);
    WebdriverInit.quit();
  }

  private void updateTestrailResult(Scenario scenario) {
    TestrailHelper testrailHelper = new TestrailHelper();
    scenario.getSourceTagNames().stream().filter(data -> data.contains("@C"))
        .findFirst().ifPresent(tags -> {
          String temp = tags.replace("@", "");
          if (scenario.isFailed()) {
            testrailHelper.updateTestCase(temp, 2, Status.FAILED);
          } else {
            testrailHelper.updateTestCase(temp, 2, Status.PASSED);
          }
        });
  }

}
