package rba.modernjava.functionalProgramming.consumers;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.InstructorsMock;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExampleInstructors {

    public static void main(String[] args) {
        List<Instructor> instructors = InstructorsMock.getAll();

        BiConsumer<String, String> biConsumerNameAndGender = (name, gender) ->
                System.out.println("My name is " + name + " and my gender is " + gender);

        instructors.forEach(instructor -> biConsumerNameAndGender.accept(instructor.getName(), instructor.getGender()));


        BiConsumer<String, List<String>> biConsumerNameAndCourses = (name, courses) ->
                System.out.println("My name is " + name + " and my courses are " + courses);

        instructors.forEach(instructor ->
                biConsumerNameAndCourses.accept(instructor.getName(), instructor.getCourses()));
    }

}
