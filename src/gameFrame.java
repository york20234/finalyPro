import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameFrame extends JFrame {
    private Container cp;

    private JLabel score = new JLabel("Score:");
    private JLabel score1 = new JLabel("60");
    private JLabel time = new JLabel("Time:");
    private JLabel time1 = new JLabel("60");
    private JButton start = new JButton("Start");
    private JButton exit = new JButton("Exit");
    private JPanel jpn = new JPanel(new GridLayout(1,8,2,2));

    private JPanel jpn1 = new JPanel();

    public gameFrame(){
        init();
    }
    public void init(){
        cp=this.getContentPane();
        this.setLayout(new BorderLayout(3,3));
        this.setBounds(100,100,600,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cp.add(jpn,BorderLayout.NORTH);
        cp.add(jpn1,BorderLayout.CENTER);

        score.setBackground(new Color(233,233,200));
        score.setOpaque(true);
        score1.setBackground(new Color(233,233,200));
        score1.setOpaque(true);
        time.setBackground(new Color(233,233,200));
        time.setOpaque(true);
        time1.setBackground(new Color(233,233,200));
        time1.setOpaque(true);

        jpn.add(score);
        jpn.add(score1);
        jpn.add(time);
        jpn.add(time1);
        jpn.add(start);
        jpn.add(exit);




        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
