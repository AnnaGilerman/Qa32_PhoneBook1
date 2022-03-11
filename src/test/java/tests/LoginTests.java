package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase
{

    @Test
    public void loginSuccess(){

        //open Login form
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
        loginItem.click();
        //fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("anna789@gmail.com");

        //fill password
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Aanna12345$$");
        //click button Login
        wd.findElement(By.xpath("//*[text()=' Login']")).click();
        //Assert
        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size()>0);


    }
    @Test

    public void loginSuccessNew(){
        //open Login form
        click(By.cssSelector("[href='/login']"));
        //fill email
        type(By.xpath("//input[1]"),"anna789@gmail.com" );
        //fill password
        type(By.xpath("//input[2]"),"Aanna12345$$");
        //click button Login
        click(By.xpath("//*[text()=' Login']"));


        //Assert
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

}
