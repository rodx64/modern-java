# Suplier
A Functional Interface ```Suplier``` is a part of the java.util.function package which has been introduced since Java 8.

It represents a function which does not take in any argument but produces a value of type T.

```Suplier<T> ```

### Basic Suplier Examples
```
Supplier<Double>  powerOfTenOnBaseTwo = () -> Math.pow(2, 10);
powerOfTenOnBaseTwo.get();
// 1024
```
