package rba.modernjava.functionalProgramming.function;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Double> sqrtPlusPi = (n) -> Math.sqrt(n) * Math.PI;
        System.out.println(sqrtPlusPi.apply(9));

        Function<String, String> lowerCaseFunction = (str) -> str.toLowerCase();
        System.out.println(lowerCaseFunction.apply("OLA MunDo"));

        Function<String, Boolean> validateOlaMundoFunction = (str) -> str.equals("ola mundo");
        System.out.println(lowerCaseFunction.andThen(validateOlaMundoFunction).apply("Ola MunDO"));


    }
}
