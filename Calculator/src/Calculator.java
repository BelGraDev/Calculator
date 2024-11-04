import javax.swing.*;


public class Calculator{

    // Declare buttons and display field at the class level
    JTextField display;
    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, mult, div, equals, clear, delete, ans;


    // Constructor
    public Calculator() {

        JFrame f = new JFrame("Simple Calculator");

        display = new JTextField();

        //Creating display where the operations are shown
        display.setBounds(0,0,350,60);
        f.add(display);

        //Creating number buttons
        one = new Button("1", f, display,100);
        two = new Button("2", f, display,100);
        three = new Button("3", f, display,100);

        plus = new Button("+", f, display,50);

        four = new Button("4", f, display,100);
        five = new Button("5", f, display,100);
        six = new Button("6", f, display,100);

        minus = new Button("-", f, display,50);


        seven = new Button("7", f, display,100);
        eight = new Button("8", f, display,100);
        nine = new Button("9", f, display,100);

        mult = new Button("x", f, display,50);
        
        clear = new Button("CLR", f, display, 100);
        zero = new Button("0", f, display,100);
        delete = new Button("Del", f, display, 100);

        div = new Button("/", f, display,50);

        ans = new Button("ANS", f, display, 100);
        equals = new Button("=", f, display, 250);


        // Frame settings
        f.setSize(360, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}
    public static void main(String[] args) {
        new Calculator();
    }
}
