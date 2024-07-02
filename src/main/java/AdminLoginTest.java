import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AdminLoginTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laksh\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");

        // Set Chrome options
        // Run Chrome in headless mode (without GUI)

        // Instantiate ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the admin login page
        driver.get("http://localhost:8080/completeCopy/AdminLogin.jsp");

        // Enter the username and password
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin");

        // Submit the login form
        WebElement loginButton = driver.findElement(By.id("loginbutton"));
        loginButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(2000); // Adjust the delay if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the admin panel page is displayed
        String expectedTitle = "Admin Panel";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Admin login test passed!");
        } else {
            System.out.println("Admin login test failed!");
        }

        // Close the browser
        driver.quit();
    }
}
