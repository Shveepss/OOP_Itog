import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Внутренний класс для обработки событий нажатия кнопки операции.
 */
public class OperationListener implements ActionListener {
    private final ComplexCalculator calculator;
    private final JTextField real1Field;
    private final JTextField imaginary1Field;
    private final JTextField real2Field;
    private final JTextField imaginary2Field;
    private final JTextField resultField;
    private final String operation;
    private final Logger logger = Logger.getLogger(OperationListener.class.getName());

    /**
     * Конструктор принимает операцию и ссылки на текстовые поля.
     *
     * @param calculator       экземпляр калькулятора
     * @param real1Field       поле для ввода действительной части первого числа
     * @param imaginary1Field  поле для ввода мнимой части первого числа
     * @param real2Field       поле для ввода действительной части второго числа
     * @param imaginary2Field  поле для ввода мнимой части второго числа
     * @param resultField      поле для отображения результата
     * @param operation        операция
     */
    public OperationListener(ComplexCalculator calculator, JTextField real1Field, JTextField imaginary1Field,
                             JTextField real2Field, JTextField imaginary2Field, JTextField resultField, String operation) {
        this.calculator = calculator;
        this.real1Field = real1Field;
        this.imaginary1Field = imaginary1Field;
        this.real2Field = real2Field;
        this.imaginary2Field = imaginary2Field;
        this.resultField = resultField;
        this.operation = operation;
    }

    /**
     * Метод выполняет операцию при нажатии на кнопку.
     *
     * @param e событие нажатия кнопки
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double real1 = Double.parseDouble(real1Field.getText());
            double imaginary1 = Double.parseDouble(imaginary1Field.getText());
            double real2 = Double.parseDouble(real2Field.getText());
            double imaginary2 = Double.parseDouble(imaginary2Field.getText());

            ComplexNumber num1 = new ComplexNumber(real1, imaginary1);
            ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

            ComplexNumber result;
            switch (operation) {
                case "add":
                    result = calculator.add(num1, num2);
                    break;
                case "multiply":
                    result = calculator.multiply(num1, num2);
                    break;
                case "divide":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }

            resultField.setText("Result: " + result.toString());
            logger.log(Level.INFO, "Result {0}: {1}", new Object[]{operation, result});
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, "Error performing operation: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error performing operation: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
