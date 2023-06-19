package rba.modernjava.functionalProgramming.predicate;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateExample {

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

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
