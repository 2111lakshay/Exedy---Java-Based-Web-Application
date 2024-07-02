import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomeTest {
    public static void main(String[] args) {
        // Set system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laksh\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Launch the application
        driver.get("http://localhost:8080/completeCopy/Home.jsp");

        // Wait until the page title is correct
        String expectedTitle = "Home";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is correct: " + actualTitle);
        } else {
            System.out.println("Title is incorrect. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }

        // Verify the presence of the login button
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        if (loginButton.isDisplayed()) {
            System.out.println("Login button is displayed.");
        } else {
            System.out.println("Login button is not displayed.");
        }

        // Verify the presence of the admin button
        WebElement adminButton = driver.findElement(By.linkText("Admin"));
        if (adminButton.isDisplayed()) {
            System.out.println("Admin button is displayed.");
        } else {
            System.out.println("Admin button is not displayed.");
        }

        // Verify the presence of the viewer button
        WebElement viewerButton = driver.findElement(By.linkText("Viewer"));
        if (viewerButton.isDisplayed()) {
            System.out.println("Viewer button is displayed.");
        } else {
            System.out.println("Viewer button is not displayed.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        

        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Login")));
        loginLink.click();

        for (int i = 1; i <= 10; i++) {
            // Find the "Login" link and click it
            WebElement registerLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Register")));
            registerLink.click();

            // Find the username and password fields and enter the credentials
            WebElement fullnameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fullName")));
            WebElement emailField = driver.findElement(By.name("email"));
            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));
            fullnameField.sendKeys("name" + i);
            emailField.sendKeys("name" + i + "@gmail.com");
            usernameField.sendKeys("name" + i);
            passwordField.sendKeys("name" + i);

            // Submit the login form
            WebElement registerButton = driver.findElement(By.xpath("//button[text()='Register']"));
            registerButton.click();
            
            WebElement usernameField1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
            WebElement passwordField1 = driver.findElement(By.name("password"));
            
            usernameField1.sendKeys("name" + i);
            passwordField1.sendKeys("name" + i);
            
            WebElement registerButton1 = driver.findElement(By.xpath("//button[text()='Login']"));
            registerButton1.click();
            
            WebElement addProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add")));
            addProduct.click();
            
            WebElement productName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("productName")));
            WebElement functionality = driver.findElement(By.name("functionality"));
            WebElement performance = driver.findElement(By.name("performance"));
            WebElement usability = driver.findElement(By.name("usability"));
            WebElement cost = driver.findElement(By.name("cost"));
            WebElement value = driver.findElement(By.name("value"));
            WebElement environmentalImpact = driver.findElement(By.name("environmentalImpact"));
            productName.sendKeys("Product" + i);
            functionality.sendKeys("3");
            performance.sendKeys("3");
            usability.sendKeys("3");
            cost.sendKeys("3");
            value.sendKeys("3");
            environmentalImpact.sendKeys("3");
            
            WebElement addProduct1 = driver.findElement(By.xpath("//button[text()='Add']"));
            addProduct1.click();
            
            	
            WebElement exitLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Exit")));
           	exitLink.click();
            
            
            System.out.println("User name"+i+" tested successfully!");
            
        }

        

        // Close the browser
        driver.quit();
    }
}