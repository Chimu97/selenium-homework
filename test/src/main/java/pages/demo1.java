package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class demo1 {
    public static void main (String [] args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement userNameInput = driver.findElement(By.id("username"));
        userNameInput.sendKeys("sbarrios");

        WebElement userPasswordInput = driver.findElement(By.id("password"));
        userPasswordInput.sendKeys("123");

        WebElement loginButton = driver.findElement(By.id("log-in"));
        loginButton.click();


        WebElement userTotalBalanceValue = driver.findElement(By.cssSelector("div.balance-value span:not(.trending-down-basic)"));
        System.out.println("The total balance is: " + userTotalBalanceValue.getText());

        WebElement userCreditAvailable = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]"));
        System.out.println("The credit available is: " + userCreditAvailable.getText());

        System.out.println("------------------------------------");
        System.out.println("Recent transactions:");
        System.out.println("------------------------------------");


        List<WebElement> transactionRows = driver.findElements(By.cssSelector("table.table.table-padded tbody tr"));

        for (WebElement row : transactionRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String status = cells.get(0).getText();
            String description = cells.get(2).getText();
            String amount = cells.get(4).getText();

            System.out.println("Status: " + status + ". Description: " + description + ". Amount: " + amount);

        }

    }
}