import org.example.swt301_lab_4.CommissionCalculator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IntegrationTest {
    @Test
    public void testCase1() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);


            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.GENERAL);

            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("10000.1");
            String priceString = itemPrice.getAttribute("value");
            double priceInput = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));
            Thread.sleep(2000);

            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = priceInput * 0.05D;
            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase2() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.GENERAL);


            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("9999.9");
            String priceString = itemPrice.getAttribute("value");
            double priceInput = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));
            Thread.sleep(2000);

            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = priceInput * 0.1D;

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase3() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("Yes");
            Thread.sleep(2000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.BONUS);


            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("999.9");
            String priceString = itemPrice.getAttribute("value");
            double priceInput = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));
            Thread.sleep(2000);


            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = priceInput * 0.05D;

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase4() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("Yes");
            Thread.sleep(2000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.BONUS);


            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("1000.1");
            Thread.sleep(2000);

            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = 25D;

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase5() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.BONUS);


            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("0.1");
            String priceString = itemPrice.getAttribute("value");
            double priceInput = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));
            Thread.sleep(2000);

            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = priceInput * 0.1D;

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase6() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.BONUS);


            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("2000");
            Thread.sleep(2000);

            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));
            double expected = 75D;
            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase7() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.STANDARD);


            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("500");
            Thread.sleep(2000);

            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = 0D;

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");

            salary = driver.findElement(By.id("isSalaried"));
            select = new Select(salary);
            select.selectByVisibleText("Yes");
            Thread.sleep(2000);

            general = driver.findElement(By.id("itemType"));
            generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.STANDARD);


            customer = driver.findElement(By.id("isRegularCustomer"));
            customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(2000);

            itemPrice = driver.findElement(By.id("itemPrice"));
            itemPrice.sendKeys("500");
            Thread.sleep(2000);

            calculate = driver.findElement(By.id("calculateCommission"));
            calculate.click();
            result = driver.findElement(By.id("result"));
            resultString = result.getText();
            resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase8() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);

            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);

            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("Yes");
            Thread.sleep(2000);
            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            WebElement itemPrice = driver.findElement(By.id("itemPrice"));
            WebElement calculate = driver.findElement(By.id("calculateCommission"));
            generalSelect.selectByValue(CommissionCalculator.GENERAL);
            Thread.sleep(1000);
            itemPrice.clear();
            itemPrice.sendKeys("5000");
            Thread.sleep(1000);
            calculate.click();
            WebElement result = driver.findElement(By.id("result"));
            String resultString = result.getText();
            double resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            double expected = 0D;

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);

            salary = driver.findElement(By.id("isSalaried"));
            select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(2000);

            customer = driver.findElement(By.id("isRegularCustomer"));
            customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("Yes");
            Thread.sleep(2000);
            general = driver.findElement(By.id("itemType"));
            generalSelect = new Select(general);
            itemPrice = driver.findElement(By.id("itemPrice"));
            calculate = driver.findElement(By.id("calculateCommission"));
            generalSelect.selectByValue(CommissionCalculator.BONUS);
            Thread.sleep(1000);
            itemPrice.clear();
            itemPrice.sendKeys("5000");
            Thread.sleep(1000);
            calculate.click();
            result = driver.findElement(By.id("result"));
            resultString = result.getText();
            resultCom = Double.parseDouble(resultString.replaceAll("[^0-9.]", ""));

            assertEquals(expected, resultCom, 1e-6, "Result is incorrect");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase9() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("http://localhost:9999/SWT301_Lab_4_war_exploded/commission");
            Thread.sleep(2000);


            WebElement salary = driver.findElement(By.id("isSalaried"));
            Select select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(1000);

            WebElement general = driver.findElement(By.id("itemType"));
            Select generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.GENERAL);
            Thread.sleep(1000);

            WebElement customer = driver.findElement(By.id("isRegularCustomer"));
            Select customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("No");
            Thread.sleep(1000);

            String[] invalidPrices = {"-0.1", ""};

            for (String invalidPrice : invalidPrices) {
                WebElement itemPrice = driver.findElement(By.id("itemPrice"));
                itemPrice.clear();
                itemPrice.sendKeys(invalidPrice);
                Thread.sleep(1000);
                WebElement calculate = driver.findElement(By.id("calculateCommission"));
                calculate.click();
                Thread.sleep(1000);
                WebElement errorMessage = driver.findElement(By.id("error-message"));
                String actualError = errorMessage.getText();
                String expectedError = CommissionCalculator.EXCEPTION_MESSAGE;
                assertEquals(expectedError, actualError, "Error message not displayed correctly");
            }


            salary = driver.findElement(By.id("isSalaried"));
            select = new Select(salary);
            select.selectByVisibleText("Yes");
            Thread.sleep(1000);

            general = driver.findElement(By.id("itemType"));
            generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.GENERAL);
            Thread.sleep(1000);

            customer = driver.findElement(By.id("isRegularCustomer"));
            customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("Yes");
            Thread.sleep(1000);

            for (String invalidPrice : invalidPrices) {
                WebElement itemPrice = driver.findElement(By.id("itemPrice"));
                itemPrice.clear();
                itemPrice.sendKeys(invalidPrice);
                Thread.sleep(1000);
                WebElement calculate = driver.findElement(By.id("calculateCommission"));
                calculate.click();
                Thread.sleep(1000);
                WebElement errorMessage = driver.findElement(By.id("error-message"));
                String actualError = errorMessage.getText();
                String expectedError = CommissionCalculator.EXCEPTION_MESSAGE;
                assertEquals(expectedError, actualError, "Error message not displayed correctly");
            }


            salary = driver.findElement(By.id("isSalaried"));
            select = new Select(salary);
            select.selectByVisibleText("No");
            Thread.sleep(1000);

            general = driver.findElement(By.id("itemType"));
            generalSelect = new Select(general);
            generalSelect.selectByValue(CommissionCalculator.GENERAL);
            Thread.sleep(1000);

            customer = driver.findElement(By.id("isRegularCustomer"));
            customerSelect = new Select(customer);
            customerSelect.selectByVisibleText("Yes");
            Thread.sleep(1000);

            for (String invalidPrice : invalidPrices) {
                WebElement itemPrice = driver.findElement(By.id("itemPrice"));
                itemPrice.clear();
                itemPrice.sendKeys(invalidPrice);
                Thread.sleep(1000);
                WebElement calculate = driver.findElement(By.id("calculateCommission"));
                calculate.click();
                Thread.sleep(1000);
                WebElement errorMessage = driver.findElement(By.id("error-message"));
                String actualError = errorMessage.getText();
                String expectedError = CommissionCalculator.EXCEPTION_MESSAGE;
                assertEquals(expectedError, actualError, "Error message not displayed correctly");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

}
