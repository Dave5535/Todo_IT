package SequencersPackTest;

import Model.AppUser;
import org.example.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonIdSequencerTest {



    @Test
    public void test_If_Next_Id_Is_Plus_one(){
        Person test1 = new Person("test1", "test2","test1@test1");
        Person test2 = new Person("test2", "test2","test2@test2");
        String actual1 = String.valueOf(test1.getId());
        String expected1 = "1";
String actual2 = String.valueOf(test2.getId());
String expected2 = "2";
                Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}
