import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test(priority = 1)
    public void testLogout(){
        baseLogin();
        loginPage.logOut();

        Assert.assertTrue(loginPage.usernameInputIsDisplayed(),"\n username input is not displayed \n");
        Assert.assertTrue(loginPage.passwordInputIsDisplayed(),"\n password input is not displayed \n");
    }
}
