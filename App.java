public class App {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(1, 4);

        ComplexCalculator calculator = new ComplexCalculator();
        System.out.println(calculator.add(num1, num2));
        System.out.println(calculator.multiply(num1, num2));
        System.out.println(calculator.divide(num1, num2));
    }
}