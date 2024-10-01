package personal.anand.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import personal.anand.qa.opencart.base.BaseTest;
import personal.anand.qa.opencart.constants.AppConstants;
import java.util.HashMap;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass
    public void productInfoPageSetup() {
        accountPage = loginPage.doLogin(prop.getProperty("login"), prop.getProperty("password"));
    }

    @DataProvider
    private Object[][] cartData() {
        return new Object[][]{
                {"macbook", "MacBook Air"},
                {"macbook", "MacBook Pro"},
                {"samsung", "Samsung Galaxy Tab 10.1"}
        };
    }

    @Test(dataProvider = "cartData")
    public void addToCartTest(String searchKey, String product) {
        searchResultsPage = accountPage.doSearch(searchKey);
        productInfoPage = searchResultsPage.selectSearchresults(product);
        String alertMsg = productInfoPage.addToCart();
        Assert.assertTrue(alertMsg.contains(String.format(AppConstants.ADD_CART_SUCCESS_MESSAGE, product)));
    }

    @DataProvider
    private Object[][] metaData() {
        return new Object[][]{
                {"macbook", "MacBook Air",AppConstants.MACBOOK_BRAND,AppConstants.MACBOOK_AIR_REWARDS_POINTS,AppConstants.MACBOOK_AIR_PRODUCT_CODE},
                {"macbook", "MacBook Pro",AppConstants.MACBOOK_BRAND,AppConstants.MACBOOK_PRO_REWARDS_POINTS,AppConstants.MACBOOK_PRO_PRODUCT_CODE},
                {"canon", "Canon EOS 5D","Canon",AppConstants.CANNON_EOS_5D_REWARDS_POINTS,AppConstants.CANNON_EOS_5D_PRODUCT_CODE}
        };
    }

//    @Test(dataProvider = "metaData")
//    public void checkProductMetaDataDetails(String searchKey, String product, String brand, String rewardPoints, String ProductCode) {
//        SoftAssert softAssert=new SoftAssert();
//        searchResultsPage = accountPage.doSearch(searchKey);
//        productInfoPage = searchResultsPage.selectSearchresults(product);
//        HashMap<String, String> actualProductDetails = productInfoPage.getProductMetaData();
//        softAssert.assertEquals(actualProductDetails.get("Brand"), brand);
//        softAssert.assertEquals(actualProductDetails.get("Reward Points"), rewardPoints);
//        softAssert.assertEquals(actualProductDetails.get("Product Code"), ProductCode);
//        softAssert.assertAll();
//    }


}
