package tests;


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
        System.out.println(index);

        //open regform
        app.getHelperUser().openLoginRegistrationForm();
        //fill email
        //fill password
        app.getHelperUser().fillLoginRegistrationForm("alex" + index +"@gmail.com", "Aalex12345$$");
        //click registration
        app.getHelperUser().submitRegistration();

        //Assert
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
}
