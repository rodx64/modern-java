package rba.modernjava.functionalProgramming.consumers;

import java.util.Arrays;
import java.util.List;


public class Instructors {

    public static List<Instructor> getAll(){
        return Arrays.asList(
                new Instructor("Jack", 11, "Software Developer", "male", true, Arrays.asList("Java Programming", "Spring Boot Advanced")),
                new Instructor("Hanna", 3, "Software Developer", "female", true, Arrays.asList("Ruby")),
                new Instructor("Kate", 6 , "Tester", "female", true, Arrays.asList("Java for testers", "Cocumber")));
    }

}
