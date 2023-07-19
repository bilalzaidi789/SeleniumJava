import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Headless {

    public static void main(String[] args) throws InterruptedException {
        // Setting up ChromeOptions for headless browsing
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        // Browser invoking
        System.setProperty("webdriver.chrome.driver", "/Users/macair/Downloads/chromedriver_mac64/chromedriver");

        WebDriver driver = new ChromeDriver();

        // Opening google url
        driver.get("https://www.coowncart.com/");

        Thread.sleep(6000);

        // Close the initial pop-up
        WebElement closeButton = driver.findElement(By.className("close-icon"));
        closeButton.click();

        driver.manage().window().maximize();

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div/div[2]/div/div[3]/div[2]/a/div"));

        // Explicit wait for login button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        loginButton.click();

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"panel:r0:0\"]/div/form/div[1]/div/input"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"panel:r0:0\"]/div/form/div[2]/div/input"));
        WebElement loginSubmitButton = driver.findElement(By.xpath("//*[@id=\"panel:r0:0\"]/div/form/div[4]/button"));

        emailInput.sendKeys("syed@cocarting.com");
        passwordInput.sendKeys("123456A");
        loginSubmitButton.click();

        Thread.sleep(12500);

        // Reject the notification alert
        WebElement notificationCancelButton = driver.findElement(By.id("onesignal-slidedown-cancel-button"));
        notificationCancelButton.click();

        // Go to create a dummy CoCart
        WebElement createCoCartButton = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/main/div[4]/div/div[1]/div/div[1]/div/div[2]/h3/a"));
        createCoCartButton.click();

        WebElement cartNameInput = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[4]/div/div/form/div[1]/div/input"));
        WebElement cartTypeSelect = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[4]/div/div/form/div[2]/div/select"));
        WebElement cartDescriptionTextArea = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[4]/div/div/form/div[3]/div/textarea"));
        WebElement cartEmailInput = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[4]/div/div/form/div[4]/div/span/input"));
        WebElement createCartButton = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[4]/div/div/form/div[9]/div/button"));

        cartNameInput.sendKeys("Automated CoCart");
        cartTypeSelect.sendKeys("Private");
        cartDescriptionTextArea.sendKeys("This CoCart is created by automated scripts");
        cartEmailInput.sendKeys("syed@cocarting.com");
        createCartButton.click();

        Thread.sleep(10000);

        // Go to HomePage
        driver.get("https://www.coowncart.com/");

        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div/div[2]/div/div[1]"));
        menuButton.click();

        Thread.sleep(5000);

        // Search for a product (e.g., "Shoes")
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"header-search-bar\"]"));
        searchInput.sendKeys("Shoes");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div/div[2]/div/div[2]/div/form/div/div[2]/button"));
        searchButton.click();

        Thread.sleep(10000);

        // Go to Blog page
        WebElement blogLink = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[3]/footer/div[1]/div/div[2]/div[2]/div/ul/li[4]/a"));
        blogLink.click();
        System.out.println("Blog page working");

        WebElement blogImage = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[1]/div[4]/div/div[1]/div[1]/div[1]/a/img"));
        blogImage.click();

        Thread.sleep(5000);

        // Getting the title and current URL
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println("Test has been passed");

        driver.close();
    }
}