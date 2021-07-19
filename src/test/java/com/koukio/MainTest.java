package com.koukio;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testEmpty() {
        var input = """
                4
                ENTER John 3.75 50
                SERVED
                SERVED
                SERVED
                """;
        Main.execute(input);
    }

    @Test
    void testSimple() {
        var input = """
                12
                ENTER John 3.75 50
                ENTER Mark 3.8 24
                ENTER Shafaet 3.7 35
                SERVED
                SERVED
                ENTER Samiha 3.85 36
                SERVED
                ENTER Ashley 3.9 42
                ENTER Maria 3.6 46
                ENTER Anik 3.95 49
                ENTER Dan 3.95 50
                SERVED
                """;
        Main.execute(input);
    }


}
