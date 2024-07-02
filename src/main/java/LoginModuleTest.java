import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginModuleTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laksh\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("http://localhost:8080/completeCopy/Login.jsp");

        // Find the username and password input fields and enter valid credentials
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys("leo");
        passwordInput.sendKeys("leo");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Wait for the page to load and check if the user has been logged in successfully
        WebElement welcomeMessage = driver.findElement(By.id("welcome-message"));
        String messageText = welcomeMessage.getText();
        if (messageText.contains("User Page")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();
    }
}
