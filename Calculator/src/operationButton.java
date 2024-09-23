import javax.swing.*;

public class operationButton{

    private final int WIDTH = 50;
    private final int HEIGHT = 40;


    public int x = 300;
    public int y = 0;
    public operationButton(String content){

            JButton jb = new JButton(content);
            jb.setBounds(x, y, this.WIDTH, this.HEIGHT);

            y+= this.HEIGHT;

        

    }
}