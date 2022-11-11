package org.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class PersonTest {

    @BeforeAll



@Test
public void test_To_String_Get_info() {
   Person david = new Person("David","Svantesson","test@mail..");
String expected = "id: 1, Name: David Svantesson, email: test@mail..";
   String actual =  david.toString();

    Assert.assertEquals(expected, actual);

}//personInformation


}