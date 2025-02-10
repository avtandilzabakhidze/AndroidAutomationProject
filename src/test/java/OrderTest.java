import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    @AfterMethod
    public void tearDown() {
        loginPage.resetAppState();
    }

    @Test(priority = 1)
    public void testOrderFirstProduct() {
        baseLogin();
        orderPage.selectFirstProduct();
        orderPage.openCart();
        orderPage.proceedToCheckout();
        orderPage.enterCustomerDetails("one", "two", "123");
        orderPage.continueCheckout();
        orderPage.finishOrder();
        orderPage.returnHome();

        Assert.assertTrue(orderPage.isProductTitleDisplayedOnHomePage(), "\n Order process was not completed successfully \n");
    }

    @Test(priority = 2)
    public void testOrderSecondProduct() {
        orderPage.selectSecondProduct();
        orderPage.openCart();
        orderPage.proceedToCheckout();
        orderPage.enterCustomerDetails("two", "three", "123");
        orderPage.continueCheckout();
        orderPage.finishOrder();
        orderPage.returnHome();

        Assert.assertTrue(orderPage.isProductTitleDisplayedOnHomePage(), "\n Multiple product order process was not completed successfully \n");
    }

    @Test(priority = 3)
    public void testIncompleteCustomerDetails() {
        orderPage.selectFirstProduct();
        orderPage.openCart();
        orderPage.proceedToCheckout();
        orderPage.enterCustomerDetails("", "two", "23");
        orderPage.continueCheckout();

        Assert.assertTrue(orderPage.errorMessageIsDisplayed(), "\n Order process allowed incomplete customer details \n");
    }
}
