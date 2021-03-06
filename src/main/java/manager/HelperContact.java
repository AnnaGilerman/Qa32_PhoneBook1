package manager;


import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        pause(500);
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhoneNumber());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void submit() {
        click(By.cssSelector("b"));
       // click(By.xpath("(//b[normalize-space()='Save'])[1]"));
    }

    public boolean isContactByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el: list) {
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isContactByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el: list) {
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }

    public void openContacts() {
        click(By.cssSelector("[href='/contacts']"));
    }

    public void chooseContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
    }

    public void removeContact() {
        click(By.xpath("//button[normalize-space()='Remove']"));
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();

        if (!isCountListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(5000);
        }

        int countAfter = countOfContacts();


        return countBefore-countAfter;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
       while( wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0) {
           click(By.cssSelector(".contact-item_card__2SOIM"));
           click(By.xpath("//button[text()='Remove']"));
           pause(5000);
       }
    }

    public void provideContactData() {
        //add contact (3-4)
    }

//    public boolean contactExists() {
//
//    }
}
