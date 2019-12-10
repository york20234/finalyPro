import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class scoreFrame extends JFrame {
    private Container cp;
    private JComboBox<String> jcb=new JComboBox<String>();
    private JLabel nt=new JLabel("新台幣");
    private JLabel jlb1=new JLabel(":");
    private JLabel jlb2=new JLabel(":");
    private JTextField jtf=new JTextField();
    private JLabel nts=new JLabel();
    private JButton start=new JButton("Conversion");
    private JButton clean=new JButton("Clean");
    private JButton exit=new JButton("Exit");
    private JLabel annotation=new JLabel("單筆金額不得超過30萬(幣值)");

    public scoreFrame(){
        init();
    }
    private void init(){
        cp = this.getContentPane();
        cp.setLayout(null);
        this.setBounds(5,5,450,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (jcb.getSelectedIndex()) {
                    case 0:
                        Double usd = (Double.parseDouble(jtf.getText()) * 30.76);
                        String i = Double.toString(Math.round((float) (usd * 100)) / 100f);
                        nts.setText(i);
                        break;
                    case 1:
                        Double jpy = (Double.parseDouble(jtf.getText()) * 0.28);
                        String j = Double.toString(Math.round((float) (jpy * 100)) / 100f);
                        nts.setText(j);
                        break;
                    case 2:
                        Double kwr = (Double.parseDouble(jtf.getText()) * 0.028);
                        String kwr2 = Double.toString(Math.round((float) (kwr * 100)) / 100f);
                        nts.setText(kwr2);
                        break;
                    case 3:
                        Double cny = (Double.parseDouble(jtf.getText()) * 4.4);
                        String cny2 = Double.toString(Math.round((float) (cny * 100)) / 100f);
                        nts.setText(cny2);
                        break;
                    case 4:
                        Double eur = (Double.parseDouble(jtf.getText()) *34.12);
                        String eur2 = Double.toString(Math.round((float) (eur * 100)) / 100f);
                        nts.setText(eur2);
                        break;
                    case 5:
                        Double  hkd= (Double.parseDouble(jtf.getText()) *3.942);
                        String hkd2 = Double.toString(Math.round((float) (hkd * 100)) / 100f);
                        nts.setText(hkd2);
                        break;
                    case 6:
                        Double gbp = (Double.parseDouble(jtf.getText()) *34.12);
                        String gbp2 = Double.toString(Math.round((float) (gbp * 100)) / 100f);
                        nts.setText(gbp2);
                        break;
                    case 7:
                        Double aud = (Double.parseDouble(jtf.getText()) *21.25);
                        String aud2 = Double.toString(Math.round((float) (aud * 100)) / 100f);
                        nts.setText(aud2);
                        break;
                    case 8:
                        Double  thb= (Double.parseDouble(jtf.getText()) *1.069);
                        String thb2 = Double.toString(Math.round((float) (thb * 100)) / 100f);
                        nts.setText(thb2);
                        break;
                    case 9:
                        Double  cad= (Double.parseDouble(jtf.getText()) *23.54);
                        String cad2 = Double.toString(Math.round((float) (cad * 100)) / 100f);
                        nts.setText(cad2);
                        break;

                }
            }
        });
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nts.setText("");
                jtf.setText("");
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scoreFrame.this.dispose();
            }
        });
        jcb.setFont(new Font(null,Font.PLAIN,21));
        nt.setFont(new Font(null,Font.PLAIN,25));
        jlb1.setFont(new Font(null,Font.PLAIN,25));
        jlb2.setFont(new Font(null,Font.PLAIN,25));
        jtf.setFont(new Font(null,Font.PLAIN,25));
        nts.setFont(new Font(null,Font.PLAIN,25));
        start.setFont(new Font(null,Font.PLAIN,15));
        clean.setFont(new Font(null,Font.PLAIN,15));
        exit.setFont(new Font(null,Font.PLAIN,15));
        annotation.setFont(new Font(null,Font.PLAIN,15));

        cp.setBackground(new Color(125,155,235));

        jcb.addItem("美元USD");
        jcb.addItem("日圓JPY");
        jcb.addItem("韓圜KRW");
        jcb.addItem("人民幣CNY");
        jcb.addItem("歐元EUR");
        jcb.addItem("港幣HKD");
        jcb.addItem("英鎊GBP");
        jcb.addItem("澳幣AUD");
        jcb.addItem("泰銖THB");
        jcb.addItem("加拿大幣CAD");

        jcb.setBounds(20,100,160,40);
        nt.setBounds(20,160,160,40);
        jlb1.setBounds(185,100,80,40);
        jlb2.setBounds(185,160,80,40);
        jtf.setBounds(195,100,160,40);
        nts.setBounds(195,160,160,40);
        start.setBounds(30,200,120,40);
        clean.setBounds(160,200,120,40);
        exit.setBounds(290,200,120,40);
        annotation.setBounds(140,250,250,40);

        cp.add(jcb);
        cp.add(nt);
        cp.add(jlb1);
        cp.add(jlb2);
        cp.add(jtf);
        cp.add(nts);
        cp.add(start);
        cp.add(clean);
        cp.add(exit);
        cp.add(annotation);
    }
}
