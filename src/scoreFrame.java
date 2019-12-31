import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class scoreFrame extends JFrame {
    private Container cp;
    private gameFrame gameFram;
    private JButton clear = new JButton("Clear");
    private JButton exit = new JButton("Exit");
    private JPanel jpnS = new JPanel(new GridLayout(1, 2, 3, 3));
    private JPanel jpnC = new JPanel(new GridLayout(8, 1, 3, 3));
    private JLabel rank[] = new JLabel[5];
    private int score[]=new int[5];
    private int n;



    public scoreFrame(gameFrame gf) {
        gameFram = gf;
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(410, 150, 250, 400);
        this.setTitle("Rank");
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnS, BorderLayout.SOUTH);
        jpnS.add(clear);
        jpnS.add(exit);

        String n=gameFram.getCount();


        for (int i = 0; i < 5; i++) {
            rank[i] = new JLabel();
            rank[i].setText( (i + 1)+"st" + ":");
            jpnC.add(rank[i]);
        };
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreFrame.this.dispose();
            }
        });
    }

//    public void setCount(int str){
//        int n =0;
//         score[n]=str;
//         n++;
//    }
    }

