package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @BeforeMethod

    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }

//    @Test
//   public void loginSuccess(){
//
//        //open Login form
//        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
//        loginItem.click();
//        //fill email
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("anna789@gmail.com");
//
//        //fill password
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Aanna12345$$");
//        //click button Login
//        wd.findElement(By.xpath("//*[text()=' Login']")).click();
//        //Assert
//        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size()>0);
//
//
//    }
    @Test

    public void loginSuccessNew(){
        //open Login form
        User user = new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$");
        app.getHelperUser().openLoginRegistrationForm();

        //fill email and password
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(1000);
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test

    public void loginSuccess(){
        //open Login form
        User user = new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$");
        app.getHelperUser().openLoginRegistrationForm();

        //fill email and password
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(1000);
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }

    @Test

    public void loginNegativeWrongPassword(){
        User user = new User().withEmail("anna789@gmail.com").withPassword("Aanna");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLoginRegistrationSuccess());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());


    }
//    @AfterMethod
//
//    public void postCondition(){
//        app.getHelperUser().submitOkButto();
//    }
}
