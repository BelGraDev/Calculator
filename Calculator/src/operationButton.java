import javax.swing.*;
import java.awt.event.*;

public class operationButton implements ActionListener{

    private final int WIDTH = 50;
    private final int HEIGHT = 40;



    public int x = 300;
    public int y = 0;
    private JButton jb;
    private JTextField display;

    public operationButton(String content, JFrame jf){

        jb = new JButton(content);
        jb.setBounds(x, y, this.WIDTH, this.HEIGHT);
        jb.addActionListener(this);
        display = new JTextField();
        jf.add(jb);

        y+= this.HEIGHT;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        
        // Append the clicked button text to the display
        display.setText(display.getText() + command);
    }
    
}