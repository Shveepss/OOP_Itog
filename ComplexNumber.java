/**
 * Класс, представляющий комплексное число.
 */
class ComplexNumber {
    private final double real;
    private final double imaginary;

    /**
     * Конструктор для создания комплексного числа.
     * @param real действительная часть комплексного числа
     * @param imaginary мнимая часть комплексного числа
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Получить действительную часть комплексного числа.
     * @return действительная часть комплексного числа
     */
    public double getReal() {
        return real;
    }

    /**
     * Получить мнимую часть комплексного числа.
     * @return мнимая часть комплексного числа
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Переопределение метода toString() для получения строкового представления комплексного числа.
     * @return строковое представление комплексного числа
     */
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}