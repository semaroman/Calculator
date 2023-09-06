import java.util.function.*;

class Main {
    public static void main(String[] args) {
        try { Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.devide.apply(a, b); //возникает исключение ArithmeticException: / by zero,
            // так как делить на ноль нельзя, а число b равно нулю,
            // потому что оба числа в операции вычитания одинаковы.
            // Чтобы избежать этой ошибки, нужно изменить одно из чисел.
        calc.println.accept(c);
        } catch(ArithmeticException e) {
            System.out.println("Деление на ноль невозможно");
        }
    }
}

class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}