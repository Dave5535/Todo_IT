package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ToDoItemTest {

    @Before


    @Test
    public void test_isOverdue(){
        LocalDate tookTask = LocalDate.parse("2022-11-04");
        LocalDate deadLine = LocalDate.parse("2022-11-03");
        LocalDate nowTime = LocalDate.now();
        ToDoItem test = new ToDoItem("test", "Test");
        boolean actual = test.isOverdue();
        boolean expected = false;
        Assert.assertEquals(expected,actual);
    }



}
