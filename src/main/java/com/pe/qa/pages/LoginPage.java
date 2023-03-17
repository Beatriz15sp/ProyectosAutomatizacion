package com.pe.qa.pages;

import com.pe.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }


   public void enviarCredeciales(String username,String password){
    driver.findElement(By.id("user-name")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.xpath("//input[@type='submit']")).click();

   }



   public String obtenervalorhome(){
       WebElement valor= driver.findElement(By.xpath("//span[contains(@class,'title')and contains(text(),'Products')]"));
               return valor.getText();
   }
    public boolean CargaCajaTexto(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add-to-cart-sauce-labs-backpack"))).isDisplayed();
    }



}
