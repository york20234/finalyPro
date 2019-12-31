import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class gameFrame extends JFrame implements KeyListener{
    private Container cp;
    private Random rand = new Random();
    private Timer timer,time2;
    private boolean judge =false;
    private int count;
    private int min =60;

    private JLabel score = new JLabel("Score:");
    private JLabel score1 = new JLabel(Integer.toString(count));
    private JLabel time = new JLabel("Time:");
    private JLabel time1 = new JLabel(Integer.toString(min));
    private JButton start = new JButton("Start");
    private JButton exit = new JButton("Exit");
    private JPanel jpn = new JPanel(new GridLayout(1,8,2,2));

    private ImageIcon img = new ImageIcon("pokeball.png");
    private JLabel jlb = new JLabel();

    private JLabel jlbplay = new JLabel();
    private JPanel jpn1 = new JPanel(null);


    private int jlbplay_x = 200;
    private int jlbplay_y = 700;

    private int bellSize=100;
    private int speedy=50;
    private double rate=1;
    private int speedx=(int)(rate*speedy);
    private int ballX=rand.nextInt(400);
    private int ballY=1;
    private scoreFrame scoreFram;


    public gameFrame(){
     //   scoreFram=sf;
        init();
    }
    public void init(){
        cp=this.getContentPane();
        this.pack();
        this.setLayout(new BorderLayout(3,3));
        this.setBounds(100,100,600,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Pinball Game");

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

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


        jpn.add(score);
        jpn.add(score1);
        jpn.add(time);
        jpn.add(time1);
        jpn.add(start);
        jpn.add(exit);


        jpn1.add(jlbplay);
        jpn1.add(jlb);


        time2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             min--;
             time1.setText(Integer.toString(min)+"s");
            }
        });

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ballX=ballX+speedx;
                ballY=ballY+speedy;
               //撞到左右牆壁反彈
                if(ballX<0||ballX>435){
                    speedx=-speedx;
                }
                //判斷是否為輸，分別是超過球拍時、及球拍左右兩側、當時間到時也判斷為輸
               if(ballY>=jlbplay_y-5&&(ballX < jlbplay_x || ballX > jlbplay_x+(jlbplay.getWidth()-5))||min==0){
                   judge=true;
                   timer.stop();
                   time2.stop();
                   JOptionPane.showMessageDialog(gameFrame.this,"Make persistent efforts." +"\n"+
                           "Score:"+count+"\n"+"Time:"+(60-min)+"s");
                   gameFrame.this.dispose();
                   loginFrame lg = new loginFrame();
                   lg.setVisible(true);
               }
               //當球碰到球拍時，所做的加分
               else if ((ballY>=jlbplay_y-bellSize&&ballX<=jlbplay_x+jlbplay.getWidth()&&ballX>=jlbplay_x)||ballY<=0)
               {
                  if(ballY>=jlbplay_y-bellSize) {
                      count=count+100;
                      score1.setText(Integer.toString(count));
                  }
                  speedy=-speedy;
               }
               jlb.setLocation(ballX,ballY);
               switch (min){
                   case 55:
                       break;
               }

            }
        });





        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
                time2.start();
                start.setEnabled(false);
                exit.setEnabled(false);

            }
        });
        exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

    }
    public void keyPressed(KeyEvent ke){
        switch (ke.getKeyCode()){
            case 37://left
                if(jlbplay_x>0){
                    jlbplay_x=jlbplay_x-40;
                    jlbplay.setLocation(jlbplay_x,jlbplay_y);
                }
                break;
            case 39://right
                if (jlbplay_x<430) {
                    jlbplay_x = jlbplay_x + 40;
                    jlbplay.setLocation(jlbplay_x, jlbplay_y);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent ke){

    }
    public void keyTyped(KeyEvent ke){

    }
    public String getCount(){

        return n;
    }


}
