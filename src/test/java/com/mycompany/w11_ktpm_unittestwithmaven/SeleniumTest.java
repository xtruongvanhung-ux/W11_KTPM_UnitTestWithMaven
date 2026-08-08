package com.mycompany.w11_ktpm_unittestwithmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
  
    @Feature("Login")
    @Description("Kiểm tra đăng nhập thành công vào SauceDemo")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void openChrome() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        //Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        //Thread.sleep(10000);
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        driver.manage().window().maximize();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}