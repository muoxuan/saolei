import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui {
    public static int leishu=30;
    JButton j1=new JButton();
    JButton [][] j=new JButton[50][50];
    int [][] kind=new int[25][25];
    int wi=595;
    int qishu=0;
    int n;
    boolean wo=true;
    public void start(){
        win();
    }
    public void win(){
        JFrame jf=new JFrame("txt");
        jf.setSize(515*2,588*2);
        jf.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        jf.setLayout(null);

        Font fo=new Font("宋体",Font.BOLD,10);
        Font fo1=new Font("宋体",Font.BOLD,40);
        Font fo2=new Font("宋体",Font.BOLD,15);

        for(int i=0;i<25;i++){
            for(int l=0;l<25;l++){
                j[i][l]=new JButton("");
                j[i][l].setFont(fo);
                j[i][l].setBounds(i*40+8,l*40+45,40,40);
                jf.add(j[i][l]);
            }
        }
        JFrame out=new JFrame("game over!");
        out.setSize(400,200);
        JLabel go=new JLabel("   垃圾，真垃圾");
        out.add(go);
        go.setFont(fo1);

        JFrame win=new JFrame("NB!");
        win.setSize(400,200);
        JLabel nb=new JLabel("   牛逼，真牛逼");
        win.add(nb);
        nb.setFont(fo1);

        JFrame set=new JFrame("设置雷数");
        set.setSize(400,200);
        JLabel set1=new JLabel("默认雷数为30个，雷数为正整数且不超过625个");
        set1.setVerticalAlignment(JLabel.TOP);
        set.add(set1);
        set.setLocationRelativeTo(null);
        JTextArea ls = new JTextArea(1, 3);
        ls.setBounds(150,55,100,50);
        set1.add(ls);
        JButton btn = new JButton("提交");
        btn.setBounds(150,112,100,40);
        set1.add(btn);
        String lei;

        lei="总雷数："+leishu+"  插旗数："+qishu;
        JLabel shengyu = new JLabel(lei);
        shengyu.setBounds(10,0,200,50);
        jf.add(shengyu);


        btn.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == e.BUTTON1) {
                    String s=ls.getText();
                    boolean k=true;
                    for(int i=0;i<s.length();i++){
                        char a=s.charAt(i);
                        int m=(int) a;
                        if(m<48||m>57)
                            k=false;
                    }
                    if(k) {
                        int m=Integer.parseInt(s);
                        if(m>0&&m<625) {
                            leishu = m;
                            wi = 625 - leishu;
                            for (int i = 0; i < 25; i++) {
                                for (int l = 0; l < 25; l++) {
                                    kind[i][l] = 0;
                                }
                            }
                            int mun = 0;
                            while (true) {
                                int f = suiji();
                                int l = suiji();
                                if (kind[f][l] == 0) {
                                    kind[f][l] = 1;
                                    mun++;
                                }
                                if (mun == leishu) break;
                            }
                            for (int i = 0; i < 25; i++) {
                                for (int l = 0; l < 25; l++) {
                                    int finalL1 = l;
                                    int finalI1 = i;
                                    j[finalI1][finalL1].setBackground(Color.white);
                                    j[finalI1][finalL1].setText("");
                                }
                            }
                            set.setVisible(false);
                            wo = true;
                            qishu=0;
                            String le="总雷数："+leishu+"  插旗数："+qishu;
                            shengyu.setText(le);
                        }
                        else{
                            JFrame numerror=new JFrame("");
                            numerror.setSize(220,100);
                            JLabel nume=new JLabel("雷数必须大于0小于等于625");
                            numerror.add(nume);
                            numerror.setVisible(true);
                            numerror.setLocationRelativeTo(null);
                        }
                    }
                    else{
                        JFrame dataerror=new JFrame("");
                        dataerror.setSize(220,100);
                        JLabel dae=new JLabel("雷数必须为数字");
                        dataerror.add(dae);
                        dataerror.setVisible(true);
                        dataerror.setLocationRelativeTo(null);
                    }
                }
            }
        });



    win.setLocationRelativeTo(null);
        out.setLocationRelativeTo(null);
        jf.setLocationRelativeTo(null);

        JButton re=new JButton("重新开始");
        re.setFont(fo2);
        re.setBounds(415,1,100,43);
        jf.add(re);

        JButton se=new JButton("设置雷数");
        se.setFont(fo2);
        se.setBounds(516,1,100,43);
        jf.add(se);

        JButton re1=new JButton("重新开始");
        re1.setFont(fo2);
        re1.setBounds(150,125,100,25);
        go.add(re1);

        JButton re2=new JButton("重新开始");
        re2.setFont(fo2);
        re2.setBounds(150,125,100,25);
        nb.add(re2);

        int mun=0;
        for(int i=0;i<25;i++){
            for(int l=0;l<25;l++){
                kind[i][l]=0;
            }
        }
        while(true){
                int f=suiji();
                int e=suiji();
                if(kind[f][e]==0){
                    kind[f][e]=1;
                    mun++;
                    //j[f][e].setText("1");
                }
                if(mun==leishu)break ;
            }
        retn(re1,out,shengyu);
        retn(re,out,shengyu);
        retn(re2,win,shengyu);
        se.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == e.BUTTON1) {
                    set.setVisible(true);
                    //jishi.st();
                }
            }
        });

        for(int i=0;i<25;i++){
            for(int l=0;l<25;l++){
                int finalL1 = l;
                int finalI1 = i;
                j[finalI1][finalL1].setBackground(Color.white);
                j[i][l].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == e.BUTTON1) {

                            if (kind[finalI1][finalL1] == 0) {
                                j[finalI1][finalL1].setText("");
                                sa(finalI1, finalL1,0,win);
                            }
                            if (kind[finalI1][finalL1] == 1) {
                                j[finalI1][finalL1].setBackground(Color.red);
                                j[finalI1][finalL1].setText("b");
                                if(wo)
                                    out.setVisible(true);
                                wo=false;
                                for (int i = 0; i < 25; i++) {
                                    for (int l = 0; l < 25; l++) {
                                        if (kind[i][l] == 0) {
                                            j[i][l].setBackground(Color.cyan);
                                           // j[i][l].setEnabled(false);
                                        }
                                        if(kind[i][l]==1){
                                            j[i][l].setBackground(Color.red);
                                            j[i][l].setText("b");
                                           // j[i][l].setEnabled(false);
                                        }

                                    }
                                }
                                n=2;
                               // System.out.println("laji"+n);

                            }
                        }
                        if(e.getButton()==e.BUTTON3){
                            if(kind[finalI1][finalL1]==0||kind[finalI1][finalL1]==1) {
                                j[finalI1][finalL1].setBackground(Color.GREEN);
                                j[finalI1][finalL1].setText("Y");
                                kind[finalI1][finalL1] = kind[finalI1][finalL1]+100;
                                qishu++;
                                String lei="总雷数："+leishu+"  插旗数："+qishu;
                                shengyu.setText(lei);
                            }
                            else if(kind[finalI1][finalL1]==100||kind[finalI1][finalL1]==101){
                                j[finalI1][finalL1].setBackground(Color.LIGHT_GRAY);
                                j[finalI1][finalL1].setText("?");
                                kind[finalI1][finalL1] += 100;
                                qishu--;
                                String lei="总雷数："+leishu+"  插旗数："+qishu;
                                shengyu.setText(lei);
                            }
                            else if(kind[finalI1][finalL1]==200||kind[finalI1][finalL1]==201){
                                j[finalI1][finalL1].setBackground(Color.white );
                                j[finalI1][finalL1].setText("");
                                kind[finalI1][finalL1] -=200;
                            }
                        }
                    }
                });
            }
        }


        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        jf.setVisible(true);
        jishi jishi=new jishi(n);
        jishi.ss(jf);
    }
    public static int suiji(){
        int max=25;
        int min=0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }
    public void sa(int finalI1,int finalL1,int kind1,JFrame win) {
        int num = 0;
        if(kind[finalI1][finalL1]!=0&&kind1==1) {
            return;
        }
        j[finalI1][finalL1].setBackground(Color.cyan);
        kind[finalI1][finalL1]=-1;
        wi--;
        if(wi==0){
            if(wo) {
                win.setVisible(true);
                n = 1;
               // System.out.println(n);
            }
            wo=false;
            for (int i = 0; i < 25; i++) {
                for (int l = 0; l < 25; l++) {
                    if (kind[i][l] == 0) {
                        j[i][l].setBackground(Color.cyan);
                    }
                    if  (kind[i][l] == 1) {
                        j[i][l].setBackground(Color.red);
                        j[i][l].setText("b");
                    }
                }
            }
        }
        if (finalI1 - 1 >= 0 && finalL1 - 1 >= 0 && kind[finalI1 - 1][finalL1 - 1] == 1) {
            num++;
        }
        if (finalI1 >= 0 && finalL1 - 1 >= 0 && kind[finalI1][finalL1 - 1] == 1) {
            num++;
        }
        if (finalI1 - 1 >= 0 && finalL1 >= 0 && kind[finalI1 - 1][finalL1] == 1) {
            num++;
        }
        if (finalI1 + 1 < 25 && finalL1 - 1 >= 0 && kind[finalI1 + 1][finalL1 - 1] == 1) {
            num++;
        }
        if (finalI1 - 1 >= 0 && finalL1 + 1 < 25 && kind[finalI1 - 1][finalL1 + 1] == 1) {
            num++;
        }
        if (finalI1 >= 0 && finalL1 + 1 < 25 && kind[finalI1][finalL1 + 1] == 1) {
            num++;
        }
        if (finalI1 + 1 < 25 && finalL1 >= 0 && kind[finalI1 + 1][finalL1] == 1) {
            num++;
        }
        if (finalI1 + 1 < 25 && finalL1 + 1 < 25 && kind[finalI1 + 1][finalL1 + 1] == 1) {
            num++;
        }
        if (num != 0) {
            String s = "" + num;
            j[finalI1][finalL1].setText(s);
            return;
        }

        else {
            if (finalI1 - 1 >= 0 && finalL1 >= 0 && num == 0) {
                if(kind[finalI1-1][finalL1]!=-1)
                    sa(finalI1 - 1, finalL1,1,win);
            }
            if (finalI1 >= 0 && finalL1 - 1 >= 0 && num == 0) {
                if(kind[finalI1][finalL1-1]!=-1)
                    sa(finalI1, finalL1 - 1,1,win);
            }
           if  (finalI1 >= 0 && finalL1 + 1 < 25 && num == 0){
               if(kind[finalI1][finalL1+1]!=-1)
                   sa(finalI1,finalL1+1,1,win);
            }
            if  (finalI1 + 1 < 25 && finalL1 >= 0 && num == 0){
                if(kind[finalI1+1][finalL1]!=-1)
                    sa(finalI1+1,finalL1,1,win);
            }
        }
    }
    public void retn(JButton re,JFrame out,JLabel shengyu){
        re.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.getButton() == e.BUTTON1) {
                    qishu=0;
                    String lei="总雷数："+leishu+"  插旗数："+qishu;
                    shengyu.setText(lei);
                    wi=625-leishu;
                    for(int i=0;i<25;i++){
                        for(int l=0;l<25;l++){
                            kind[i][l]=0;
                        }
                    }
                    int mun=0;
                    while(true){
                        int f=suiji();
                        int l=suiji();
                        if(kind[f][l]==0){
                            kind[f][l]=1;
                            mun++;
                        }
                        if(mun==leishu)break ;
                    }
                    for(int i=0;i<25;i++) {
                        for (int l = 0; l < 25; l++) {
                            int finalL1 = l;
                            int finalI1 = i;
                            j[finalI1][finalL1].setBackground(Color.white);
                            j[finalI1][finalL1].setText("");
                            //j[finalI1][finalL1].setEnabled(true);
                        }
                    }
                    out.setVisible(false);
                    wo=true;
                }
                n=3;
                //System.out.println(n);
            }
        });

    }
}
