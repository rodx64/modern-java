package rba.modernjava.functionalProgramming.function;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class BiFunctionExample {

    public static void main(String[] args) {
        Function<List<Instructor>, Map<String, Integer>> mapFunction = (instructors) -> {
            Map<String, Integer> map = new HashMap<>();
            instructors.forEach(instructor -> {
                map.put(instructor.getName(), instructor.getYearsOfExp());
            });
            return map;
        };

        System.out.println(mapFunction.apply(Instructors.getAll()));

    }



}
