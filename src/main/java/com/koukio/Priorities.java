package com.koukio;

import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Priorities {

    public static List<Student> getStudents(List<String> events) {

        int numberOfEvents = Integer.parseInt(events.get(0));
        var queue = new PriorityQueue<Student>(numberOfEvents);

        events.stream().skip(1).forEach(event -> {
            if (event.startsWith("ENTER")) {
                String[] s = event.split(Pattern.quote(" "));
                var student = new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]));
                queue.add(student);
                System.out.println("Add:" + student.getName());
            } else {
                var s = queue.poll();
                System.out.println("Poll:" + s.getName());
            }
        });
        
        return Stream.generate(queue::poll)
                .takeWhile(Objects::nonNull)
                .toList();
    }

}
