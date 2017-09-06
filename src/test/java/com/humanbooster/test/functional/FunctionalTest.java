package com.humanbooster.test.functional;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FunctionalTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        String os = System.getProperty("os.name")
                .toLowerCase()
                .split(" ")[0];
        String pathDriver = Paths.get(".").toAbsolutePath().normalize().toString()+"/LIB/chromedriver-"+os;
        System.setProperty("webdriver.chrome.driver", pathDriver);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void addRemoveTask() {
        driver.get("http://localhost:8081/");
        System.out.println(driver.getPageSource());
        driver.findElement(By.id("taskTitle")).sendKeys("my task name");
        driver.findElement(By.id("taskDue")).sendKeys("22-07-2020");
        driver.findElement(By.id("submit")).click();

        WebElement firstTask = driver.findElement(By.id("task_0"));
        assertEquals("my task name X", firstTask.getText());
        List<WebElement> links = firstTask.findElements(By.tagName("a"));
        links.get(1).click();

        try{
            WebElement none = driver.findElement(By.id("task_0"));
            fail("task_0 should not be available ( should have fail to find task_0)");
        } catch (Exception e){
            assertTrue(true); // optional
        }
    }

}