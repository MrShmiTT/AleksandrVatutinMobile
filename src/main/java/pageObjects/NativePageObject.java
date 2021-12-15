package pageObjects;

import static utils.Constants.APP_PACKAGE_NAME_ID;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "login_email")
    WebElement loginEmail;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "login_pwd")
    WebElement loginPwd;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "email_sign_in_button")
    WebElement signInBtn;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "register_button")
    WebElement registerBtn;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "registration_email")
    WebElement registrationEmail;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "registration_username")
    WebElement registrationUsername;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "registration_password")
    WebElement registrationPassword;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "registration_confirm_password")
    WebElement registrationConfirmPassword;

    @AndroidFindBy(id = APP_PACKAGE_NAME_ID + "register_new_account_button")
    WebElement registerNewAccountBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView")
    WebElement frameTitle;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
