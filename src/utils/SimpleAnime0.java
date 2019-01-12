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
 * @email：ceponline@yahoo.com.cn
 * @version 0.1
 */
public class SimpleAnime0 extends JFrame {

    private static final long serialVersionUID = 1L;

    List<Image> actList=new ArrayList<Image>();

    Image act;

    // 是否令图像移动

    boolean actMoving = false;

    // 初始图像编号

    int actPhase = 0;

    Canvas c = new Canvas() {

        private static final long serialVersionUID = 1L;

        /**
         * 绘制图像，直接调用update方法（顺便说一下，若以paint调用update, 再用update调用paint，会出现很好玩的事。^^）
         */
        public void paint(Graphics g) {
            update(g);
        }

        /**
         * 此方法仅在在发生变更时绘制图形
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
     * 简单动画的构造
     * 
     */
    public SimpleAnime0(boolean isRun) {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        actMoving = isRun;
        setTitle("图像变换");
        setSize(400, 400);
        // 设定背景为黑色
        setBackground(Color.BLACK);
        //这只是一个图像加载的演示，我们完全可以定义一个Image数组，然后动态加载
        //做成动画播放。
        String urlstr="";
        URL imageUrl=null;
		
        for(int i=0;i<10;i++){
        	urlstr="img/act"+i+".jpg";
        	imageUrl = getClass().getResource(urlstr);
        	
        	act=Toolkit.getDefaultToolkit().createImage(imageUrl)  ;
        }
       
        
        add(c);

        /**
         * 顺便介绍一下，在Swing下有Timer类，可以设定运算周期循环触发事件。 大体写法如下，不过很多人还是愿意用线程……
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
     * 事件循环处理线程
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
     * 主函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 实例化本类,并触发循环事件
        SimpleAnime0 sa = new SimpleAnime0(true);
        // 显示窗体
        sa.setVisible(true);
    }
}