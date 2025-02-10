import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @AfterMethod
    public void tearDown() {
        loginPage.resetAppState();
    }

    @Test(priority = 1)
    public void productDetails() {
        baseLogin();
        productDetailPage.openFirstProduct();

        Assert.assertTrue(productDetailPage.isFirstProductImgDisplayed(), "\n Product Image did not display \n");
        Assert.assertTrue(productDetailPage.isFirstProductDescriptionDisplayed(), "\n Product Description did not display \n");
        Assert.assertTrue(productDetailPage.isFirstProductTitleDisplayed(), "\n Product Title did not display \n");
    }

    @Test(priority = 2)
    public void testSelectFirstProduct() {
        productPage.selectFirstProduct();
        Assert.assertTrue(productPage.isProductSelected(),
                "\n First product was not selected \n");
    }

    @Test(priority = 3)
    public void testSelectSecondProduct() {
        productPage.selectSecondProduct();
        Assert.assertTrue(productPage.isProductSelected(),
                "\n Second product was not selected \n");
    }

    @Test(priority = 4)
    public void testRemoveFirstProduct() {
        productPage.selectFirstProduct();
        productPage.removeFirstProduct();
        Assert.assertFalse(productPage.isProductSelected(),
                "\n First product was not removed \n");
    }

    @Test(priority = 5)
    public void testRemoveSecondProduct() {
        productPage.selectSecondProduct();
        productPage.removeSecondProduct();
        Assert.assertFalse(productPage.isProductSelected(),
                "\n Second product was not removed \n");
    }
}
