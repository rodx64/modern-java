package rba.modernjava.functionalProgramming.consumers;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.Instructors;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExampleInstructors {

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();

        // Print out name and gender
        BiConsumer<String, String> biConsumerNameAndGender = (name, gender) ->
                System.out.println("My name is " + name + " and my gender is " + gender);

        instructors.forEach(instructor -> biConsumerNameAndGender.accept(instructor.getName(), instructor.getGender()));


        // Print out name and list of courses
        BiConsumer<String, List<String>> biConsumerNameAndCourses = (name, courses) ->
                System.out.println("My name is " + name + " and my courses are " + courses);

        instructors.forEach(instructor ->
                biConsumerNameAndCourses.accept(instructor.getName(), instructor.getCourses()));
    }

}
