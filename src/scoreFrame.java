import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class scoreFrame extends JFrame {
    private Container cp;
    private gameFrame gameFram;
    private JButton clear=new JButton("Clear");
    private JButton exit=new JButton("Exit");
    private JPanel jpnS=new JPanel(new GridLayout(1,2,3,3));
    private JPanel jpnC=new JPanel(new GridLayout(8,1,3,3));
    private JLabel rank[]=new JLabel[5];


    public scoreFrame(gameFrame gf){
        gameFram=gf;
        init();
    }
    private void init(){
        cp=this.getContentPane();
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50,50,250,400);
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnS,BorderLayout.SOUTH);
        jpnS.add(clear);
        jpnS.add(exit);

        for (int i =0;i<5;i++){
            rank[i]=new JLabel();
            rank[i].setText("Player"+(i+1)+":"+"aaa");
            jpnC.add(rank[i]);
        };

    }
}
