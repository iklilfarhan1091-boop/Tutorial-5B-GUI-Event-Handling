import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJRadioButtonYellow extends JFrame implements ActionListener {

    JRadioButton my_button1 = new JRadioButton("Blue");
    JRadioButton my_button2 = new JRadioButton("Green");
    JRadioButton my_button3 = new JRadioButton("Red");
    JRadioButton my_button4 = new JRadioButton("Yellow");

    JLabel selection = new JLabel("Yellow");

    public MyJRadioButtonYellow() {

        Container pane = getContentPane();
        pane.setBackground(Color.white);
        pane.setLayout(new BorderLayout());

        // Create title
        JLabel title = new JLabel(
            "Select your MOST favourite color:",
            JLabel.CENTER
        );

        // Create radio button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(my_button1);
        buttonPanel.add(my_button2);
        buttonPanel.add(my_button3);
        buttonPanel.add(my_button4);

        // Group radio buttons
        ButtonGroup btn_group = new ButtonGroup();

        btn_group.add(my_button1);
        btn_group.add(my_button2);
        btn_group.add(my_button3);
        btn_group.add(my_button4);

        // Set Yellow as selected initially
        my_button4.setSelected(true);

        // Register action listeners
        my_button1.addActionListener(this);
        my_button2.addActionListener(this);
        my_button3.addActionListener(this);
        my_button4.addActionListener(this);

        // Create result panel
        JPanel resultPanel = new JPanel(new FlowLayout());

        resultPanel.add(new JLabel("You have selected:"));
        resultPanel.add(selection);

        // Add panels to container
        pane.add(title, BorderLayout.NORTH);
        pane.add(buttonPanel, BorderLayout.CENTER);
        pane.add(resultPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {

        String input = "";

        if (my_button1.isSelected())
            input = my_button1.getText();

        else if (my_button2.isSelected())
            input = my_button2.getText();

        else if (my_button3.isSelected())
            input = my_button3.getText();

        else if (my_button4.isSelected())
            input = my_button4.getText();

        selection.setText(input);
    }

    public static void main(String[] args) {

        MyJRadioButtonYellow frame = new MyJRadioButtonYellow();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Frame");
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}