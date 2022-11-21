import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class automationLT {

    @Test
    public void leanTechTest() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        ChromeDriver lt = new ChromeDriver();


        lt.get("https://www.saucedemo.com/");
        lt.manage().window().maximize();
        //Login
        lt.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
        lt.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        lt.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        //choose the product
        lt.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        String NameofItem = lt.findElement(By.linkText("Sauce Labs Fleece Jacket")).getText();
        //view cart
        lt.findElement(By.className("shopping_cart_link")).click();
        Assert.assertEquals(lt.findElement(By.linkText("Sauce Labs Fleece Jacket")).getText(), NameofItem);
        lt.findElement(By.id("checkout")).click();
        //checkout information
        lt.findElement(By.id("first-name")).sendKeys("Test");
        lt.findElement(By.id("last-name")).sendKeys("LeanTech");
        lt.findElement(By.id("postal-code")).sendKeys("0123456");
        lt.findElement(By.id("continue")).click();
        Assert.assertEquals(lt.findElement(By.linkText("Sauce Labs Fleece Jacket")).getText(), NameofItem);
        //checkout complete
        lt.findElement(By.id("finish")).click();
        Assert.assertEquals(lt.findElement(By.className("title")).getText(), "CHECKOUT: COMPLETE!");

    }
}
