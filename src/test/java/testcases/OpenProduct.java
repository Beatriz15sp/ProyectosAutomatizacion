package testcases;

import com.pe.qa.base.BasePage;
import com.pe.qa.pages.AgregarProductPage;
import com.pe.qa.pages.CheckoutProductPage;
import com.pe.qa.pages.FinalizaCompraPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pe.qa.pages.LoginPage;

public class OpenProduct extends BasePage {


    LoginPage loginPage;
    AgregarProductPage agregarProduct;
    CheckoutProductPage checkoutProduct;
    FinalizaCompraPage finalizaCompraPage;

    public OpenProduct() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        inicializacion();
        loginPage = new LoginPage();
        agregarProduct = new AgregarProductPage();
        checkoutProduct = new CheckoutProductPage();
        finalizaCompraPage = new FinalizaCompraPage();

    }

    @Test
    public void Login() {
        loginPage.enviarCredeciales("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.CargaCajaTexto());
        String valor = loginPage.obtenervalorhome();

        if (valor.equals("Products")) {
            boolean nombreProducto = agregarProduct.validarnombreProduct("Sauce Labs Backpack");
            Assert.assertTrue(nombreProducto);
            boolean precioProducto = agregarProduct.validarprecioProduct("29.99");
            Assert.assertTrue(precioProducto);
            agregarProduct.botonProduct();
            checkoutProduct.seleccionCarro();
            Assert.assertTrue(nombreProducto);
            Assert.assertTrue(precioProducto);
            checkoutProduct.selecheckout();
            checkoutProduct.enviardatos(pro.getProperty("lastname"), pro.getProperty("firstname"), pro.getProperty("postal"));
            Assert.assertTrue(nombreProducto);
            Assert.assertTrue(precioProducto);
            finalizaCompraPage.finalizarCompra();
            String mensaje = finalizaCompraPage.mensajeok();
            if (mensaje.equals("Thank you for your order!")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } else {
            Assert.assertTrue(false);
        }


    }


    @AfterMethod
    public void close() {
        driver.close();
    }
}





