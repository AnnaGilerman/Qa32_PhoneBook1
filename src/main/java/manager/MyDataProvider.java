package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginData(){

        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{"anna789@gmail.com", "Aanna12345$$"});
        list.add(new Object[]{"anna789@gmail.com", "Aanna12345$$"});
        list.add(new Object[]{"anna789@gmail.com", "Aanna12345$$"});
        list.add(new Object[]{"anna789@gmail.com", "Aanna12345$$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validModelLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$")});
        list.add(new Object[]{new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$")});
        list.add(new Object[]{new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$")});
        list.add(new Object[]{new User().withEmail("anna789@gmail.com").withPassword("Aanna12345$$")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validModelCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/loginValid.csv")));
        String line = reader.readLine(); //anna789@gmail.com,Aanna12345$$

        while (line != null){
            String [] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validDataContact() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null){
            String [] split = line.split(";");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                  //  .phoneNumber(split[2])
                  //  .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
