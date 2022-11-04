package org.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class PersonTest {

    @BeforeAll



@Test
public void test_personInformation() {
   Person david = new Person("David","Svantesson","test@mail..");
String expected = "id: 0, Name: David Svantesson, email: test@mail..";
   String actual =  david.getSummary();

    Assert.assertEquals(expected, actual);

}//personInformation


}