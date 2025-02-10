import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @AfterMethod
    public void tearDown() {
        loginPage.resetAppState();
    }

    @Test
    public void productDetails() {
        baseLogin();
        productDetailPage.openFirstProduct();

        Assert.assertTrue(productDetailPage.isFirstProductImgDisplayed(), "\n Product Image did not display \n");
        Assert.assertTrue(productDetailPage.isFirstProductDescriptionDisplayed(), "\n Product Description did not display \n");
        Assert.assertTrue(productDetailPage.isFirstProductTitleDisplayed(), "\n Product Title did not display \n");
    }

    @Test
    public void testSelectFirstProduct() {
        productPage.selectFirstProduct();
        Assert.assertTrue(productPage.isProductSelected(),
                "\n First product was not selected \n");
    }

    @Test
    public void testSelectSecondProduct() {
        productPage.selectSecondProduct();
        Assert.assertTrue(productPage.isProductSelected(),
                "\n Second product was not selected \n");
    }

    @Test
    public void testRemoveFirstProduct() {
        productPage.selectFirstProduct();
        productPage.removeFirstProduct();
        Assert.assertFalse(productPage.isProductSelected(),
                "\n First product was not removed \n");
    }

    @Test
    public void testRemoveSecondProduct() {
        productPage.selectSecondProduct();
        productPage.removeSecondProduct();
        Assert.assertFalse(productPage.isProductSelected(),
                "\n Second product was not removed \n");
    }
}
