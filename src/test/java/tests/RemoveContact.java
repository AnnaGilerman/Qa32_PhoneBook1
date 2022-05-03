package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(!app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().logIn(new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$"));
        }
        app.contact().provideContactData();
    }

    @Test
    public void removeOneContact(){
        app.contact().openContacts();
        logger.info("Contacts are opened");
        app.contact().chooseContact();
        logger.info("Contact is chosen");
        app.contact().removeContact();
        logger.info("Contact is removed");

    }

    @Test(groups = {"web"}, priority = 1)
    public void removeOneContact1(){
        Assert.assertEquals(app.contact().removeOneContact(), 1);
    }

    @Test(priority = 2)
    public void removeAllContacts(){

        app.contact().removeAllContacts();
        //Assert
    }

}
