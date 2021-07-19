package com.koukio;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrioritiesTest {

    @Test
    void testSimple() {

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

    @Test
    void testServedMoreThanEnter() {

        var list = Arrays.asList(
                "7",
                "ENTER John 3.75 50",
                "SERVED",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "SERVED"
        );

        List<String> res = Priorities.getStudents(list).stream().map(Student::getName).toList();

        assertEquals(emptyList(), res);
    }

    @Test
    void testSameCGPA() {

        var list = Arrays.asList(
                "2",
                "ENTER Mark 3.75 24",
                "ENTER John 3.75 50"
        );

        List<String> res = Priorities.getStudents(list).stream().map(Student::getName).toList();
        List<String> expectedRes = Arrays.asList("John", "Mark");

        assertEquals(expectedRes, res);
    }

    @Test
    void testSameCGPAAndName() {

        var list = Arrays.asList(
                "2",
                "ENTER John 3.75 50",
                "ENTER John 3.75 24"
        );

        List<Integer> res = Priorities.getStudents(list).stream().map(Student::getID).toList();
        List<Integer> expectedRes = Arrays.asList(24, 50);

        assertEquals(expectedRes, res);
    }

    @Test
    void testNull() {
        assertEquals(emptyList(), Priorities.getStudents(null));
    }

    @Test
    void testEmpty() {
        assertEquals(emptyList(), Priorities.getStudents(emptyList()));
    }

    @Test
    void testFirstLine() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Priorities.getStudents(singletonList("something"))
        );
    }

    @Test
    void testUnknownEvent() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Priorities.getStudents(Arrays.asList("1", "something"))
        );
    }

    @Test
    void testUnparsablePayload() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Priorities.getStudents(Arrays.asList("1", "ENTER something"))
        );
    }

}
