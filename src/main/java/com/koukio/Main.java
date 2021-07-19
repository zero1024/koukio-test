package com.koukio;

import java.util.List;

public class Main {

    public static void execute(String input) {
        List<String> events = input.lines().toList();
        var students = Priorities.getStudents(events);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            students.forEach(s -> System.out.println(s.getName()));
        }
    }

}
