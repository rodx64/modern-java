# Predicates
A Functional Interface ```Predicate<T>``` is an Interface which allows only one Abstract method within the Interface scope.

- [x] Manageability of code
- [x] Helps in unit-testing them separately, 
- [x] Specialized Predicates (IntPredicate, LongPredicate, DoublePredicate)

### Basic Predicate Examples
```
Predicate<Integer> biggerThanOrEqualtoTen = (i) -> i >= 10;
biggerThanOrEqualtoTen.test(11);
// true

Predicate<Integer> biggerThanOrEqualtoTenAndOdd = (i) -> i >= 10 && (i % 2 == 0);
biggerThanOrEqualtoTenAndOdd.test(10);
// true
biggerThanOrEqualtoTenAndOdd.test(11);
// false

Predicate<Integer> biggerThanOrEqualtoTenOrOdd = (i) -> i >= 10 || (i % 2 == 0);
biggerThanOrEqualtoTenOrOdd.test(8);
// true
biggerThanOrEqualtoTenOrOdd.test(9);
// false
biggerThanOrEqualtoTenOrOdd.test(10);
// true
biggerThanOrEqualtoTenOrOdd.test(11);
// true

```

### Basic BiPredicate Examples
```
BiPredicate<Boolean, Integer> hasNecessaryLevel = 
    (working, timeOsExperience) -> !working && timeOsExperience >=5;

hasNecessaryLevel.test(true, 5);
//false

hasNecessaryLevel.test(false, 4);
//false

hasNecessaryLevel.test(false, 6);
//true

```

### Methods:
- isEqual()
- negate():
- and():
- or() :
 
