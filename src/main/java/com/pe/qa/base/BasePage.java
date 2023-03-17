package com.pe.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public static WebDriverWait wait;
    public static WebDriver driver;
    public static Properties pro;

    public BasePage() {
        try{
            pro=new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/pe/qa/config/config.properties");
            pro.load(ip);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inicializacion() {
        String browserName = pro.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        }
        driver.manage().window().maximize();
        driver.get(pro.getProperty("url"));
    }


}
