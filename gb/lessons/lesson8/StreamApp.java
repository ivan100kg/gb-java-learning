package lessons.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApp {
    static class Person {
        enum Position {
            ENGINEER, DIRECTOR, MANAGER;
        }

        private String name;
        private int age;
        private Position position;

        public Person(String name, int age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }
    }

    private static void streamSimpleTask() {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, Person.Position.MANAGER),
                new Person("Bob2", 44, Person.Position.DIRECTOR),
                new Person("Bob3", 25, Person.Position.ENGINEER),
                new Person("Bob4", 42, Person.Position.ENGINEER),
                new Person("Bob5", 55, Person.Position.MANAGER),
                new Person("Bob6", 19, Person.Position.MANAGER),
                new Person("Bob7", 33, Person.Position.ENGINEER),
                new Person("Bob8", 37, Person.Position.MANAGER)
        ));
        List<String> engineersNames = persons.stream()
                .filter(person -> person.position == Person.Position.ENGINEER)
                .sorted((o1, o2) -> o1.age - o2.age)
                .map(person -> person.name)
                .collect(Collectors.toList());
        System.out.println(engineersNames);
    }

    public static void main(String[] args) {
        streamSimpleTask();

        List<Integer> list = new ArrayList<>(Arrays.asList(9, 2, 3, 4, 5, 0, 1, 2, 3, 9));
        int max = list.stream()
//                .peek(integer -> System.out.print(integer + " "))
                .filter(integer -> integer > 1)
//                .peek(integer -> System.out.print(integer + " "))
                .distinct()
//                .peek(integer -> System.out.print(integer + " "))
                .sorted()
//                .peek(integer -> System.out.print(integer + " "))
                .mapToInt(integer -> integer * integer)
                .peek(integer -> System.out.print(integer + " "))
                .max().orElse(0);
        System.out.println("\nmax = " + max);

        boolean allMatch = list.stream().allMatch(integer -> integer>81);
        boolean anyMatch = list.stream().anyMatch(integer -> integer>81);
        boolean noneMatch = list.stream().noneMatch(integer -> integer>81);
        System.out.println(allMatch + " " + anyMatch + " " + noneMatch);

    }
}