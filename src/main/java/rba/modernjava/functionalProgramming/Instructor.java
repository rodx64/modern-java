package rba.modernjava.functionalProgramming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Instructor {
    String name;
    int yearsOfExp;
    String title;
    String gender;
    boolean isOnlineCourse;
    List<String> courses;
}
