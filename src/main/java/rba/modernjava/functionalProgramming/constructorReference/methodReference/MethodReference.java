package rba.modernjava.functionalProgramming.constructorReference.methodReference;

import java.util.function.Function;

public class MethodReference {

    public static void main(String[] args) {

        Function<Integer, Double> sqrtLambdReference  = a -> Math.sqrt(a);
        Function<Integer, Double> sqrtMethodReference = Math::sqrt;

        Function<String, String> lowercaseLambdaReference = s -> s.toLowerCase();
        Function<String, String> lowercaseMethodReference = String::toLowerCase;

    }
}
