package tests;

import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

    @BeforeMethod

    public void preCondition(){
if(app.getHelperUser().isSignOutPresent()){
    app.getHelperUser().logIn();
}
    }

    @Test

    public void addNewContactSuccess(){

        int index = (int)(System.currentTimeMillis())/1000%36000;

        Contact contact = Contact.builder()
                .name("Katrin")
                .lastName("Persov")
                .phoneNumber("054-852-63" + "-" + index)
                .email("katrin2525@gmail.com")
                .address("Yaffo")
                .description("colleague").build();

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().submit();
    }
}
