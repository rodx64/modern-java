package rba.modernjava.functionalProgramming.consumers;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExampleInstructors {

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        // Loop through the instructors and printing entire object
        Consumer<Instructor> consumerObject = (instructor) -> System.out.println(instructor);
        instructors.forEach(consumerObject);
        System.out.println();

        // Loop through the instructors and printing only the name
        Consumer<Instructor> consumerName = instructor -> System.out.println(instructor.getName());
        instructors.forEach(consumerName);
        System.out.println();

        // Loop through the instructors and printing the name and their courses
        Consumer<Instructor> consumerCourses = instructor -> System.out.println(instructor.getCourses());
        instructors.forEach(consumerName.andThen(consumerCourses));
        System.out.println();

        // Loop through the instructors and printing the name if experience >= 10 years
        instructors.forEach((instructor) -> {
            if (instructor.getYearsOfExp() >= 10) {
                consumerName.accept(instructor);
            }
        });
        System.out.println();

        // Loop through the instructors and printing the name and years of exp if exp >= 5 and course is online
        instructors.forEach((instructor) -> {
            if (instructor.getYearsOfExp() >= 5 && instructor.isOnlineCourse()) {
                consumerName.andThen(consumerCourses).accept(instructor);            }
        });
    }

}
