package rba.modernjava.functionalProgramming;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Instructor {
    String name;
    int yearsOfExp;
    String title;
    String gender;
    boolean isOnlineCourse;
    List<String> courses;
}
