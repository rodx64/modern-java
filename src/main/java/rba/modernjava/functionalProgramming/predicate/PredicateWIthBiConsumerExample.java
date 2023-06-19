package rba.modernjava.functionalProgramming.predicate;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.List;
import java.util.function.*;

public class PredicateWIthBiConsumerExample {

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        Predicate<Instructor> predicateIsOnlineCourse = instructor -> instructor.isOnlineCourse() == true;

        Predicate<Instructor> predicateHas10YearsOfExperience = instructor -> instructor.getYearsOfExp() >= 10;

        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("My name is " + name + " and my courses are " + courses);

        instructors.forEach(instructor -> {
            if(predicateIsOnlineCourse.and(predicateHas10YearsOfExperience).test(instructor))
                biConsumer.accept(instructor.getName(), instructor.getCourses());

        });
    }


}
