# Streams

A Stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

### GIVEN DATA: 
```
private static Stream<Employee> employees = Stream.of(
   new Employee(1, "Jeff Bezos", new BigDecimal("100000.0")),
   null,
   new Employee(2, "Bill Gates", new BigDecimal("200000.0")),
   new Employee(3, "Mark Zuckerberg", new BigDecimal("300000.0")),
   null
);

private List<List<String>> nestedCarsList = Arrays.asList(
    Arrays.asList("Audi", "Mercedes"),
    Arrays.asList("Ferrari", "Lamborghini"),
    Arrays.asList("Renault", "Peugeot"),
    Arrays.asList("Toyota", "Honda", "Nissan")
);
```

## Intermediate Operations of a Stream

-[x] filter: produces a new stream that contains elements of the original stream that pass a given test
```
employees.get()
    .filter(Objects::nonNull)
    .forEach(System.out::println);
    
// Employee(id=1, name=Jeff Bezos, salary=100000.0)
// Employee(id=2, name=Bill Gates, salary=200000.0)
// Employee(id=3, name=Mark Zuckerberg, salary=300000.0)
```

-[x] map: produces a new stream after applying a function to each element of the original stream. The new stream could be of different type
```
employees.get()
    .filter(Objects::nonNull)
    .map(Employee::getName)
    .forEach(System.out::println); 
    
employees.get()
    .filter(Objects::nonNull)
    .map(Employee::getSalary)
    .forEach(System.out::println);

// Jeff Bezos
// Bill Gates
// Mark Zuckerberg

// 100000.0
// 200000.0
// 300000.0
```

-[x] flatMap: helps us to flatten the data structure to simplify further operations, because a stream can hold complex nested data structures
```
nestedCarsList.stream()
    .flatMap(Collection::stream)
    .forEach(System.out::println);

// Audi
// Mercedes
// Ferrari
// Lamborghini
// Renault
// Peugeot
// Toyota
// Honda
// Nissan
```
-[x] sorted: sort the stream using comparator
```
nestedCarsList.stream()
    .flatMap(Collection::stream)
    .sorted()
    .forEach(System.out::println);
    
// Audi
// Ferrari
// Honda
// Lamborghini
// Mercedes
// Nissan
// Peugeot
// Renault
// Toyota
    
```
-[x] peek: perform multiple operations on each element of the stream before any terminal operation is applied
```
streamSupplier.get()
    .filter(Objects::nonNull)
    .peek(employee -> employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.1"))))
    .peek(System.out::println)
    .collect(Collectors.toList());
    
// Employee(id=1, name=Jeff Bezos, salary=110000.00)
// Employee(id=3, name=Mark Zuckerberg, salary=330000.00)
// Employee(id=2, name=Bill Gates, salary=220000.00)
    
```



## Terminal Operations of a Stream
-[x] forEach: it loops over the stream elements, calling the supplied function on each element
```
employees.forEach(System.out::println);

// Employee(id=1, name=Jeff Bezos, salary=100000.0)
// null
// Employee(id=2, name=Bill Gates, salary=200000.0)
// Employee(id=3, name=Mark Zuckerberg, salary=300000.0)
// null
```

-[x] collect: return the result of terminal operations
```
List<String> sortedCarList = nestedCarsList.stream()
    .flatMap(Collection::stream)
    .sorted()
    .collect(Collectors.toList());
    
```
-[x] reduce: performs a reduction on the element of the stream
```

BigDecimal totalSalaryLambda = employees
    .filter(Objects::nonNull)
    .map(Employee::getSalary)
    .reduce(new BigDecimal("0"), (a, b) -> a.add(b))
    .setScale(2, RoundingMode.CEILING)
    ;
    
BigDecimal totalSalaryMethod = employees
    .filter(Objects::nonNull)
    .map(Employee::getSalary)
    .reduce(BigDecimal.ZERO, BigDecimal::add)
    .setScale(2, RoundingMode.CEILING)
    ;

System.out.println(totalSalaryLambda);
// 600000.00
System.out.println(totalSalaryMethod);
// 600000.00
```

-[x] allMatch, anyMatch, and noneMatch: take a predicate and return a boolean
```
boolean allMillionaire = employees
    .filter(Objects::nonNull)
    .map(Employee::getSalary)
    .allMatch(salary -> salary.compareTo(new BigDecimal("10000")) >= 0);

boolean noneSalaryBiggerThan400000 = employees
    .filter(Objects::nonNull)
    .map(Employee::getSalary)
    .noneMatch(salary -> salary.compareTo(new BigDecimal("400000")) >= 0);

boolean anySalaryLessThan100000 = employees
    .filter(Objects::nonNull)
    .map(Employee::getSalary)
    .anyMatch(salary -> salary.compareTo(new BigDecimal("100000")) < 0);
        
System.out.println(allMillionaire);
// true

System.out.println(noneSalaryBiggerThan400000);
// true

System.out.println(anySalaryLessThan100000);
// false
```
-[x] skip: Returns a stream consisting of the remaining elements of this stream after discarding the first n elements skip(n)
```
employees.get()
    .skip(1)
    .forEach(System.out::println);
    
// Employee(id=2, name=Bill Gates, salary=220000.00)
// Employee(id=3, name=Mark Zuckerberg, salary=330000.00)
// null

employees.get()
    .skip(2)
    .forEach(System.out::println);
    
// Employee(id=3, name=Mark Zuckerberg, salary=330000.00)
// null
```
-[x] limit: Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.

```
employees.get()
    .filter(Objects::nonNull)
    .limit(2)
    .forEach(System.out::println);
    
// Employee(id=1, name=Jeff Bezos, salary=110000.00)
// Employee(id=2, name=Bill Gates, salary=220000.00)
```
