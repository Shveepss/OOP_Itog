import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс, представляющий калькулятор комплексных чисел.
 */
class ComplexCalculator {
    private static final Logger logger = Logger.getLogger(ComplexCalculator.class.getName());

    /**
     * Метод для сложения двух комплексных чисел.
     * @param num1 первое комплексное число
     * @param num2 второе комплексное число
     * @return результат сложения
     */
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getReal() + num2.getReal();
        double imaginaryPart = num1.getImaginary() + num2.getImaginary();
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);

        logger.log(Level.INFO, "Результат сложения: {0}", result);
        return result;
    }

    /**
     * Метод для умножения двух комплексных чисел.
     * @param num1 первое комплексное число
     * @param num2 второе комплексное число
     * @return результат умножения
     */
    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double imaginaryPart = num1.getReal() * num2.getImaginary() + num2.getReal() * num1.getImaginary();
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);

        logger.log(Level.INFO, "Результат умножения: {0}", result);
        return result;
    }

    /**
     * Метод для деления двух комплексных чисел.
     * @param num1 делимое комплексное число
     * @param num2 делитель комплексное число
     * @return результат деления
     */
    public ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        double denominator = Math.pow(num2.getReal(), 2) + Math.pow(num2.getImaginary(), 2);
        double realPart = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / denominator;
        double imaginaryPart = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / denominator;
        ComplexNumber result = new ComplexNumber(realPart, imaginaryPart);

        logger.log(Level.INFO, "Результат деления: {0}", result);
        return result;
    }
}
