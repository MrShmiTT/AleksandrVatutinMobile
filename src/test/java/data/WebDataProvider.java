package data;

import org.testng.annotations.DataProvider;

public class WebDataProvider {

    @DataProvider(name = "DataForGoogleSearchScenario")
    private Object[][] googleSearchDataProvider() {
        return new Object[][] {
            {"EPAM"}
        };
    }
}
