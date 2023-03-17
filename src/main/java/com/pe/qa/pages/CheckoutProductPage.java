package com.pe.qa.pages;

import com.pe.qa.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutProductPage extends BasePage {

    @FindBy(className = "shopping_cart_link")
    private WebElement seleccionarCart;
    @FindBy(id="checkout")
    private WebElement seleccionbotonCheckout;

    @FindBy(id="first-name")
    private WebElement nombretxt;
    @FindBy(id="last-name")
    private WebElement apellidotxt;
    @FindBy(id="postal-code")
    private WebElement postaltxt;
    @FindBy(id="continue")
    private WebElement btncontinuar;

    public CheckoutProductPage(){
        PageFactory.initElements(driver,this);
    }

    public void seleccionCarro(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",seleccionarCart);

    }
    public void selecheckout(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",seleccionbotonCheckout);

    }
    public void enviardatos(String nombre,String apellido,String postal){
        nombretxt.sendKeys(nombre);
        apellidotxt.sendKeys(apellido);
        postaltxt.sendKeys(postal);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",btncontinuar );

    }

}
