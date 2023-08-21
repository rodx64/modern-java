package rba.modernjava.functionalProgramming.function;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Double> sqrtPlusPi = (n) -> Math.sqrt(n) * Math.PI;
        System.out.println(sqrtPlusPi.apply(9));

        Function<String, String> lowerCaseFunction = (str) -> str.toLowerCase();
        System.out.println(lowerCaseFunction.apply("OLA MunDo"));

        Function<String, Boolean> validateHelloWorld = (str) -> str.equals("hello world");
        System.out.println(lowerCaseFunction.andThen(validateHelloWorld).apply("hElLo wORlD"));

        Function<Integer, Integer> multiplyBy3 = (a) -> a * 3;
        Function<Integer, Double> half = a -> a / 2.0;
        half = half.compose(multiplyBy3);
        System.out.println(half.apply(5));

        Function<Integer, Integer> id = Function.identity();
        System.out.println(id.apply(1000));;
    }
}
