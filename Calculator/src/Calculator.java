import javax.swing.*;
public class Calculator{

    public Calculator(){

        JFrame f = new JFrame();

        JButton one = new JButton("1");

        one.setBounds(0,0,100,40);
        JButton two = new JButton("2");
        two.setBounds(100,0,100,40);
        JButton three = new JButton("3");
        three.setBounds(200,0,100,40);
        JButton four = new JButton("4");
        four.setBounds(0,40,100,40);
        JButton five = new JButton("5");
        five.setBounds(100,40,100,40);
        JButton six = new JButton("6");
        six.setBounds(200,40,100,40);
        JButton seven = new JButton("7");
        seven.setBounds(0,80,100,40);
        JButton eight = new JButton("8");
        eight.setBounds(100,80,100,40);
        JButton nine = new JButton("9");
        nine.setBounds(200,80,100,40);
        JButton zero = new JButton("0");
        zero.setBounds(100,120,100,40);


        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(one);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(zero);

        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}