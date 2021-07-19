package com.koukio;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrioritiesTest {

    @Test
    void simpleTest() {
        assertEquals(null, Priorities.getStudents(Collections.emptyList()));
    }
}
