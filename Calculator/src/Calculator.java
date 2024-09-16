import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // Declare buttons and display field at the class level
    JTextField display;
    JButton one, two, three, four, five, six, seven, eight, nine, zero;
    JButton mulButton, sButton, divButton, addButton, eButton;

    // Constructor
    public Calculator() {

        JFrame f = new JFrame("Simple Calculator");

        // Creating number buttons
        one = new JButton("1");
        one.setBounds(0, 40, 100, 40);
        one.addActionListener(this);

        two = new JButton("2");
        two.setBounds(100, 40, 100, 40);
        two.addActionListener(this);

        three = new JButton("3");
        three.setBounds(200, 40, 100, 40);
        three.addActionListener(this);

        four = new JButton("4");
        four.setBounds(0, 80, 100, 40);
        four.addActionListener(this);

        five = new JButton("5");
        five.setBounds(100, 80, 100, 40);
        five.addActionListener(this);

        six = new JButton("6");
        six.setBounds(200, 80, 100, 40);
        six.addActionListener(this);

        seven = new JButton("7");
        seven.setBounds(0, 120, 100, 40);
        seven.addActionListener(this);

        eight = new JButton("8");
        eight.setBounds(100, 120, 100, 40);
        eight.addActionListener(this);

        nine = new JButton("9");
        nine.setBounds(200, 120, 100, 40);
        nine.addActionListener(this);

        zero = new JButton("0");
        zero.setBounds(100, 160, 100, 40);
        zero.addActionListener(this);

        // Creating operation buttons
        mulButton = new JButton("x");
        mulButton.setBounds(300, 120, 50, 40);
        mulButton.addActionListener(this);

        sButton = new JButton("-");
        sButton.setBounds(300, 80, 50, 40);
        sButton.addActionListener(this);

        divButton = new JButton("/");
        divButton.setBounds(300, 160, 50, 40);
        divButton.addActionListener(this);

        addButton = new JButton("+");
        addButton.setBounds(300, 40, 50, 40);
        addButton.addActionListener(this);

        eButton = new JButton("=");
        eButton.setBounds(200, 160, 100, 40);
        addButton.addActionListener(this);


        // Creating display screen
        display = new JTextField();
        display.setBounds(0, 0, 350, 40);
        f.add(display);

        // Adding buttons to the frame
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(zero);
        f.add(mulButton);
        f.add(sButton);
        f.add(divButton);
        f.add(addButton);
        f.add(eButton);

        // Frame settings
        f.setSize(366, 240);
        f.setLayout(null);
        f.setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        // Append the clicked button text to the display
        display.setText(display.getText() + command);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
