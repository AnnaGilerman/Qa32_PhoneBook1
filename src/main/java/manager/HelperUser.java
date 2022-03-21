package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }


    public void fillLoginRegistrationForm(String email, String password) {
        //fill email
        type(By.xpath("//input[1]"),email);
        //fill password
        type(By.xpath("//input[2]"),password);
    }

    public void submitLogin() {
        //click button Login
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegistrationSuccess() {
        //Assert
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));

    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void signOut() {
        click(By.xpath("//*[text()='Sign Out']"));
    }
}

