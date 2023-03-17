package com.pe.qa.pages;

import com.pe.qa.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class AgregarProductPage extends BasePage {
 @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
  private WebElement etiquetaProduct;
 @FindBy(xpath = "//div[text()='29.99']")
 private WebElement precioProduct;
 @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
 private WebElement botonAgregar;

 public boolean validarnombreProduct(String nombreprod) {

     return etiquetaProduct.getText().contains(nombreprod);
 }
    public boolean validarprecioProduct(String precio){
         return precioProduct.getText().contains(precio);
     }
    public AgregarProductPage(){
        PageFactory.initElements(driver,this);
    }

 public void botonProduct(){

     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].click();",botonAgregar);

 }

}
