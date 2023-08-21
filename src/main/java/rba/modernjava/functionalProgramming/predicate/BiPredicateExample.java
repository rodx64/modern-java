package rba.modernjava.functionalProgramming.predicate;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.InstructorsMock;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BiPredicateExample {

    public static void main(String[] args) {
        simpleTests();
        validatingInstructors();
    }

    private static void simpleTests(){
        BiPredicate<Boolean, Integer> hasNecessaryLevel =
                (working, timeOsExperience) -> !working && timeOsExperience >=5;

        System.out.println(hasNecessaryLevel.test(true, 5));
        System.out.println(hasNecessaryLevel.test(false, 4));
        System.out.println(hasNecessaryLevel.test(false, 6));
    }

    private static void validatingInstructors() {
        List<Instructor> instructors = InstructorsMock.getAll();

        BiPredicate<Boolean, Integer> predicateIsOnlineCourseAndHas10YearsOfExperience =
                (online, experience) -> online == true && experience >= 10;

        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("My name is " + name + " and my courses are " + courses);

        instructors.forEach(instructor -> {
            if(predicateIsOnlineCourseAndHas10YearsOfExperience.test(instructor.isOnlineCourse(), instructor.getYearsOfExp()))
                biConsumer.accept(instructor.getName(), instructor.getCourses());

        });
    }


}
