package dao;

import static org.junit.jupiter.api.Assertions.*;

import Model.AppRole;
import Model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
public class AppUserDAOCollectionTest {
    private AppUser testObject;
    @BeforeEach
    public void setUp(){
        testObject = new AppUser(1,"test","password", AppRole.ROLE_APP_USER);
    }
    @Test
    public void testObject_Test_If_Added(){
        assertEquals(1,testObject.getId());
        assertEquals("test",testObject.getUserName());
        assertEquals("password", testObject.getPassword());
       // assertEquals(AppRole.ROLE_APP_USER,testObject.getRole());  ( Expected :ROLE_APP_USER :: Actual   :[ROLE_APP_USER] )
    }
    @Test
    public void testObject_If_value_is_null(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                AppUser test = new AppUser(1, null, "password", AppRole.ROLE_APP_USER);
            }
        });
    }

}
