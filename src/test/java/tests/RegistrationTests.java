package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod

    public void preCondition(){

        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }

    }
    @Test
    public void registrationSuccess(){

        int index = (int)System.currentTimeMillis()/1000%3600;

        logger.info("alex"+index+"@gmail.com");
        logger.info("The index is ----> " + index);
        System.out.println(index);

        User user = new User().withEmail("alex" + index +"@gmail.com").withPassword("Aalex12345$$");

        //open regform
        app.getHelperUser().openLoginRegistrationForm();
        //fill email
        //fill password
        app.getHelperUser().fillLoginRegistrationForm(user);
        //click registration
        app.getHelperUser().submitRegistration();

        //Assert
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
}
