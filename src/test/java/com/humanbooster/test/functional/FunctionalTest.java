package com.humanbooster.test.functional;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

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
    public void testMe(){
        driver.get("https://www.amazon.fr/");
        System.out.println(driver.getPageSource());
    }

}