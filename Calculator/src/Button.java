import javax.swing.*;
import java.awt.event.*;

public class Button implements ActionListener{

    private final int HEIGHT = 40;

    private static int x = 0;
    private static int y = 60;
    public static int counter = 1, counterArray = 0;
    private static String letters = "", textDisplayed = "", operation;
    private JButton jb;
    private JTextField display;
    private String ans; 
    private double result;
    private static double [] numbers = new double[10];

    public Button(String content, JFrame jf, JTextField jtf, int width){

        jb = new JButton(content);
        jb.setBounds(x, y, width, this.HEIGHT);
        jb.addActionListener(this);
        display = jtf;
        jf.add(jb);


        if(counter%4 == 0){
            y+= this.HEIGHT;
            x = 0;
        } else{

            x+=width;

        }
        counter++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        // Append the clicked button text to the display
        display.setText(display.getText() + command);

        //Defining the current character being displayed


        textDisplayed += command;

        //Defining CLEAR button

        if(command.equals("CLR")) {
    
            display.setText("");
            letters = "";
            counterArray = 0;
            return;
        }

        if(command.equals("Del")){

            letters = textDisplayed.substring(0,textDisplayed.length()-1);
            display.setText(letters);
            return;
        }

        //Making the operations 

        if(command.equals("+") || command.equals("-") || command.equals("x") || command.equals("/") || command.equals("=")){
    
            if(!letters.isEmpty()) {
                numbers[counterArray] = Integer.parseInt(letters.trim());
                letters = "";
            } else {
                display.setText("ERROR: Enter a number first");
                return;  // Exit the method if no valid number has been entered
            }

            if(command.equals("=")){

                double a = numbers[0];
                double b = numbers[1];

                switch (operation) {
                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "/":
                        if(b != 0) result = a / b;
                        else display.setText("ERROR: division by 0");
                        break;

                    case "x":
                        result = a * b;
                        break;
                }
                display.setText("" + result);
                
                //Saving the answer if intended to perform more operations

                ans = "" + result;

                counterArray = 0;
                return;


            }else{

                //Saving the latest operation for handling more than two numbers
                operation = command;
                counterArray++;
            }
        }else{

            letters += command;

        }
    }
}
