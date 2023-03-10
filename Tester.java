import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tester {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:/Users/johns/Desktop/Java/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://ec2-3-133-102-148us-east-2computeamazonaws.com:3000/");
        System.out.println("Im waiting for 3 seconds");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.xpath("//*[@id='root']/center/button"));
        button.click();
        System.out.println("Im waiting for 5 seconds");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement firstNameField = driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]"));
        firstNameField.sendKeys("johnson.j@archimedis.io");
        WebElement next = driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[4]/div/div/div/div/input"));
        next.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement password = driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input"));
        password.sendKeys("prkstr@9112");
        WebElement submit = driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div/input"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement leave = driver.findElement(By.xpath("/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[1]/input"));
        leave.click();
    }
}