import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("User Management")
public class LoginTest extends BaseTest {

    @Test(priority = 1)
    @Description("Verify that locked-out users cannot log in.")
    @Story("Login Negative Test")
    public void testLockedOutUser() {
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(), "\n error message did not display \n");
    }

    @Test(priority = 2)
    @Description("Verify that login fails when the password field is empty.")
    @Story("Login Negative Test")
    public void testEmptyPassword() {
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(), "\n error message did not display \n");
    }

    @Test(priority = 3)
    @Description("Verify that login fails when the username field is empty.")
    @Story("Login Negative Test")
    public void testEmptyUsername() {
        loginPage.typeUsername("");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(), "\n error message did not display \n");
    }

    @Test(priority = 4)
    @Description("Verify that login fails with an incorrect username.")
    @Story("Login Negative Test")
    public void testIncorrectUsername() {
        loginPage.typeUsername("123");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(), "\n error message did not display \n");
    }

    @Test(priority = 5)
    @Description("Verify that login fails with an incorrect password.")
    @Story("Login Negative Test")
    public void testIncorrectPassword() {
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(), "\n error message did not display \n");
    }

    @Test(priority = 6)
    @Description("Verify that login succeeds with valid credentials.")
    @Story("Login Positive Test")
    public void testValidParams() {
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isDisplayedProductsTitle(), "\n user did not login \n");
    }
}
