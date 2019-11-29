import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class gameFrame extends JFrame {
    private Container cp;
    private Random rand = new Random();
    private Timer timer;
    private boolean judge =false;
    private int count=0;

    private JLabel score = new JLabel("Score:");
    private JLabel score1 = new JLabel(Integer.toString(count));
    private JLabel time = new JLabel("Time:");
    private JLabel time1 = new JLabel("60");
    private JButton start = new JButton("Start");
    private JButton exit = new JButton("Exit");
    private JPanel jpn = new JPanel(new GridLayout(1,8,2,2));

    private ImageIcon img = new ImageIcon("59040f3fc49fd.png");
    private JLabel jlb = new JLabel();

    private JLabel jlbplay = new JLabel();
    private JPanel jpn1 = new JPanel(null);

    private JButton right = new JButton("Right");
    private JButton left = new JButton("Left");

    private int jlbplay_x = 200;
    private int jlbplay_y = 650;

    private int bellSize=100;
    private int speedy=50;
    private double rate=1;
    private int speedx=(int)(rate*speedy);
    private int ballX=rand.nextInt(400);
    private int ballY=1;

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


        jlbplay.setLocation(jlbplay_x,jlbplay_y);
        jlbplay.setSize(150,30);
        jlbplay.setBackground(new Color(233 ,20,25));
        jlbplay.setOpaque(true);

        Image img1 = img.getImage();
        Image newing = img1.getScaledInstance(bellSize, bellSize, Image.SCALE_SMOOTH);
        img = new ImageIcon(newing);

        jlb.setIcon(img);
        jlb.setBounds(ballX,ballY,img.getIconWidth(),img.getIconHeight());
        right.setBounds(480,700,100,30);
        left.setBounds(0,700,100,30);

        jpn.add(score);
        jpn.add(score1);
        jpn.add(time);
        jpn.add(time1);
        jpn.add(start);
        jpn.add(exit);


        jpn1.add(jlbplay);
        jpn1.add(jlb);
        jpn1.add(right);
        jpn1.add(left);


        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ballX=ballX+speedx;
               ballY=ballY+speedy;
                if(ballX<0||ballX>430){
                    speedx=-speedx;
                }
               if(ballY>=jlbplay_y-30&&(ballX < jlbplay_x || ballX > jlbplay_x+(jlbplay.getWidth()-5))){
                   judge=true;
                   timer.stop();
                   JOptionPane.showMessageDialog(gameFrame.this,"your lose");
                   gameFrame.this.dispose();
                   loginFrame lg = new loginFrame();
                   lg.setVisible(true);
               }else if ((ballY>=jlbplay_y-bellSize&&ballX<=jlbplay_x+jlbplay.getWidth()&&ballX>=jlbplay_x)||ballY<=0)
               {
                  if(ballY>=jlbplay_y-bellSize) {
                      count=count+100;
                      score1.setText(Integer.toString(count));
                  }
                  speedy=-speedy;
               }

               jlb.setLocation(ballX,ballY);

            }
        });



        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jlbplay_x<430) {
                    jlbplay_x = jlbplay_x + 40;
                    jlbplay.setLocation(jlbplay_x, jlbplay_y);
                }
            }
        });
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jlbplay_x>0){
                jlbplay_x=jlbplay_x-40;
                jlbplay.setLocation(jlbplay_x,jlbplay_y);
              }
            }
        });


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

    }
}
