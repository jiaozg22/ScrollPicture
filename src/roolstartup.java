import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import mypanel.JPanel1;
import mypanel.JPanel_Welcome;


public class roolstartup extends JFrame implements ActionListener, ItemListener, ControllerEventListener, CaretListener, ChangeListener{
	
	private static final long serialVersionUID = 7532194203033581947L;

	private Container container=null;
	private JPanel_Welcome jw=new JPanel_Welcome();
	
	private ImageIcon bi_start=new ImageIcon("img/b_welstart.png");
	private ImageIcon bi_stop=new ImageIcon("img/b_welstop.png");
	
	private JButton welstart =new JButton(bi_start);
	private JButton welstop =new JButton(bi_stop);
	
	
    private static double framX=50;//图片显示坐标
    private static double framY=100;//图片显示坐标
    private static double framW=900;//图片显示宽度
    private static double framH=600;//图片显示高度
    
    private static Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize(); //屏幕宽度，高度

    private static double jpanel1X=0;//面板1
    private static double jpanel1Y=0;//面板1
    private static double jpanel1W=650;//面板1
    private static double jpanel1H=600;//面板1

    
	private JPanel1 jpanel1=new  JPanel1();	
	
	public roolstartup(String title)
	{
		super(title); 
		/* 关闭按钮的实现。。 */ 
		addWindowListener(new WindowAdapter() 
		{ 
			public void windowClosing(WindowEvent e) 
			{ dispose(); } 		
			public void windowClosed(WindowEvent e) 
			{ 
				
				System.exit(0); 
				}		
			}); 
		initParameters();
		initComponents(); 
		register();
	}
	
	
    public void initParameters(){
        
        framW=scrSize.getWidth()*8/10;//图片显示宽度
        framH=scrSize.getHeight()*8/10;//图片显示高度
        
        framX=scrSize.getWidth()/2-framW/2;//图片显示坐标
        framY=scrSize.getHeight()/2-framH/2;//图片显示坐标
		
	}
	
	public void initComponents(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//设置容器属性
		container=getContentPane();//获取容器
		container.setLayout(null);//设置布局为自定义布局方式
		container.setBackground(Color.BLUE);//设置背景色为绿色
		
		
		//设置框架头部japnel1属性
		jpanel1.setBounds(0,0, 670, 400);//定位头部jpanel1
		
		welstart.setBounds(335, 450, bi_start.getIconWidth(), bi_start.getIconHeight());
		welstart.setOpaque(false);
		jpanel1.add(welstart);

		
		container.add(jpanel1);
	}
	
	public void register(){
		
	}
	
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controlChange(ShortMessage event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		roolstartup startup=new roolstartup("抽签软件");
		
		startup.setBounds((int)framX, (int)framY, (int)framW, (int)framH);
		
		startup.setVisible(true);
			
	}

}
