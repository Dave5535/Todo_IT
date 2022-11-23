package se.Lexicon;

import Model.ToDoItem;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class ToDoItemTest {

    @Test
    public void test_isOverdue_When_Task_IS_Overdue(){

        LocalDate deadLine = LocalDate.parse("2022-11-03");
        ToDoItem test = new ToDoItem("test", "Test",deadLine);
        boolean actual = test.isOverdue();
        boolean expected = false;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test_isOverdue_When_Task_Not_IS_Overdue(){

        LocalDate deadLine = LocalDate.parse("2022-12-03");
        ToDoItem test = new ToDoItem("test", "Test",deadLine);
        boolean actual = test.isOverdue();
        boolean expected = true;
        assertEquals(expected,actual);
    }



}
