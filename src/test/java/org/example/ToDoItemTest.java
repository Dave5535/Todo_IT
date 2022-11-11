package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ToDoItemTest {

    @Before


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
        Assert.assertEquals(expected,actual);
    }



}
