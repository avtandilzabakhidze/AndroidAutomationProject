import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("User Management")
public class LogoutTest extends BaseTest {

    @Test(priority = 1)
    @Description("Verify that user can successfully log out and see the login page inputs.")
    @Story("Logout Test")
    public void testLogout() {
        baseLogin();
        loginPage.logOut();

        Assert.assertTrue(loginPage.usernameInputIsDisplayed(), "\n username input is not displayed \n");
        Assert.assertTrue(loginPage.passwordInputIsDisplayed(), "\n password input is not displayed \n");
    }
}
