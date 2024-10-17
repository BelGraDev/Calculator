import javax.swing.*;
import java.awt.event.*;

public class Button implements ActionListener{

    private final int HEIGHT = 40;

    private static int x = 0;
    private static int y = 60;
    public static int counter = 1;
    private JButton jb;
    private JTextField display;
    private String letters, ans;
    private char operation;
    private int result, a, b;

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

        if(((JButton) e.getSource()).getText().equals("=")){

            letters = display.getText();

            for(int i = 0; i < letters.length(); i++){
    
    
                if(letters.charAt(i) == '+' ||letters.charAt(i) == '-' ||letters.charAt(i) == '*' ||letters.charAt(i) == '/' ){
    
                    try {
    
                        operation = letters.charAt(i);
                        String [] elements = letters.split("\\" + operation);
                        if(elements.length == 2){
    
                            a = Integer.parseInt(elements[0].trim());
                            b = Integer.parseInt(elements[1].trim());
                            
                        }
                        break;
                    }catch(NumberFormatException nfe){}
                }
    
            }
            switch (operation) {
                case '+':
                    result = a+b;
                    break;
                case '-':
                    result =a-b;
                    break;
                case '/':
                    if(b != 0) result = a/b;
                    else display.setText("ERROR: division by 0");
                    break;
                case '*':
                    result = a*b;
                    break;
                default:
                    break;
            }
            display.setText("" + result);
            

            //saving the anwer if intended to perform more operations
            ans =""+ result;
    
        }else if(((JButton) e.getSource()).getText().equals("CLR")) {

            display.setText("");
            letters = "";
        }
    }
}
