package LoginTests;

import com.Automation.BaseTest;
import com.Helper.MessageConstants;
import com.PageObjects.LoginPage;
import com.PageObjects.ProductsPage;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestCases extends BaseTest {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        loginPage = new LoginPage(driverFactory);
        productsPage = new ProductsPage(driverFactory);
    }

    @Test
    public void loginTest_Positive() {
        loginPage.LoginAction("standard_user", "secret_sauce");
        Assert.isTrue(productsPage.ProductsPageOpened(), "!ProductsPageOpened");
    }

    @Test
    public void loginTest_Negative_IncorrectPassword() {
        loginPage.LoginAction("standard_user", "secret_sauce2");
        org.testng.Assert.assertTrue(loginPage.isErrorMessageDisplayed(), MessageConstants.GeneralAssertionMessage);
        org.testng.Assert.assertEquals(loginPage.getErrorMessageText(), MessageConstants.InvalidUserNamePasswordMessage);
    }

    @Test
    public void loginTest_Negative_LockedUser() {
        loginPage.LoginAction("locked_out_user", "secret_sauce");
        org.testng.Assert.assertTrue(loginPage.isErrorMessageDisplayed(), MessageConstants.GeneralAssertionMessage);
        org.testng.Assert.assertEquals(loginPage.getErrorMessageText(), MessageConstants.LockedOutUserMessage);
    }

    @AfterClass
    public void teardown() {
        super.tearDown();
    }

}
