package se.Lexicon;
import Model.AppUser;
import Model.Person;
import org.junit.Assert;

import org.junit.Test;


public class PersonTest {
private AppUser appUser;

@Test
public void test_To_String_Get_info() {
    appUser = new AppUser("user","password1");
   Person david = new Person("David","Svantesson","test@mail..",appUser);
String expected = "id: 1, Name: David Svantesson, email: test@mail..";
   String actual =  david.toString();

    Assert.assertEquals(expected, actual);

}//personInformation


}