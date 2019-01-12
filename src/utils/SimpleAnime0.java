package utils;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
/**
 * @author chenpeng
 * @email��ceponline@yahoo.com.cn
 * @version 0.1
 */
public class SimpleAnime0 extends JFrame {

    private static final long serialVersionUID = 1L;

    List<Image> actList=new ArrayList<Image>();

    Image act;

    // �Ƿ���ͼ���ƶ�

    boolean actMoving = false;

    // ��ʼͼ����

    int actPhase = 0;

    Canvas c = new Canvas() {

        private static final long serialVersionUID = 1L;

        /**
         * ����ͼ��ֱ�ӵ���update������˳��˵һ�£�����paint����update, ����update����paint������ֺܺ�����¡�^^��
         */
        public void paint(Graphics g) {
            update(g);
        }

        /**
         * �˷��������ڷ������ʱ����ͼ��
         */
        public void update(Graphics g) {
        	
            if (actMoving) {
            	//for(int i=0;i<10;i++){
            		act=actList.get(actPhase);
            		g
                    .drawImage(act, getWidth() / 2
                            - act.getWidth(null) / 2, getHeight() / 2
                            - act.getHeight(null) / 2, act
                            .getWidth(null), act.getHeight(null), this);
            	//}

            }
         
        }
    };

    /**
     * �򵥶����Ĺ���
     * 
     */
    public SimpleAnime0(boolean isRun) {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        actMoving = isRun;
        setTitle("ͼ��任");
        setSize(400, 400);
        // �趨����Ϊ��ɫ
        setBackground(Color.BLACK);
        //��ֻ��һ��ͼ����ص���ʾ��������ȫ���Զ���һ��Image���飬Ȼ��̬����
        //���ɶ������š�
        String urlstr="";
        URL imageUrl=null;
		
        for(int i=0;i<10;i++){
        	urlstr="img/act"+i+".jpg";
        	imageUrl = getClass().getResource(urlstr);
        	
        	act=Toolkit.getDefaultToolkit().createImage(imageUrl)  ;
        }
       
        
        add(c);

        /**
         * ˳�����һ�£���Swing����Timer�࣬�����趨��������ѭ�������¼��� ����д�����£������ܶ��˻���Ը�����̡߳���
         * 
         * class TimerListener implements ActionListener{ public void
         * actionPerformed(ActionEvent e){ if(!actMoving) return; actPhase =
         * (actPhase == 1) ? 2 : 1; canvas.repaint(); } } javax.swing.Timer t =
         * new javax.swing.Timer(200,new TimerListener()); t.start();
         */

        Thread t = new Thread(new Timer());
        t.start();
    }

    /**
     * �¼�ѭ�������߳�
     * 
     * @author chenpeng
     */
    class Timer implements Runnable {
        public void run() {
        	
//        	while (true) {
//				x -= 1;
//				if (x < -w) {
//					x = w;
//				}
//				this.repaint();
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
        	
        	int i=0;
            while (i<10) {
                if (!actMoving)
                    return;
                actPhase = i++;
                System.out.println(i);
                c.repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    

    /**
     * ������
     * 
     * @param args
     */
    public static void main(String[] args) {
        // ʵ��������,������ѭ���¼�
        SimpleAnime0 sa = new SimpleAnime0(true);
        // ��ʾ����
        sa.setVisible(true);
    }
}