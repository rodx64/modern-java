package rba.modernjava.functionalProgramming.predicate;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        predicateTest();
        predicateValidations();
    }

    private static void predicateTest() {
        // Return true if i >= 10
        System.out.println("Return true if i >= 10");
        Predicate<Integer> predicate1 = (i) -> i >= 10;
        System.out.println(predicate1.test(11));

        // Return true if i >= 10 && i is even
        System.out.println("Return true if i >= 10 && i is even");
        Predicate<Integer> predicate2 = (i) -> i >= 10 && (i % 2 == 0);
        System.out.println(predicate2.test(10));
        System.out.println(predicate2.test(11));

        // Return true if i >= 10 || i is even
        System.out.println("Return true if i >= 10 || i is even");
        Predicate<Integer> predicate3 = (i) -> i >= 10 || (i % 2 == 0);
        System.out.println(predicate3.test(8));
        System.out.println(predicate3.test(9));
        System.out.println(predicate3.test(10));
        System.out.println(predicate3.test(11));
    }

    private static void predicateValidations() {
        Predicate<Instructor> predicateInstructorIsOnLine = (instructor) -> instructor.isOnlineCourse();
        Predicate<Instructor> predicateInstructorIsMale = (instructor) -> instructor.getGender().toLowerCase().equals("male");

        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor ->{
            if(predicateInstructorIsOnLine.test(instructor) && predicateInstructorIsMale.test(instructor)){
                System.out.println(instructor);
            }
        });
    }
}
