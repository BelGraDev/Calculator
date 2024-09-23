import javax.swing.*;

public class numberButton{

    private int WIDTH = 100;
    private final int HEIGHT = 40;

    public int x = 0;
    public int y = 0;
    public int counter = 0;

    public numberButton(String content){
        int w = this.WIDTH;
        JButton jb = new JButton(content);
        jb.setBounds(x, y, w, this.HEIGHT);

        if(counter%3== 0){
            y+= 40;
            x = 0;
        } 
        counter++;
        x+=w;
    }
}