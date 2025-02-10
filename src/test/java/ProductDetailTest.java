import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailTest extends BaseTest{
    @Test
    public void testLogout(){
        baseLogin();
        productDetailPage.openFirstProduct();

        Assert.assertTrue(productDetailPage.isFirstProductImgDisplayed(),"\n product Image did not displayed \n");
        Assert.assertTrue(productDetailPage.isFirstProductDescriptionDisplayed(),"\n product Description did not displayed \n");
        Assert.assertTrue(productDetailPage.isFirstProductTitleDisplayed(),"\n product Title did not displayed \n");
    }
}
