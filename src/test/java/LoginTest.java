import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        MobileElement userId = ad.findElementByAccessibilityId("test-Username");
        MobileElement password = ad.findElementByAccessibilityId("test-Password");
        MobileElement login_Button = ad.findElementByAccessibilityId("test-LOGIN");


        userId.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login_Button.click();

        ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actualString = ad.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView").getText();
        String expectedString = "PRODUCTS";
        Assert.assertEquals(actualString, expectedString);

    }

}
