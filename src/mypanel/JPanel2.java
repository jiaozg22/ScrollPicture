package mypanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import container.ImgCanvas;

public class JPanel2 extends JPanel {

	
	private static final long serialVersionUID = -3911185460276096704L;
	private ImageIcon bg_top=new ImageIcon("img/bg_top.jpg");
	
	//private ImgCanvas imgCanvas=new ImgCanvas();
	
	/**
	 * @author jiao�����̻߳���ͼƬ��˼·�ο������³���
	 * Java�����߳�ʵ�ִ��й���Ч����Label��ǩ
	 * 
	 * @author �嶷�� <��ת���뱣�����ߺͳ���>
	 * @blog http://blog.csdn.net/mq612
	 */

	public JPanel2(){
		this.setBackground(Color.BLUE);
		
		this.setLayout(null);
	}
	
//	 public void paintComponent(Graphics g)
//     {
//        int x=0,y=0;
//        
//        g.drawImage(bg_top.getImage(),x,y,getSize().width,getSize().height,this); 
//     }

}
