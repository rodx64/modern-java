# BinaryOperator
A Functional Interface ```BinaryOperator<T>``` is a part of the java.util.function package which has been introduced since Java 8.

It represents a function which takes two operands and operates on them to produce a result.

- [x] Since (T,U,R) are equal there is only one (T) 
  - _basically the difference of the BiFunction<T,U,R>_


- [x] Specialized Operators (IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator)

```BinaryOperator<T> overloads the BiFunction<T, U, R>```

### Basic BinaryOperator Examples
```
BinaryOperator<Integer> multiply = (a, b) -> a * b ;
multiply.apply(3, 3);
// 9

Comparator<Integer> intComparator = Integer::compareTo;
BinaryOperator<Integer> max = BinaryOperator.maxBy(intComparator);
BinaryOperator<Integer> min = BinaryOperator.minBy(intComparator);

max.apply(10, 11);
// 11
min.apply(10, 11);
// 10
```
