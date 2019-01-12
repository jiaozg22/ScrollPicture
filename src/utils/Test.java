package utils;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Java中用线程实现带有滚动效果的Label标签
 * 
 * @author 五斗米 <如转载请保留作者和出处>
 * @blog http://blog.csdn.net/mq612
 */

public class Test extends JFrame {

	private static final long serialVersionUID = -2397593626990759111L;

	private JPanel pane = null;

	private MoveLabel label = null;

	public Test() {
		super("Test");
		pane = new JPanel();
		label = new MoveLabel("带有滚动效果的标签");
		pane.add(label);
		this.getContentPane().add(pane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		new Test();
	}

	/**
	 * 带有滚动效果的Label标签，可继续拓展很多特效，例如颜色变换、速度变换等
	 */
	private class MoveLabel extends JLabel implements Runnable {

		private static final long serialVersionUID = 1891684760189602720L;

		private String text = null;

		private Thread thread = null;

		private int x = 0;

		private int w = 0, h = 0;

		public MoveLabel(String text) {
			super(text);
			this.text = text;
			thread = new Thread(this);
			thread.start();
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			super.setText(text);
			this.text = text;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(this.getBackground());
			g.fillRect(0, 0, w = this.getWidth(), h = this.getHeight());
			g.setColor(this.getForeground());
			g.setFont(this.getFont());
			g.drawString(text, x, h - 2);
			//g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		}

		public void run() {
			while (true) {
				x -= 1;
				if (x < -w) {
					x = w;
				}
				this.repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
