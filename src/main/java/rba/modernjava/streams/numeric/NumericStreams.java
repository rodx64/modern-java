package rba.modernjava.streams.numeric;

import lombok.ToString;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreams {

    public static void main(String[] args) {
        printBasicFunctions();
            System.out.println();
        printMaxMinAvg();
            System.out.println();
        printBoxingUnboxing();
            System.out.println();
        printMapTo();
    }

    private static void printBoxingUnboxing(){
        List<Integer> numbers;
        IntStream intStream = IntStream.of(1,2,3);        // primitive type
        numbers = intStream.boxed().collect(Collectors.toList()); // Object type

        numbers.forEach(i -> {
            System.out.println(":: Boxed value (" + i + "), input is instance of Object = " + (i instanceof Object));
        });

        numbers.stream().mapToInt(Integer::intValue).forEach(i -> {
            System.out.println(":: Unboxed value (" + i + ")");
        });
    }

    private static void printMapTo(){
        IntStream.rangeClosed(0,5)
                .mapToObj(integerToMap ->  {
                    int randomInt = ThreadLocalRandom.current().nextInt(100);
                    return new RandomId(integerToMap, randomInt);
                })
                .collect(Collectors.toList())
                .forEach(id -> {
                    System.out.println(":: maptoObj :: (" + id + ")");
                });

        IntStream.rangeClosed(0,5).mapToLong(i -> (long)i)
                .forEach(i -> {
                    System.out.println(":: mapToLong :: (" + i + ")");
                });

        LongStream.rangeClosed(0,5).mapToDouble(i -> (double)i)
                .forEach(i -> {
                    System.out.println(":: mapToDouble :: (" + i + ")");
                });
    }



    private static void printMaxMinAvg(){
        int sum = IntStream.rangeClosed(0, 100).sum();
        System.out.println(":: SUM :: from 0 to 100 = " + sum);

        OptionalInt min = IntStream.rangeClosed(0, 100).min();
        System.out.println(":: MIN :: from 0 to 100 = " + min.getAsInt());

        OptionalInt max = IntStream.rangeClosed(0, 100).max();
        System.out.println(":: MAX :: from 0 to 100 = " + max.getAsInt());

        OptionalDouble avg = IntStream.rangeClosed(0, 100).average();
        System.out.println(":: AVG :: from 0 to 100 = " + avg.getAsDouble());

    }

    private static void printBasicFunctions() {
        System.out.println(":: forEach ::");
        IntStream.of(1,2,3).forEach(System.out::println);

        System.out.println(":: iterate ::");
        IntStream.iterate(0, i -> i+2).limit(3).forEach(System.out::println);

        System.out.println(":: generate ::");
        IntSupplier intSupplier = new Random()::nextInt;
        IntStream.generate(intSupplier).limit(3).forEach(System.out::println);

        System.out.println(":: range ::");
        IntStream.range(1,3).forEach(System.out::println);

        System.out.println(":: rangeClosed ::");
        IntStream.rangeClosed(1,3).forEach(System.out::println);
    }

}

@ToString
class RandomId {
    int id;
    int randomNumber;

    public RandomId(int id, int randomNumber) {
        this.id = id;
        this.randomNumber = randomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
