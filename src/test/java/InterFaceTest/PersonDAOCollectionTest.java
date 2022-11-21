package InterFaceTest;


import static org.junit.jupiter.api.Assertions.*;


import org.example.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PersonDAOCollectionTest {
    private Person testObject;
    @BeforeEach
    public void setUp(){
        testObject = new Person("person","Person","Person@person");
    }
    @Test
    public void testObject_Test_If_Added(){
        assertEquals("person",testObject.getFirstName());
        assertEquals("Person", testObject.getLastName());
        assertEquals("Person@person",testObject.getEmail());
        assertEquals(1, testObject.getId());
    }
    @Test
    public void testObject_If_value_is_null(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Person test = new Person(null,"test","test" );
            }
        });
    }

}
