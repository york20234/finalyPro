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
    private JPanel jpnC = new JPanel(new GridLayout(5, 1, 3, 3));
    private JLabel rank[] = new JLabel[5];
    private static int score[]=new int[5];

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




        for (int i = 0; i < 5; i++) {
            rank[i] = new JLabel();
            rank[i].setText( "Rank"+(i + 1) + ":"+score[i]);
            rank[i].setFont(new Font(null,Font.PLAIN,40));
            jpnC.add(rank[i]);
        };
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreFrame.this.dispose();
            }
        });
        this.repaint();
    }
    public static void addScore(int scoreval){
        if(scoreval > score[score.length-1]){
            score[score.length-1] =scoreval;
        }
        for(int i =0;i<score.length;i++){
            for(int j =i+1;j<score.length;j++){
                if(score[j]>score[i]){
                   int tmp=score[j];
                       score[j]=score[i];
                       score[i]=tmp;
                }
            }
        }






    }
//    public void setCount(int str){
//        int n =0;
//         score[n]=str;
//         n++;
//    }
    }

