package Model;

import org.junit.Assert;
import org.junit.Test;

public class AppUserTest {


    @Test
    public void Test_Set_Get_UserName(){
        AppUser test = new AppUser("testfirstname","testlastname",AppRole.ROLE_APP_USER);
String expected = "User name : testfirstname";

String actual = test.toString();
        Assert.assertEquals(expected,actual);
    }
}
