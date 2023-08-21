package rba.modernjava.functionalProgramming;

import java.util.Arrays;
import java.util.List;


public class InstructorsMock {

    public static List<Instructor> getAll(){
        return Arrays.asList(
                Instructor.builder().name("Jack")
                        .yearsOfExp(11)
                        .title("Software Developer")
                        .gender("male")
                        .courses(Arrays.asList("Java Programming", "Spring Boot Advanced"))
                        .isOnlineCourse(true)
                        .build(),
                Instructor.builder().name("Hanna")
                        .yearsOfExp(3)
                        .title("Software Developer")
                        .gender("female")
                        .courses(Arrays.asList("Ruby"))
                        .isOnlineCourse(true)
                        .build(),
                Instructor.builder().name("Kate")
                        .yearsOfExp(6)
                        .title("Tester")
                        .gender("female")
                        .courses(Arrays.asList("Java for testers", "Cocumber"))
                        .isOnlineCourse(true)
                        .build(),
                Instructor.builder().name("Bob")
                        .yearsOfExp(11)
                        .title("Tester")
                        .gender("male")
                        .courses(Arrays.asList("Java for testers", "Ruby"))
                        .isOnlineCourse(true)
                        .build()
        );
    }

}
