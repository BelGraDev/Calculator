import javax.swing.*;
import java.awt.event.*;

public class numberButton implements ActionListener{

    private final int WIDTH= 100;
    private final int HEIGHT = 40;

    public int x = 0;
    public int y = 0;
    public int counter = 0;
    private JButton jb;
    private JTextField display;

    public numberButton(String content, JFrame jf){

        int w = this.WIDTH;
        jb = new JButton(content);
        jb.setBounds(x, y, w, this.HEIGHT);
        jb.addActionListener(this);
        display = new JTextField();
        jf.add(jb);


        if(counter%3== 0){
            y+= 40;
            x = 0;
        } 
        counter++;
        x+=w;


    }
    public JButton getButton(){

        return jb;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        // Append the clicked button text to the display
        display.setText(display.getText() + command);
    }

}