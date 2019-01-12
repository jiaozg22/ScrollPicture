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

import conf.SetupConf;
import container.ImgCanvas;
import mypanel.JPanel1;
import mypanel.JPanel2;
import mypanel.JPanel_Welcome;


public class Startup extends JFrame implements ActionListener, ItemListener, ControllerEventListener, CaretListener, ChangeListener{
	
	private static final long serialVersionUID = 7532194203033581947L;

	private Container container=null;
	
	
	private ImageIcon bi_start=new ImageIcon("img/b_welstart.png");
	private ImageIcon bi_stop=new ImageIcon("img/b_welstop.png");
	
	private JButton welstart =new JButton(bi_start);
	private JButton welstop =new JButton(bi_stop);
	
    
	private JPanel1 jpanel1=new  JPanel1();	
	private JPanel2 jpanel2=new  JPanel2();	
	
	public Startup(String title)
	{
		super(title); 
		/* �رհ�ť��ʵ�֡��� */ 
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
        
    	SetupConf.init();
		
	}
	
	public void initComponents(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		//������������
		container=getContentPane();//��ȡ����
		container.setLayout(null);//���ò���Ϊ�Զ��岼�ַ�ʽ
		container.setBackground(Color.BLUE);//���ñ���ɫΪ��ɫ
		
		
		//���ÿ��ͷ��japnel1����
		jpanel1.setBounds((int)SetupConf.jpanel1X,(int)SetupConf.jpanel1Y, (int)SetupConf.jpanel1W, (int)SetupConf.jpanel1H);//��λͷ��jpanel1
		//jpanel1.setOpaque(true);
		
		
		SetupConf.setJpanel1W(bi_start.getIconWidth());
		SetupConf.setJpanel1H(bi_start.getIconHeight());
		
		
		welstart.setBounds((int)SetupConf.jpanel2W/2-bi_start.getIconWidth()/2, (int)SetupConf.jpanel2H*4/5, (int)bi_start.getIconWidth(), (int)bi_start.getIconHeight());
		welstart.setOpaque(true);
		welstart.setVisible(false);
		jpanel2.add(welstart);
		
		welstop.setBounds((int)SetupConf.jpanel2W/2-bi_start.getIconWidth()/2, (int)SetupConf.jpanel2H*4/5, (int)bi_start.getIconWidth(), (int)bi_start.getIconHeight());
		welstop.setOpaque(false);
		jpanel2.add(welstop);

		container.add(jpanel1);
		
		
		jpanel2.setBounds((int)SetupConf.jpanel2X,(int)SetupConf.jpanel2Y, (int)SetupConf.jpanel2W, (int)SetupConf.jpanel2H);//��λͷ��jpanel1
		container.add(jpanel2);
	}
	
	public void register(){
		welstart.setActionCommand("welstart");  // ���ÿ�����
		welstart.addActionListener(this);//ע��ʱ�������;
		
		
		welstop.setActionCommand("welstop");  // ���ÿ�����
		welstop.addActionListener(this);//ע��ʱ�������;
		
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
		if (e.getActionCommand().equals("welstart")){
			ImgCanvas.setMark(!ImgCanvas.isMark());
			
			welstop.setVisible(true);
			welstart.setVisible(false);
			
		}
		
		if (e.getActionCommand().equals("welstop")){
			ImgCanvas.setMark(!ImgCanvas.isMark());
			
			welstart.setVisible(true);
			welstop.setVisible(false);
			
		}
		
	}
	
	public static void main(String[] args){
		Startup startup=new Startup("��ǩ���");
		
		startup.setBounds((int)SetupConf.framX, (int)SetupConf.framY, (int)SetupConf.framW, (int)SetupConf.framH);
		
		startup.setVisible(true);
			
	}

}
