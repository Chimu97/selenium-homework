package pagesTests;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.HomePage;

import  static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterUsername("sbarrios");
        loginPage.enterPassword("123");
        loginPage.clickLogin();

        // Validación de la cantidad de transacciones después de iniciar sesión
        assertEquals(6, homePage.getTransactionCount());
        assertEquals(true, homePage.validateTransactionDescriptions());
    }
}
