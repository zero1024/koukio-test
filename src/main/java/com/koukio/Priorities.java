package com.koukio;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Priorities {

    public static List<Student> getStudents(List<String> events) {

        if (events == null || events.isEmpty()) {
            return Collections.emptyList();
        }

        int numberOfEvents = getNumberOfEvents(events);

        var queue = new PriorityQueue<Student>(numberOfEvents);

        events.stream()
                .skip(1)
                .map(String::trim)
                .map(Priorities::parseEvent)
                .forEach(event -> {
                    if (event instanceof Enter) {
                        var student = parseStudent(((Enter) event).payload);
                        queue.add(student);
                    } else {
                        queue.poll();
                    }
                });

        return Stream.generate(queue::poll)
                .takeWhile(Objects::nonNull)
                .toList();

    }

    private static int getNumberOfEvents(List<String> events) {
        try {
            return Integer.parseInt(events.get(0));
        } catch (Exception e) {
            throw new IllegalArgumentException("The first line must be an integer");
        }
    }

    private static Student parseStudent(String payload) {
        String[] s = payload.split(Pattern.quote(" "));

        if (s.length != 3) {
            throw new IllegalArgumentException("Unparsable payload: " + payload);
        }

        int id = Integer.parseInt(s[2]);
        String name = s[0];
        double cgpa = Double.parseDouble(s[1]);
        return new Student(id, name, cgpa);
    }

    private static Event parseEvent(String event) {
        if (event.startsWith("ENTER ")) {
            return new Enter(event.replaceFirst("ENTER ", ""));
        } else if (event.equals("SERVED")) {
            return Served.INSTANCE;
        } else {
            throw new IllegalArgumentException("Unknown event: " + event);
        }
    }


    private interface Event {
    }

    private static class Served implements Event {
        private final static Served INSTANCE = new Served();
    }

    private static class Enter implements Event {
        private final String payload;

        private Enter(String payload) {
            this.payload = payload;
        }
    }

}
