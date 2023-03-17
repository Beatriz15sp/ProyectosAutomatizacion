package com.pe.qa.pages;

import com.pe.qa.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.netty.NettyClient;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalizaCompraPage extends BasePage {
    @FindBy(id="finish")
    private WebElement btnfinish;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement mensajeoktxt;
    public FinalizaCompraPage(){
        PageFactory.initElements(driver,this);
    }
    public void finalizarCompra(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",btnfinish);

    }
    public String mensajeok(){
        return mensajeoktxt.getText();
    }
}
