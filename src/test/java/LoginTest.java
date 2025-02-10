import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void testLockedOutUser(){
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(),"\n error message did not display \n");
    }

    @Test(priority = 1)
    public void testEmptyPassword(){
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(),"\n error message did not display \n");
    }

    @Test(priority = 2)
    public void testEmptyUsername(){
        loginPage.typeUsername("");
        loginPage.typeUsername("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(),"\n error message did not display \n");
    }

    @Test(priority = 3)
    public void testIncorrectUsername(){
        loginPage.typeUsername("123");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(),"\n error message did not display \n");
    }

    @Test
    public void testIncorrectPassword(){
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.loginErrorMessageIsDisplayed(),"\n error message did not display \n");
    }

    @Test(priority = 4)
    public void testValidParams(){
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isDisplayedProductsTitle(),"\n user did not login \n");
    }
}
