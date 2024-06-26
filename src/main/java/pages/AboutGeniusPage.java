package pages;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.*;
import io.qameta.allure.Step;


public class AboutGeniusPage extends Helpers {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.booking:id/genius_level_title' and @text='Genius Level 3']")
    private RemoteWebElement geniusLevel3Content;
    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;


    public AboutGeniusPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("About Genius content is loaded")
    public boolean aboutGeniusContentLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusLevel3Content)).isDisplayed();
    }

    @Step("Read about genius program confirmation button loaded")
    public boolean gotItButtonLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(gotItButton)).isDisplayed();
    }

    @Step("Confirm reading of about genius program")
    public void clickGotItButton() { gotItButton.click();}

}

