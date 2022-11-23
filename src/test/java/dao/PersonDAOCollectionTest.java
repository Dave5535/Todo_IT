package dao;


import static org.junit.jupiter.api.Assertions.*;


import Model.AppUser;
import Model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PersonDAOCollectionTest {
    private Person testObject;
    private AppUser objectTest;
    @BeforeEach
    public void setUp(){
        objectTest = new AppUser("username","password");
        testObject = new Person("person","Person","Person@person",objectTest);
    }
    @Test
    public void testObject_Test_If_Added(){
        assertEquals("person",testObject.getFirstName());
        assertEquals("Person", testObject.getLastName());
        assertEquals("Person@person",testObject.getEmail());
        assertEquals(0, testObject.getId()); //default id is 0
    }
    @Test
    public void testObject_If_value_is_null(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Person test = new Person(null,"test","test",null );
            }
        });
    }

}
