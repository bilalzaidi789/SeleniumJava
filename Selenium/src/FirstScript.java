
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
	
		
		
		
		//browser invoking
		
		System.setProperty("webdriver.chrome.driver","/Users/macair/Downloads/chromedriver_mac64/chromedriver");

		
		
		
		
        WebDriver driver = new ChromeDriver();
        
        //Opening google url
        
        driver.get("https://www.coowncart.com/");

      Thread.sleep(6000);
    
    


   // driver.findElement(By.className("close-icon")).click();
    
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div/div[2]/div/div[3]/div[2]/a/div")).click();
    Thread.sleep(5000);

    driver.findElement(By.xpath("//*[@id=\"panel:r0:0\"]/div/form/div[1]/div/input")).sendKeys("syed@cocarting.com");
    driver.findElement(By.xpath("//*[@id=\"panel:r0:0\"]/div/form/div[2]/div/input")).sendKeys("123456A");
    
    
    driver.findElement(By.xpath("//*[@id=\"panel:r0:0\"]/div/form/div[4]/button")).click();
    
    Thread.sleep(10000);
    
// rejecting the notification alert
    
    driver.findElement(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")).click();
    
    

    
    // Go to the HomePage 
    
    driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div/div[2]/div/div[1]/a")).click();
    
    Thread.sleep(10000);

    // Go  to create a dummy CoCart
    
    driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/div[2]/div[1]/div[1]/div[2]/a[1]/span[1]/img")).click();
    
    //getting the title 
    
       System.out.println(driver.getTitle()) ;
       System.out.println(driver.getCurrentUrl());
       System.out.println("Test has been passed");
       
       Thread.sleep(5000);

       
       driver.close();
       
       
	}

}
