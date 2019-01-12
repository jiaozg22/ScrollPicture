package mypanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import conf.SetupConf;
import container.ImgCanvas;

public class JPanel1 extends JPanel {

	
	private static final long serialVersionUID = -3911185460276096704L;
	private ImageIcon bg_top=new ImageIcon("img/bg_top.jpg");
	
	private ImgCanvas imgCanvas=new ImgCanvas();
	
	/**
	 * @author jiao，用线程绘制图片的思路参考自以下程序：
	 * Java中用线程实现带有滚动效果的Label标签
	 * 
	 * @author 五斗米 <如转载请保留作者和出处>
	 * @blog http://blog.csdn.net/mq612
	 */

	public JPanel1(){
		
		this.setLayout(null);
		//this.setBackground(Color.yellow);
		imgCanvas.setBounds((int)SetupConf.imageCanvasX, (int)SetupConf.imageCanvasY, (int)SetupConf.imageCanvasW,(int)SetupConf.imageCanvasH);
		//imgCanvas.setBackground(Color.BLUE);
		
		this.add(imgCanvas);
		
	}
	
//	 public void paintComponent(Graphics g)
//     {
//        int x=0,y=0;
//        
//       g.drawImage(bg_top.getImage(),x,y,getSize().width,getSize().height,this); 
//     }

}
