import javax.swing.*;
import java.awt.event.*;

public class Button implements ActionListener{

    private final int HEIGHT = 40;

    private static int x = 0;
    private static int y = 60;
    public static int counter = 1;
    private JButton jb;
    private JTextField display;
    private String letters = "", ans, operation, prevOperation, textDisplayed = "";
    private int result, counterArray  = 0;
    private int [] numbers;

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
        operation = ((JButton) e.getSource()).getText();
        textDisplayed += operation;

        //Defining CLEAR button

        if(operation.equals("CLR")) {
    
            display.setText("");
            letters = "";
            counterArray = 0;
            return;
        }

        if(operation.equals("Del")){

            display.setText(textDisplayed.substring(0,textDisplayed.length()-1));
            return;
        }

        if(operation.matches("\\d")){

            letters += operation;
        }

        //Making the operations 

        if(operation.equals("+") || operation.equals("-") || operation.equals("x") || operation.equals("/") || operation.equals("=")){
    
            if(!letters.isEmpty()) {
                numbers[counterArray] = Integer.parseInt(letters);
                letters = "";
            } else {
                display.setText("ERROR: Enter a number first");
                return;  // Exit the method if no valid number has been entered
            }

            if(operation.equals("=")){

                int a = numbers[0];
                int b = numbers[1];

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

                return;

            }else{

                //Saving the latest operation for handling more than two numbers

                prevOperation = operation;
            }
            counterArray++;
        }
    }
}
