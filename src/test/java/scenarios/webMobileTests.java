package scenarios;

import static utils.PropertyReader.getProperty;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;
import data.WebDataProvider;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"},
          description = "Make sure that Google search of '{keyword}' returns relevant results",
          dataProvider = "DataForGoogleSearchScenario",
          dataProviderClass = WebDataProvider.class)
    public void webTest(String keyword)
        throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get(getProperty("url"));

        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWelement("searchField").sendKeys(keyword);
        getPo().getWelement("searchField").sendKeys(Keys.ENTER);

        List<String> searchResults = new WebPageObject(getDriver()).getSearchResults();
        List<String> properSearchResults = searchResults
            .stream()
            .filter(s -> s.toUpperCase().contains(keyword.toUpperCase()))
            .collect(Collectors.toList());
        assert !properSearchResults.isEmpty() : "There should be some relevant results containing '" + keyword + "'";

        System.out.println("Android web test done");
    }
}
