package org.example;
import org.junit.Assert;

import org.junit.Test;


public class PersonTest {


@Test
public void test_To_String_Get_info() {
   Person david = new Person("David","Svantesson","test@mail..");
String expected = "id: 1, Name: David Svantesson, email: test@mail..";
   String actual =  david.toString();

    Assert.assertEquals(expected, actual);

}//personInformation


}