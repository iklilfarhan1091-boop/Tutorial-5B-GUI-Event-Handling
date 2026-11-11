import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JLabel label1, label2, label3, label4;
    private JTextField textNum1, textNum2, textResult;

    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;

    public SimpleCalculator() {

        // Create components
        label1 = new JLabel("Simple Calculator");
        label2 = new JLabel("Enter first number:");
        label3 = new JLabel("Enter second number:");
        label4 = new JLabel("Result:");

        textNum1 = new JTextField(10);
        textNum2 = new JTextField(10);
        textResult = new JTextField(10);

        textResult.setEditable(false);

        // Create operation buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        // Register buttons with ActionListener
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Create operation panel
        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Layout setup
        setLayout(new GridLayout(5, 2, 5, 5));

        add(label1);
        add(new JLabel(""));

        add(label2);
        add(textNum1);

        add(label3);
        add(textNum2);

        add(label4);
        add(textResult);

        add(new JLabel(""));
        add(buttonPanel);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {

        try {

            double num1 = Double.parseDouble(textNum1.getText());
            double num2 = Double.parseDouble(textNum2.getText());

            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            }

            else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            }

            else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            }

            else if (e.getSource() == divideButton) {

                if (num2 == 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Cannot divide by zero!"
                    );
                    return;
                }

                result = num1 / num2;
            }

            textResult.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers!"
            );
        }
    }

    public static void main(String[] args) {

        SimpleCalculator frame = new SimpleCalculator();

        // Frame setup
        frame.setTitle("Simple Calculator");
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}