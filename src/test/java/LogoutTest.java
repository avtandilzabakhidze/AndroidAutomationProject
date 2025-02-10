import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test
    public void testLogout(){
        baseLoginTest();
        loginPage.logOut();

        Assert.assertTrue(loginPage.usernameInputIsDisplayed(),"\n username input is not displayed \n");
        Assert.assertTrue(loginPage.passwordInputIsDisplayed(),"\n password input is not displayed \n");
    }
}
