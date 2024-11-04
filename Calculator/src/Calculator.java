import javax.swing.*;


public class Calculator{

    public static final String [] type = {"number", "operator", "command", "equals"};
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
        one = new Button("1", f, display,100,type[0]);
        two = new Button("2", f, display,100,type[0]);
        three = new Button("3", f, display,100,type[0]);

        plus = new Button("+", f, display,50,type[1]);

        four = new Button("4", f, display,100,type[0]);
        five = new Button("5", f, display,100,type[0]);
        six = new Button("6", f, display,100,type[0]);

        minus = new Button("-", f, display,50,type[1]);


        seven = new Button("7", f, display,100,type[0]);
        eight = new Button("8", f, display,100,type[0]);
        nine = new Button("9", f, display,100,type[0]);

        mult = new Button("x", f, display,50,type[1]);
        
        clear = new Button("CLR", f, display, 100,type[2]);
        zero = new Button("0", f, display,100,type[0]);
        delete = new Button("Del", f, display, 100,type[2]);

        div = new Button("/", f, display,50,type[1]);

        ans = new Button("ANS", f, display, 100,type[2]);
        equals = new Button("=", f, display, 250,type[3]);


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
