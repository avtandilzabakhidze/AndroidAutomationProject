import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("Product Management")
public class ProductTest extends BaseTest {

    @AfterMethod
    @Description("Reset the application state after each test to ensure test independence.")
    public void tearDown() {
        loginPage.resetAppState();
    }

    @Test(priority = 1)
    @Description("Verify that the product details page displays the image, title, and description of the first product.")
    @Story("Product Details Test")
    public void productDetails() {
        baseLogin();
        productDetailPage.openFirstProduct();

        Assert.assertTrue(productDetailPage.isFirstProductImgDisplayed(), "\n Product Image did not display \n");
        Assert.assertTrue(productDetailPage.isFirstProductDescriptionDisplayed(), "\n Product Description did not display \n");
        Assert.assertTrue(productDetailPage.isFirstProductTitleDisplayed(), "\n Product Title did not display \n");
    }

    @Test(priority = 2)
    @Description("Verify that the first product can be selected.")
    @Story("Product Selection Test")
    public void testSelectFirstProduct() {
        productPage.selectFirstProduct();
        Assert.assertTrue(productPage.isProductSelected(), "\n First product was not selected \n");
    }

    @Test(priority = 3)
    @Description("Verify that the second product can be selected.")
    @Story("Product Selection Test")
    public void testSelectSecondProduct() {
        productPage.selectSecondProduct();
        Assert.assertTrue(productPage.isProductSelected(), "\n Second product was not selected \n");
    }

    @Test(priority = 4)
    @Description("Verify that the first product can be removed after being selected.")
    @Story("Product Removal Test")
    public void testRemoveFirstProduct() {
        productPage.selectFirstProduct();
        productPage.removeFirstProduct();
        Assert.assertFalse(productPage.isProductSelected(), "\n First product was not removed \n");
    }

    @Test(priority = 5)
    @Description("Verify that the second product can be removed after being selected.")
    @Story("Product Removal Test")
    public void testRemoveSecondProduct() {
        productPage.selectSecondProduct();
        productPage.removeSecondProduct();
        Assert.assertFalse(productPage.isProductSelected(), "\n Second product was not removed \n");
    }
}
