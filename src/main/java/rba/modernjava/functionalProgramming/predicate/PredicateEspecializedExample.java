package rba.modernjava.functionalProgramming.predicate;

import java.util.function.*;

public class PredicateEspecializedExample {

    public static void main(String[] args) {
        IntPredicate intPredicate = (n) -> n > 100;
        System.out.println(intPredicate.test(101)) ;
        System.out.println(intPredicate.test(100));

        LongPredicate longPredicate = (n) -> n < 100L;
        System.out.println(longPredicate.test(99L));
        System.out.println(longPredicate.test(10000001L));

        DoublePredicate doublePredicate = (d) -> d * 3.14 > 10;
        System.out.println(doublePredicate.test(1.2));
        System.out.println(doublePredicate.test(3.9));
    }


}
