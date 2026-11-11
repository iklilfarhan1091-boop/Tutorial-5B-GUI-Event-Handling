import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyJRadioButton extends JFrame implements ActionListener {

    JRadioButton my_button1 = new JRadioButton("Blue");
    JRadioButton my_button2 = new JRadioButton("Green");
    JRadioButton my_button3 = new JRadioButton("Red");

    JLabel selection = new JLabel();

    public MyJRadioButton() {

        Container pane = getContentPane();

        pane.setBackground(Color.white);
        pane.setLayout(new GridLayout(6, 1));

        pane.add(new JLabel("Select your MOST favourite color:"));
        pane.add(my_button1);
        pane.add(my_button2);
        pane.add(my_button3);

        ButtonGroup btn_group = new ButtonGroup();

        btn_group.add(my_button1);
        btn_group.add(my_button2);
        btn_group.add(my_button3);

        // Set Green as initial selection to match tutorial figure
        my_button2.setSelected(true);

        my_button1.addActionListener(this);
        my_button2.addActionListener(this);
        my_button3.addActionListener(this);

        pane.add(new JLabel("You have selected:"));
        pane.add(selection);

    }

    public void actionPerformed(ActionEvent e) {

        String input = "";

        if (my_button1.isSelected())
            input = my_button1.getText();

        else if (my_button2.isSelected())
            input = my_button2.getText();

        else if (my_button3.isSelected())
            input = my_button3.getText();

        selection.setText(input);
    }

    public static void main(String[] args) {

        MyJRadioButton frame = new MyJRadioButton();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Frame");
        frame.setSize(350, 200);
        frame.setVisible(true);
    }
}