package Model;

import static org.junit.jupiter.api.Assertions.*;

import Model.AppRole;
import Model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;

public class AppUserTest {

    private AppUser testObject;

    @BeforeEach
    public void setUp() {
        testObject = new AppUser("test", "test56789");
    }

    @Test
    public void Test_Set_Get_UserName() {
        assertNull(testObject.getId());
        assertEquals("test", testObject.getUserName());
/*assertEquals(AppRole.ROLE_APP_USER,testObject.getRole());
        Expected :ROLE_APP_USER
        Actual   :[ROLE_APP_USER] */
        testObject.removeRole(AppRole.ROLE_APP_USER);
      /*  assertEquals(AppRole.ROLE_APP_USER,testObject.getRole());
        Expected :ROLE_APP_USER
        Actual   :[] */

    }

}
