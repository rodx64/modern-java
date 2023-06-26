package rba.modernjava.functionalProgramming.function;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class BiFunctionExample {

    public static void main(String[] args) {
        System.out.println("Function with Hashmap: ");
        functionTestOne();

        System.out.println("\nBiFunction with Predicate");
        functionTestWithBiFunction();
    }

    private static void functionTestOne() {
        Function<List<Instructor>, Map<String, Integer>> mapFunction = (instructors) -> {
            Map<String, Integer> map = new HashMap<>();
            instructors.forEach(instructor -> {
                map.put(instructor.getName(), instructor.getYearsOfExp());
            });
            return map;
        };

        System.out.println(mapFunction.apply(Instructors.getAll()));
    }

    private static void functionTestWithBiFunction() {
        Predicate<Instructor> instructorPredicate = p -> p.isOnlineCourse() == true;

        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> mapBiFunction =
            (instructors, predicate) -> {
                Map<String, Integer> map = new HashMap<>();

                instructors.forEach(instructor -> {
                    if(instructorPredicate.test(instructor)){
                        map.put(instructor.getName(), instructor.getYearsOfExp());
                    }
                });

            return map;
        };

        System.out.println(mapBiFunction.apply(Instructors.getAll(), instructorPredicate));
    }


}
