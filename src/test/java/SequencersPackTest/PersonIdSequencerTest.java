package SequencersPackTest;

import Model.AppUser;
import Model.Person;
import controller.Controller;
import org.junit.Assert;
import org.junit.Test;

public class PersonIdSequencerTest {
private AppUser appUser;


    @Test
    public void test_If_Next_Id_Is_Plus_one(){
        appUser = new AppUser("user","password");
        Person test1 = new Person("test1", "test2","test1@test1",appUser);
        Person test2 = new Person("test2", "test2","test2@test2",appUser);


        String actual1 = String.valueOf(test1.getId());
        String expected1 = "0";
String actual2 = String.valueOf(test2.getId());
String expected2 = "0";
                Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}
