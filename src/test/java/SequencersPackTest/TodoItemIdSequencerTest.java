package SequencersPackTest;

import Model.ToDoItem;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TodoItemIdSequencerTest {


    @Test
    public void test_If_Next_Id_Is_Plus_one(){

        ToDoItem item1 = new ToDoItem("test1", "test1", LocalDate.parse("2022-11-15"));
        ToDoItem item2 = new ToDoItem("test2", "test2", LocalDate.parse("2022-12-18"));

        String actual1 = String.valueOf(item1.getId());
        String expected1 = "1";
        String actual2 = String.valueOf(item2.getId());
        String expected2 = "2";
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}

