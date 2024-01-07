# Method Reference [::]
Methods allow us to reuse the code without retyping the code

``` Object::methodName  ```

### Basic Suplier Examples
```
- With Lambda (x) -> x 
Function<Integer, Double> sqrtLambdReference  = a -> Math.sqrt(a);
Function<String, String> lowercaseLambdaReference = s -> s.toLowerCase();

- With Method Reference Object::methodName
Function<Integer, Double> sqrtMethodReference = Math::sqrt;
Function<String, String> lowercaseMethodReference = String::toLowerCase;
```
