package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // obtener numero de transacciones
    public int getTransactionCount() {
        List<WebElement> transactionRows = driver.findElements(By.cssSelector("table.table.table-padded tbody tr"));
        return transactionRows.size();
    }

    // validar las descripciones de transacciones
    public boolean validateTransactionDescriptions() {
        List<WebElement> transactionRows = driver.findElements(By.cssSelector("table.table.table-padded tbody tr"));

        for (WebElement row : transactionRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String description = cells.get(2).getText();

            // Validación simple, puedes ajustar la lógica
            if (description == null || description.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
