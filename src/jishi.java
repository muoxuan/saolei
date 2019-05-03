import javax.swing.*;

public class jishi implements Runnable {
    public void run(){

    }
    private int n;
    public jishi(){}
    public jishi(int n){
        this.n=n;
    }

    public void ss(JFrame jf){
        int i=0;
        String s;
        JLabel jl = new JLabel();
        jl.setBounds(900,0,100,50);
        jf.add(jl);

        while(true) {
            //System.out.println(n);
            if(n==0)
                i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            s="时间："+i+"s";

            if(n==3) {
                n = 0;
                i = 0;

            }
            if(n==1||n==2){
                n = i;
               // System.out.println("chengaozhenlaji");
            }
            if(n==0){
                jl.setText(s);
            }

            //System.out.println(i);
        }
    }
    public void st(){
        Thread.interrupted();
    }

}
