package com.koukio;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrioritiesTest {

    @Test
    void simpleTest() {

        var list = Arrays.asList(
                "12",
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50 ",
                "SERVED"
        );

        List<String> res = Priorities.getStudents(list).stream().map(Student::getName).toList();
        List<String> expectedRes = Arrays.asList("Dan", "Ashley", "Shafaet", "Maria");

        assertEquals(expectedRes, res);
    }
}
