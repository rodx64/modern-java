package rba.modernjava.streams.collectors;

import rba.modernjava.functionalProgramming.Instructor;
import rba.modernjava.functionalProgramming.InstructorsMock;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class StreamCollectors {

    public static void main(String[] args) {
        printJoining();
            System.out.println();
        printCouting();
            System.out.println();
        printMapping();
            System.out.println();
        printMinMaxBy();
            System.out.println();
        printSummingAndAveraging();
            System.out.println();
        printGroupingByClassifier();
            System.out.println();
        printGroupingByClassifierAndSupplier();
            System.out.println();
        printGroupingByClassifierAndMapAndSupplier();
            System.out.println();
        printGroupingByCollectingAndThen();
            System.out.println();
        printPartitionBy();
            System.out.println();
    }

    private static void printPartitionBy() {
        System.out.println(":: PARTITION BY :: ");
        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));
        Predicate<Instructor> experiencePredicate = instructor ->
                instructor.getYearsOfExp() > 10;

        Map<Boolean, List<Instructor>> partitionMap = InstructorsMock.getAll()
                .stream().collect(Collectors.partitioningBy(experiencePredicate));
        System.out.println("partitionBy() - Have more then 10 years of experience ?");
        partitionMap.forEach((key,value)-> {
            System.out.println("More then 10 years = " + key + " - Instructor = " + value);
        });

    }

    private static void printGroupingByCollectingAndThen() {
        System.out.println(":: GROUPING BY :: CollectingAndThen()");
        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));
        Map<Boolean, Instructor> maxInstructors1 = InstructorsMock.getAll()
                .stream().collect(Collectors.groupingBy(Instructor::isOnlineCourse,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing
                                        (Instructor::getYearsOfExp)),
                                Optional::get)));

        System.out.println("groupingBy() Instructors more experienced with online courses");
        maxInstructors1.forEach((key, value) ->
                System.out.println("Online Course = " + key + ", Instructor = " + value));
    }

    private static void printGroupingByClassifierAndMapAndSupplier() {
        System.out.println(":: GROUPING BY :: Classifier, Map and Supplier");
        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));

        Map<String, List<Instructor>> instructorSeniorityOnline = InstructorsMock.getAll().stream()
                .collect(groupingBy(instructor ->
                    instructor.getYearsOfExp() > 10 ? "Senior" : "Junior",
                    filtering(i -> i.getTitle().contains("Software"),
                    toList()
                )));

        System.out.println("groupingBy() Instructors more experienced and software developers");
        instructorSeniorityOnline.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });
    }

    private static void printGroupingByClassifierAndSupplier() {
        System.out.println(":: GROUPING BY :: Classifier and Supplier");
        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));
        Map<Integer, List<String>> sizeNameMap = InstructorsMock.getAll().stream()
                .map(Instructor::getName)
                .collect(
                        groupingBy(String::length,                                  // groupby sizename
                            filtering(i -> i.contains("a"), Collectors.toList())    // groupby contains A
                        )
                );
        System.out.println("groupingBy() sizeNames and Name containing letter A: " + sizeNameMap);
    }

    private static void printGroupingByClassifier() {
        System.out.println(":: GROUPING BY :: Only Classifier");

        Map<String, List<Instructor>> genderMap = InstructorsMock.getAll()
                .stream()
                .collect(groupingBy(Instructor::getGender));
        System.out.println("groupingBy() gender: ");
        genderMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }


    private static void printSummingAndAveraging() {
        System.out.println(":: SUMMING and AVERAGING:: from Instructors List and YearsOfExperience");
        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));

        int sum = InstructorsMock.getAll().stream()
                .collect(summingInt(Instructor::getYearsOfExp));
        System.out.println("summingInt() -> " + sum);

        double avg = InstructorsMock.getAll().stream()
                .collect(averagingInt(Instructor::getYearsOfExp));
        System.out.println("averagingInt() -> " + avg);


    }

    private static void printMinMaxBy() {
        System.out.println(":: MIN and MAX:: from Instructors List verifying YearsOfExperience");
        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));

        Optional<Instructor> min = InstructorsMock.getAll().stream()
                .collect(minBy(Comparator.comparing(Instructor::getYearsOfExp)));
        System.out.println("minBy() -> " + min.get());


        Optional<Instructor> max = InstructorsMock.getAll().stream()
                .collect(maxBy(Comparator.comparing(Instructor::getYearsOfExp)));
        System.out.println("maxBy() -> " + max.get());
    }

    private static void printMapping() {
        System.out.println(":: MAPPING :: -> Instructor List to Instructors Name List ");

        InstructorsMock.getAll().forEach(i -> System.out.println("- Instructors : " + i));

        InstructorsMock.getAll()
            .stream()
            .collect(mapping(Instructor::getName, toList()))
            .forEach(System.out::println);
    }

    private static void printCouting() {
        System.out.println(":: COUTING :: -> 1,2,3,4,5,6,7,8,9,0 ");
        long n = Stream.of(1,2,3,4,5,6,7,8,9,0)
                .filter(i -> i % 2 != 0)
                .collect(Collectors.counting());
        System.out.println("Counting filtered odd numbers -> " + n);
    }

    private static void printJoining(){
        System.out.println(":: JOINING :: -> \"A\", \"B\", \"C\", \"D\", \"E\"");

        String string = Stream.of("A", "B", "C", "D", "E").collect(Collectors.joining());
        System.out.println("Simple Joining -> " + string);

        String stringDelimiter = Stream.of("A", "B", "C", "D", "E").collect(Collectors.joining(","));
        System.out.println("Delimiting and Joining -> " + stringDelimiter);

        String stringDelimiterPrefix = Stream.of("A", "B", "C", "D", "E")
                .collect(Collectors.joining(",", "{", ""));
        System.out.println("Delimiting, Prefixing and Joining -> " + stringDelimiterPrefix);

        String stringDelimiterPrefixSufix = Stream.of("A", "B", "C", "D", "E")
                .collect(Collectors.joining(",", "{", "}"));

        System.out.println("Prefixing, Suffixing and Joining -> " + stringDelimiterPrefixSufix);
    }
}
