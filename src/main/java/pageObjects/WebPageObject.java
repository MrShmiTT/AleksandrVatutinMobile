package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    @FindBy(css = "input[name='q']")
    WebElement searchField;

    @FindBy(css = "#rso > div")
    List<WebElement> searchResults;

    public List<String> getSearchResults() {
        return searchResults
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
