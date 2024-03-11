import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для создания графического интерфейса калькулятора комплексных чисел.
 */
public class App extends JFrame {
    private final ComplexCalculator calculator = new ComplexCalculator();
    private final Logger logger = Logger.getLogger(App.class.getName());

    private final JTextField real1Field = new JTextField(5);
    private final JTextField imaginary1Field = new JTextField(5);
    private final JTextField real2Field = new JTextField(5);
    private final JTextField imaginary2Field = new JTextField(5);
    private final JTextField resultField = new JTextField(10);

    /**
     * Конструктор создает графический интерфейс калькулятора комплексных чисел.
     */
    public App() {
        setTitle("Complex Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Комплексное число 1"));
        inputPanel.add(new JLabel("Комплексное число 2"));
        inputPanel.add(createComplexInputPanel(real1Field, imaginary1Field));
        inputPanel.add(createComplexInputPanel(real2Field, imaginary2Field));

        JPanel operationPanel = new JPanel(new FlowLayout());
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        operationPanel.add(createOperationButton("Сложение", "add"));
        operationPanel.add(createOperationButton("Умножение", "multiply"));
        operationPanel.add(createOperationButton("Деление", "divide"));

        add(inputPanel, BorderLayout.CENTER);
        add(operationPanel, BorderLayout.SOUTH);

        resultField.setEditable(false);
        add(resultField, BorderLayout.NORTH);

        setVisible(true);
    }

    /**
     * Метод создает панель для ввода комплексного числа с указанными полями.
     *
     * @param realField      поле для ввода действительной части
     * @param imaginaryField поле для ввода мнимой части
     * @return панель для ввода комплексного числа
     */
    private JPanel createComplexInputPanel(JTextField realField, JTextField imaginaryField) {
        JPanel panel = new JPanel(new GridLayout(1, 4, 5, 5));
        panel.add(new JLabel("Реальное"));
        panel.add(realField);
        panel.add(new JLabel("Мнимое"));
        panel.add(imaginaryField);
        return panel;
    }

    /**
     * Метод создает кнопку операции с указанным текстом и операцией.
     *
     * @param label     текст кнопки
     * @param operation операция
     * @return кнопка операции
     */
    private JButton createOperationButton(String label, String operation) {
        JButton button = new JButton(label);
        button.addActionListener(new OperationListener(operation));
        return button;
    }

    private class OperationListener implements ActionListener {
        private final String operation;

        public OperationListener(String operation) {
            this.operation = operation;
        }

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
                        throw new IllegalArgumentException("Не корректная операция");
                }

                resultField.setText("Результат: " + result.toString());
                logger.log(Level.INFO, "Result {0}: {1}", new Object[]{operation, result});
            } catch (IllegalArgumentException ex) {
                logger.log(Level.SEVERE, "Error performing operation: " + ex.getMessage());
                JOptionPane.showMessageDialog(App.this, "Error performing operation: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
