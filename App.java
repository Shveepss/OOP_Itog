import javax.swing.*;
import java.awt.*;
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
        inputPanel.add(new JLabel("Complex Number 1"));
        inputPanel.add(new JLabel("Complex Number 2"));
        inputPanel.add(createComplexInputPanel(real1Field, imaginary1Field));
        inputPanel.add(createComplexInputPanel(real2Field, imaginary2Field));

        JPanel operationPanel = new JPanel(new FlowLayout());
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        operationPanel.add(createOperationButton("Add", "add"));
        operationPanel.add(createOperationButton("Multiply", "multiply"));
        operationPanel.add(createOperationButton("Divide", "divide"));

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
        panel.add(new JLabel("Real"));
        panel.add(realField);
        panel.add(new JLabel("Imaginary"));
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
        button.addActionListener(new OperationListener(calculator, real1Field, imaginary1Field, real2Field, imaginary2Field, resultField, operation));
        return button;
    }

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
