package rba.modernjava.functionalProgramming.predicate;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.InstructorsMock;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        predicateTest();
        predicateValidations();
    }

    private static void predicateTest() {
        Predicate<Integer> biggerThanOrEqualtoTen = (i) -> i >= 10;
        System.out.println(biggerThanOrEqualtoTen.test(11));

        Predicate<Integer> biggerThanOrEqualtoTenAndOdd = (i) -> i >= 10 && (i % 2 == 0);
        System.out.println(biggerThanOrEqualtoTenAndOdd.test(10));
        System.out.println(biggerThanOrEqualtoTenAndOdd.test(11));

        Predicate<Integer> biggerThanOrEqualtoTenOrOdd = (i) -> i >= 10 || (i % 2 == 0);
        System.out.println(biggerThanOrEqualtoTenOrOdd.test(8));
        System.out.println(biggerThanOrEqualtoTenOrOdd.test(9));
        System.out.println(biggerThanOrEqualtoTenOrOdd.test(10));
        System.out.println(biggerThanOrEqualtoTenOrOdd.test(11));
    }

    private static void predicateValidations() {
        Predicate<Instructor> predicateInstructorIsOnLine = (instructor) -> instructor.isOnlineCourse();
        Predicate<Instructor> predicateInstructorIsMale = (instructor) -> instructor.getGender().toLowerCase().equals("male");

        List<Instructor> instructors = InstructorsMock.getAll();
        instructors.forEach(instructor ->{
            if(predicateInstructorIsOnLine.test(instructor) && predicateInstructorIsMale.test(instructor)){
                System.out.println(instructor);
            }
        });
    }
}
