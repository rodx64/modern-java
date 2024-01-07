package rba.modernjava.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    private static final Employee[] arrayOfEmployee = {
            new Employee(1, "Jeff Bezos", new BigDecimal("100000.0")),
            new Employee(2,"Bill Gates",new BigDecimal("200000.0")),
            new Employee(3,"Mark Zuckerberg",new BigDecimal("300000.0")),
            new Employee(3,"Mark Zuckerberg",new BigDecimal("300000.0")),
            null
    };

    // To avoid IllegalStateException (stream has already been operated upon or closed)
    static Supplier<Stream<Employee>> streamSupplier = () -> Stream.of(arrayOfEmployee);

    public static void main(String[] args) {
        System.out.println("\nForEach");
        forEachStream();
        System.out.println("\nFilter");
        filterStream();
        System.out.println("\nMap");
        mapStream();
        System.out.println("\nFlatMap");
        flatMapStream();
        System.out.println("\nSorted");
        sortedStream();
        System.out.println("\nCollected");
        collectStream();
        System.out.println("\nReduced");
        reduceStream();
        System.out.println("\nPeek");
        peekStream();
        System.out.println("\nMatch");
        matchStream();
        System.out.println("\nSkip");
        skipStream();
        System.out.println("\nDistinct");
        distinctStream();
        System.out.println("\nLimit");
        limitStream();
        System.out.println("\nGenerate");
        generateStream();
    }

    private static void filterStream(){
        streamSupplier.get()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    private static void mapStream(){
        System.out.println("- Mapping String (Name)");
        streamSupplier.get()
                .filter(Objects::nonNull)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("- Mapping BigDecimal (Salary)");
        streamSupplier.get()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .forEach(System.out::println);
    }

    private static void flatMapStream(){
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("Audi", "Mercedes"),
            Arrays.asList("Ferrari", "Lamborghini"),
            Arrays.asList("Renault", "Peugeot"),
            Arrays.asList("Toyota", "Honda", "Nissan"));

        nestedList.stream()
            .flatMap(Collection::stream)
            .forEach(System.out::println);
    }

    private static void sortedStream(){
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Audi", "Mercedes"),
                Arrays.asList("Ferrari", "Lamborghini"),
                Arrays.asList("Renault", "Peugeot"),
                Arrays.asList("Toyota", "Honda", "Nissan"));

        nestedList.stream()
                .flatMap(Collection::stream)
                .sorted()
                .forEach(System.out::println);
    }

    private static void forEachStream() {
        streamSupplier.get().forEach(System.out::println);
    }

    private static void collectStream(){
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Audi", "Mercedes"),
                Arrays.asList("Ferrari", "Lamborghini"),
                Arrays.asList("Renault", "Peugeot"),
                Arrays.asList("Toyota", "Honda", "Nissan"));

        List<String> sortedCarList = nestedList.stream()
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());

        sortedCarList.forEach(System.out::println);
    }

    private static void reduceStream(){
        BigDecimal totalSalaryMethod = streamSupplier.get()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.CEILING)
                ;
        System.out.println(totalSalaryMethod);
    }

    private static void peekStream(){
        streamSupplier.get()
                .filter(Objects::nonNull)
                .peek(employee -> employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.1"))))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void matchStream(){
        boolean allMillionaire = streamSupplier.get()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .allMatch(salary -> salary.compareTo(new BigDecimal("10000")) >= 0);

        boolean noneSalaryBiggerThan400000 = streamSupplier.get()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .noneMatch(salary -> salary.compareTo(new BigDecimal("400000")) >= 0);

        boolean anySalaryLessThan100000 = streamSupplier.get()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .anyMatch(salary -> salary.compareTo(new BigDecimal("100000")) < 0);

        System.out.println(allMillionaire);
        System.out.println(noneSalaryBiggerThan400000);
        System.out.println(anySalaryLessThan100000);
    }

    public static void skipStream(){
        streamSupplier.get()
            .skip(1)
            .forEach(System.out::println);
    }

    public static void distinctStream() {
        long counter = streamSupplier.get()
                .filter(Objects::nonNull)
                .distinct()
                .count();

        System.out.println(counter);
    }

    public static void limitStream(){
        streamSupplier.get()
                .filter(Objects::nonNull)
                .limit(2)
                .forEach(System.out::println);
    }

    public static void generateStream(){
        Random random = new Random();
        Supplier<Integer> supplier = random::nextInt;

        Stream<Integer> streamRandom = Stream.generate(supplier);
        streamRandom.filter(i -> i > 0)
                .limit(10)
                .forEach(System.out::println);
    }
}

@AllArgsConstructor
@Data
@ToString
class Employee {
    private Integer id;
    private String name;
    private BigDecimal salary;
}
