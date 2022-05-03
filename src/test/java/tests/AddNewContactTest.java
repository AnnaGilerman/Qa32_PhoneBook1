package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

    @BeforeMethod(alwaysRun = true)

    public void preCondition(){
      if(!app.getHelperUser().isSignOutPresent()){
    app.getHelperUser().logIn(new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$"));
}
    }

    @Test(groups = {"web"})

    public void addNewContactSuccess(){

        int index = (int)(System.currentTimeMillis())/1000%36000;

        Contact contact = Contact.builder()
                .name("Katrin"+ index)
                .lastName("Persov")
                .phoneNumber("054-852-3" + "-" + index)
                .email("katrin25" + index + "@gmail.com")
                .address("Yaffo")
                .description("colleague").build();

        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().submit();

        Assert.assertTrue(app.contact().isContactByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactByPhone(contact.getPhoneNumber()));
    }

    @Test(dataProvider = "validDataContact", dataProviderClass = MyDataProvider.class, groups = {"web"}, enabled = false)

    public void addNewContactSuccessDataProviderCSV(Contact contact){

        int index = (int)(System.currentTimeMillis())/1000%36000;

        contact.setEmail("katrin25" + index + "@gmail.com");
        contact.setPhoneNumber("054-852-3" + "-" + index);


        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().submit();

        Assert.assertTrue(app.contact().isContactByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactByPhone(contact.getPhoneNumber()));
    }
}
