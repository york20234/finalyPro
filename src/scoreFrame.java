import javax.swing.*;
import java.awt.*;

public class scoreFrame extends JFrame {
    private Container cp;

    private JLabel rank = new JLabel("Rank");
    private JLabel name = new JLabel("Name");
    private JLabel score = new JLabel("Score");
    private JPanel jpn = new JPanel(new GridLayout(1,7,2,2));
    public scoreFrame(){
        init();
    }
    public void init(){
        cp = this.getContentPane();
        this.setLayout(new BorderLayout(3,3));
        this.setBounds(100,100,500,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
