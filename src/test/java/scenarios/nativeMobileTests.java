package scenarios;

import static utils.PropertyReader.getProperty;

import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
          description = "register a new account and then sign in. Make sure that you are on the BudgetActivity page")
    public void nativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        //Account registration
        getPo().getWelement("registerBtn").click();
        getPo().getWelement("registrationEmail").sendKeys(getProperty("email"));
        getPo().getWelement("registrationUsername").sendKeys(getProperty("username"));
        getPo().getWelement("registrationPassword").sendKeys(getProperty("password"));
        getPo().getWelement("registrationConfirmPassword").sendKeys(getProperty("password"));
        getPo().getWelement("registerNewAccountBtn").click();

        //Sign in
        getPo().getWelement("loginEmail").sendKeys(getProperty("email"));
        getPo().getWelement("loginPwd").sendKeys(getProperty("password"));
        getPo().getWelement("signInBtn").click();

        assert getPo().getWelement("frameTitle").getText().equals(getProperty("title")) : "This is not expected title";
        System.out.println("Android native test done");
    }
}
