import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class Button implements ActionListener{

    private final int HEIGHT = 40;

    private static int x = 0;
    private static int y = 60;
    public static int counter = 1, counterArray;
    private static String letters = "", textDisplayed = "", operation, ans;
    private JButton jb;
    private JTextField display;
    private double result;
    private static boolean resDisplayed;
    private static double [] numbers = new double[10];

    public Button(String content, JFrame jf, JTextField jtf, int width, String type){

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

        if(type.equals("number")) jb.setBackground(Color.ORANGE);
        else if(type.equals("operator")){
            jb.setBackground(Color.BLACK);
            jb.setForeground(Color.WHITE);
        }else if(type.equals("command")){
            jb.setBackground(Color.darkGray);
            jb.setForeground(Color.WHITE);
        }
        else if(type.equals("equals")) jb.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Clearing the screen in the command that follows the result
        if(resDisplayed){
            textDisplayed = "";
            display.setText("");
            resDisplayed = false;
        } 

        if(counterArray >= 2){

            letters = "";
            textDisplayed = "ERROR: More than two operators";
            display.setText(textDisplayed);
            counterArray = 0;
            return;
        }
        String command = e.getActionCommand();
        // Append the clicked button text to the display
        display.setText(display.getText() + command);

        //Defining CLEAR and DEL buttons

        if(command.equals("CLR")) {
    
            display.setText("");
            letters = "";
            textDisplayed = "";
            counterArray = 0;
            return;

        } else if(command.equals("Del")){

            if(!textDisplayed.isEmpty()){

                if(textDisplayed.length() > 1){
                    letters = textDisplayed.substring(0,textDisplayed.length()-1);
                    if(operation == null){
    
                        numbers[counterArray] = Double.parseDouble(letters);
                        display.setText(letters);
    
                    }else if(textDisplayed.charAt(textDisplayed.length()-1) == operation.charAt(0)){
    
                        numbers[--counterArray] = Double.parseDouble(letters); 
                    }
    
                    textDisplayed = letters;
                    display.setText(letters);
                    return;
                }else{
                    letters = "";
                    textDisplayed = letters;
                    display.setText(textDisplayed);
                }

            }else{
                display.setText("");
            }
            return;

        }else if(command.equals("ANS")){
            letters += ans;
            textDisplayed += ans;
            numbers[counterArray] = Double.parseDouble(ans);
            display.setText(textDisplayed);
            return;

        }else{
            textDisplayed += command;
        }

        //Making the operations 

        if(command.equals("+") || command.equals("-") || command.equals("x") || command.equals("/") || command.equals("=")){
    
            if(!letters.isEmpty()) {
                numbers[counterArray] = Double.parseDouble(letters.trim());
                letters = "";
            } else {
                display.setText("ERROR: Enter a number first");
                return;  // Exit the method if no valid number has been entered
            }

            if(command.equals("=")){

                if(counterArray == 0){
                    result = numbers[counterArray];
                    display.setText(result + "");

                }else{
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

                }

                //Saving the answer if intended to perform more operations
                ans = "" + result;
                counterArray = 0;
                resDisplayed = true;
                

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
